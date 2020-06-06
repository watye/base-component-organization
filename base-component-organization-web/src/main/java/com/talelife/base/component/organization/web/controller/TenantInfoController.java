package com.talelife.base.component.organization.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.talelife.base.component.organization.dao.entity.TenantInfo;
import com.talelife.base.component.organization.web.dto.TenantInfoDto;
import com.talelife.base.component.organization.web.dto.TenantLoginInfo;
import com.talelife.base.component.organization.web.service.TenantInfoService;
import com.talelife.base.component.organization.web.util.UserContext;
import com.talelife.base.component.organization.web.vo.TenantInfoQuery;
import com.talelife.base.component.organization.web.vo.TenantInfoRegister;
import com.talelife.base.component.organization.web.vo.TenantInfoUpdate;
import com.talelife.base.component.organization.web.vo.TenantLoginVO;
import com.talelife.framework.annotation.ResponseResult;
import com.talelife.framework.controller.BaseController;
import com.talelife.framework.entity.Page;
import com.talelife.framework.entity.PageQueryParameter;
import com.talelife.framework.util.BeanUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 租户表
 * @author lwy
 *
 */
@Api(value="controller")
@RestController
@ResponseResult
@RequestMapping("/web/tenantInfo")
public class TenantInfoController extends BaseController {
	@Resource
	private TenantInfoService tenantInfoService;

	@ApiOperation(value = "注册")
	@PostMapping("/register")
	public Long register(@RequestBody @Validated TenantInfoRegister infoRegister) {
		return tenantInfoService.register(infoRegister);
	}
	
	@ApiOperation(value = "登录")
	@PostMapping("/login")
	public TenantLoginInfo login(@RequestBody @Validated TenantLoginVO tenantLoginVO, HttpServletRequest request) {
		tenantLoginVO.setLastLoginIp(request.getRemoteAddr());
		return tenantInfoService.login(tenantLoginVO);
	}
	
	@ApiOperation(value = "分页查询")
	@PostMapping(value = "/page")
	public Page<TenantInfoDto> page(@RequestBody @Validated PageQueryParameter<TenantInfoQuery> pageQuery) {
		TenantInfo tenantInfo = BeanUtils.map(pageQuery.getQuery(), TenantInfo.class);
		PageInfo<TenantInfo> page = tenantInfoService.findListPage(tenantInfo,pageQuery.getPageNum(), pageQuery.getPageSize());
		List<TenantInfoDto> tenantInfoList = BeanUtils.mapAsList(page.getList(), TenantInfo.class, TenantInfoDto.class);
		return new Page<>(page,tenantInfoList);
	}

	@ApiOperation(value = "查询详情")
	@GetMapping(value="/{id}")
	public TenantInfoDto getTenantInfo(@PathVariable @ApiParam(value="用户id") Long id) {
		TenantInfo tenantInfo = tenantInfoService.getById(id);
		return BeanUtils.map(tenantInfo, TenantInfoDto.class);
	}

	@ApiOperation(value = "修改")
	@PutMapping(value="/{id}")
	public void update(@PathVariable Long id,TenantInfoUpdate tenantInfoUpdate) {
		tenantInfoService.updateById(BeanUtils.map(tenantInfoUpdate,TenantInfo.class));
	}
	
	@ApiOperation(value = "启用")
	@PutMapping(value="/start")
	public void start() {
		tenantInfoService.start(UserContext.getLoginInfo().getTenantId());
	}
	
	@ApiOperation(value = "停用")
	@PutMapping(value="/stop")
	public void stop() {
		tenantInfoService.stop(UserContext.getLoginInfo().getTenantId());
	}
}