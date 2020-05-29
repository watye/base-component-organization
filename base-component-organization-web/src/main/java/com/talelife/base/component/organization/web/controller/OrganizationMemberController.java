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
import com.talelife.base.component.organization.dao.entity.OrganizationMember;
import com.talelife.base.component.organization.web.dto.OrganizationMemberDto;
import com.talelife.base.component.organization.web.service.OrganizationMemberService;
import com.talelife.base.component.organization.web.vo.OrgMemberAdd;
import com.talelife.base.component.organization.web.vo.OrgMemberQuery;
import com.talelife.base.component.organization.web.vo.OrgMemberUpdate;
import com.talelife.framework.annotation.ResponseResult;
import com.talelife.framework.controller.BaseController;
import com.talelife.framework.entity.Page;
import com.talelife.framework.entity.PageQueryParameter;
import com.talelife.framework.util.BeanUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 组织成员表
 * @author lwy
 *
 */
@Api(value="controller")
@RestController
@ResponseResult
@RequestMapping("/web/orgMember")
public class OrganizationMemberController extends BaseController {
	@Resource
	private OrganizationMemberService orgMemberService;

	@ApiOperation(value = "分页查询")
	@GetMapping(value = "/page")
	public Page<OrganizationMemberDto> page(@Validated PageQueryParameter<OrgMemberQuery> pageQuery) {
		OrganizationMember orgMember = BeanUtils.map(pageQuery.getQuery(), OrganizationMember.class);
		PageInfo<OrganizationMember> page = orgMemberService.findListPage(orgMember,pageQuery.getPageNum(), pageQuery.getPageSize());
		List<OrganizationMemberDto> orgMemberList = BeanUtils.mapAsList(page.getList(), OrganizationMember.class, OrganizationMemberDto.class);
		return new Page<>(page,orgMemberList);
	}

	@ApiOperation(value = "查询单个")
	@GetMapping(value="/{id}")
	public OrganizationMemberDto getOrgMember(@PathVariable @ApiParam(value="用户id") Long id) {
		OrganizationMember orgMember = orgMemberService.getById(id);
		return BeanUtils.map(orgMember, OrganizationMemberDto.class);
	}

	@ApiOperation(value = "新增")
	@PostMapping(value="/add")
	public void add(@Validated OrgMemberAdd orgMemberAdd) {
		orgMemberService.save(BeanUtils.map(orgMemberAdd,OrganizationMember.class));
	}

	@ApiOperation(value = "修改")
	@PutMapping(value="/{id}")
	public void update(@PathVariable Long id,OrgMemberUpdate orgMemberUpdate) {
		orgMemberService.updateById(BeanUtils.map(orgMemberUpdate,OrganizationMember.class));
	}
	
	@ApiOperation(value = "删除")
	@DeleteMapping(value="/{id}")
	public void delete(@PathVariable @ApiParam(value="id") Long id) {
		orgMemberService.deleteById(id);
	}
}