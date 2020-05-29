package com.talelife.base.component.organization.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.talelife.base.component.organization.dao.entity.OrganizationInfo;
import com.talelife.base.component.organization.web.dto.OrganizationInfoDto;
import com.talelife.base.component.organization.web.service.OrganizationInfoService;
import com.talelife.base.component.organization.web.vo.OrgInfoAdd;
import com.talelife.base.component.organization.web.vo.OrgInfoQuery;
import com.talelife.base.component.organization.web.vo.OrgInfoUpdate;
import com.talelife.framework.annotation.ResponseResult;
import com.talelife.framework.controller.BaseController;
import com.talelife.framework.entity.Page;
import com.talelife.framework.entity.PageQueryParameter;
import com.talelife.framework.util.BeanUtils;

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

	@ApiOperation(value = "分页查询")
	@GetMapping(value = "/page")
	public Page<OrganizationInfoDto> page(@Validated PageQueryParameter<OrgInfoQuery> pageQuery) {
		OrganizationInfo orgInfo = BeanUtils.map(pageQuery.getQuery(), OrganizationInfo.class);
		PageInfo<OrganizationInfo> page = orgInfoService.findListPage(orgInfo,pageQuery.getPageNum(), pageQuery.getPageSize());
		List<OrganizationInfoDto> orgInfoList = BeanUtils.mapAsList(page.getList(), OrganizationInfo.class, OrganizationInfoDto.class);
		return new Page<>(page,orgInfoList);
	}

	@ApiOperation(value = "查询单个")
	@GetMapping(value="/{id}")
	public OrganizationInfoDto getOrgInfo(@PathVariable @ApiParam(value="用户id") Long id) {
		OrganizationInfo orgInfo = orgInfoService.getById(id);
		return BeanUtils.map(orgInfo, OrganizationInfoDto.class);
	}

	@ApiOperation(value = "新增")
	@PostMapping(value="/add")
	public void add(@Validated OrgInfoAdd orgInfoAdd) {
		orgInfoService.save(BeanUtils.map(orgInfoAdd,OrganizationInfo.class));
	}

	@ApiOperation(value = "修改")
	@PutMapping(value="/{id}")
	public void update(@PathVariable Long id,OrgInfoUpdate orgInfoUpdate) {
		orgInfoService.updateById(BeanUtils.map(orgInfoUpdate,OrganizationInfo.class));
	}
	
	@ApiOperation(value = "删除")
	@DeleteMapping(value="/{id}")
	public void delete(@PathVariable @ApiParam(value="id") Long id) {
		orgInfoService.deleteById(id);
	}
}