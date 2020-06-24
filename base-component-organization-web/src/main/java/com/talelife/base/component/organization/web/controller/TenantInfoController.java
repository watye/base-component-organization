package com.talelife.base.component.organization.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talelife.base.component.organization.web.dto.TenantLoginInfo;
import com.talelife.base.component.organization.web.service.TenantInfoService;
import com.talelife.base.component.organization.web.util.UserContext;
import com.talelife.base.component.organization.web.vo.TenantInfoRegister;
import com.talelife.base.component.organization.web.vo.TenantLoginVO;
import com.talelife.framework.annotation.ResponseResult;
import com.talelife.framework.controller.BaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

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
	
	@ApiOperation(value = "登录信息")
	@GetMapping(value="/getLoginInfo")
	public TenantLoginInfo getLoginInfo() {
		return UserContext.getLoginInfo();
	}
}