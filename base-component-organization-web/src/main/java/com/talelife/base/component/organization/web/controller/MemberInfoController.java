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
import com.talelife.base.component.organization.dao.entity.MemberInfo;
import com.talelife.base.component.organization.web.dto.MemberInfoDto;
import com.talelife.base.component.organization.web.service.MemberInfoService;
import com.talelife.base.component.organization.web.vo.MemberInfoAdd;
import com.talelife.base.component.organization.web.vo.MemberInfoQuery;
import com.talelife.base.component.organization.web.vo.MemberInfoUpdate;
import com.talelife.framework.annotation.ResponseResult;
import com.talelife.framework.controller.BaseController;
import com.talelife.framework.entity.Page;
import com.talelife.framework.entity.PageQueryParameter;
import com.talelife.framework.util.BeanUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 用户表
 * @author lwy
 *
 */
@Api(value="controller")
@RestController
@ResponseResult
@RequestMapping("/web/memberInfo")
public class MemberInfoController extends BaseController {
	@Resource
	private MemberInfoService memberInfoService;

	@ApiOperation(value = "分页查询")
	@GetMapping(value = "/page")
	public Page<MemberInfoDto> page(@Validated PageQueryParameter<MemberInfoQuery> pageQuery) {
		MemberInfo memberInfo = BeanUtils.map(pageQuery.getQuery(), MemberInfo.class);
		PageInfo<MemberInfo> page = memberInfoService.findListPage(memberInfo,pageQuery.getPageNum(), pageQuery.getPageSize());
		List<MemberInfoDto> memberInfoList = BeanUtils.mapAsList(page.getList(), MemberInfo.class, MemberInfoDto.class);
		return new Page<>(page,memberInfoList);
	}

	@ApiOperation(value = "查询单个")
	@GetMapping(value="/{id}")
	public MemberInfoDto getMemberInfo(@PathVariable @ApiParam(value="用户id") Long id) {
		MemberInfo memberInfo = memberInfoService.getById(id);
		return BeanUtils.map(memberInfo, MemberInfoDto.class);
	}

	@ApiOperation(value = "新增")
	@PostMapping(value="/add")
	public void add(@Validated MemberInfoAdd memberInfoAdd) {
		memberInfoService.save(BeanUtils.map(memberInfoAdd,MemberInfo.class));
	}

	@ApiOperation(value = "修改")
	@PutMapping(value="/{id}")
	public void update(@PathVariable Long id,MemberInfoUpdate memberInfoUpdate) {
		memberInfoService.updateById(BeanUtils.map(memberInfoUpdate,MemberInfo.class));
	}
	
	@ApiOperation(value = "删除")
	@DeleteMapping(value="/{id}")
	public void delete(@PathVariable @ApiParam(value="id") Long id) {
		memberInfoService.deleteById(id);
	}
}