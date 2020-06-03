package com.talelife.base.component.organization.web.interceptor;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import com.talelife.base.component.organization.web.constant.Constants;
import com.talelife.base.component.organization.web.dto.TenantLoginInfo;
import com.talelife.base.component.organization.web.enums.ExceptionCode;
import com.talelife.base.component.organization.web.service.TenantInfoService;
import com.talelife.framework.exception.LoginException;


@Component
public class LoginInterceptor implements HandlerInterceptor {
	@Autowired
	private TenantInfoService tenantInfoService;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		 String token = request.getHeader(Constants.HEADER_TOKEN);
		 if(!StringUtils.hasText(token)){
			 throwLoginException(ExceptionCode.TENANT_UNLOGIN);
		 }
		 
		 TenantLoginInfo tenantInfo = tenantInfoService.getLoginInfo(token);
		 if(Objects.isNull(tenantInfo)){
			 throwLoginException(ExceptionCode.TENANT_UNLOGIN);
		 }
		 
		 String loginToken = tenantInfoService.getToken(tenantInfo.getTenantId(), tenantInfo.getEmail());
		 if(!StringUtils.hasText(loginToken)){
			 throwLoginException(ExceptionCode.TENANT_UNLOGIN);
		 }
		 
		 if(!loginToken.equals(token)){
			 throwLoginException(ExceptionCode.LOGIN_ELSEWHERE);
		 }
		 
		return true;
	}
	private void throwLoginException(ExceptionCode exceptionCode) {
		throw new LoginException(exceptionCode.getCode(),exceptionCode.getMessage());
	}

}
