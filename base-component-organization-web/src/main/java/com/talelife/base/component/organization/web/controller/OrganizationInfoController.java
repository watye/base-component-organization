package com.talelife.base.component.organization.web.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.imadcn.framework.idworker.generator.IdGenerator;
import com.talelife.base.component.organization.dao.entity.OrganizationInfo;
import com.talelife.base.component.organization.web.dto.OrganizationInfoDto;
import com.talelife.base.component.organization.web.enums.ExceptionCode;
import com.talelife.base.component.organization.web.service.OrganizationInfoService;
import com.talelife.base.component.organization.web.util.UserContext;
import com.talelife.base.component.organization.web.vo.OrgInfoAdd;
import com.talelife.base.component.organization.web.vo.OrgInfoQuery;
import com.talelife.base.component.organization.web.vo.OrgInfoUpdate;
import com.talelife.framework.annotation.ResponseResult;
import com.talelife.framework.controller.BaseController;
import com.talelife.framework.entity.Page;
import com.talelife.framework.entity.PageQueryParameter;
import com.talelife.framework.enums.YesNoEnum;
import com.talelife.framework.util.BeanUtils;
import com.talelife.framework.util.ExceptionUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 组织表
 * @author lwy
 *
 */
@Api(value="controller")
@RestController
@ResponseResult
@RequestMapping("/web/orgInfo")
public class OrganizationInfoController extends BaseController {
	@Resource
	private OrganizationInfoService orgInfoService;
	@Autowired
	private IdGenerator idGenerator;
	
	@ApiOperation(value = "新增")
	@PostMapping(value="/add")
	public Long add(@Validated @RequestBody OrgInfoAdd orgInfoAdd) {
		OrganizationInfo entity = BeanUtils.map(orgInfoAdd,OrganizationInfo.class);
		entity.setTenantId(UserContext.getLoginInfo().getTenantId());
		entity.setOrgId(idGenerator.nextId());
		orgInfoService.save(entity);
		return entity.getOrgId();
	}
	
	@ApiOperation(value = "分页查询")
	@PostMapping(value = "/page")
	public Page<OrganizationInfoDto> page(@Validated @RequestBody PageQueryParameter<OrgInfoQuery> pageQuery) {
		OrganizationInfo orgInfo = BeanUtils.map(pageQuery.getQuery(), OrganizationInfo.class);
		long tenantId = UserContext.getLoginInfo().getTenantId();
		orgInfo.setTenantId(tenantId);
		orgInfo.setIsDeleted(YesNoEnum.NO.getValue());
		PageInfo<OrganizationInfo> page = orgInfoService.findListPage(orgInfo,pageQuery.getPageNum(), pageQuery.getPageSize());
		List<OrganizationInfoDto> orgInfoList = BeanUtils.mapAsList(page.getList(), OrganizationInfo.class, OrganizationInfoDto.class);
		return new Page<>(page,orgInfoList);
	}

	@ApiOperation(value = "查询详情")
	@GetMapping(value="/{id}")
	public OrganizationInfoDto getOrgInfo(@PathVariable @ApiParam(value="id") Long id) {
		OrganizationInfo orgInfo = orgInfoService.getById(id);
		if(Objects.isNull(orgInfo)){
			ExceptionUtils.throwParameterException(ExceptionCode.ORG_NOT_FOUNT.getCode(), ExceptionCode.ORG_NOT_FOUNT.getMessage());
		}
		OrganizationInfoDto infoDto = BeanUtils.map(orgInfo, OrganizationInfoDto.class);
		infoDto.setParentOrgName(orgInfo.getParentOrgId()>0?orgInfoService.getById(orgInfo.getParentOrgId()).getOrgName():"");
		return infoDto;
	}

	@ApiOperation(value = "修改")
	@PutMapping(value="/{id}")
	public void update(@PathVariable Long id, @Validated @RequestBody OrgInfoUpdate orgInfoUpdate) {
		orgInfoUpdate.setOrgId(id);
		orgInfoService.updateOrgInfo(orgInfoUpdate);
	}
	
	@ApiOperation(value = "删除")
	@DeleteMapping(value="/{id}")
	public void delete(@PathVariable @ApiParam(value="id") Long id) {
		orgInfoService.deleteById(id);
	}
	
	@ApiOperation(value = "查询子节点")
	@GetMapping(value="/children/{orgId}")
	public List<OrganizationInfoDto> children(@PathVariable @ApiParam(value="节点id") Long orgId) {
		long tenantId = UserContext.getLoginInfo().getTenantId();
		OrganizationInfo query = new OrganizationInfo();
		query.setTenantId(tenantId);
		query.setParentOrgId(orgId);
		query.setIsDeleted(YesNoEnum.NO.getValue());
		
		return BeanUtils.mapAsList(orgInfoService.findList(query,Arrays.asList("tenantId","orgId","orgName","parentOrgId")), OrganizationInfo.class, OrganizationInfoDto.class);
	}
}