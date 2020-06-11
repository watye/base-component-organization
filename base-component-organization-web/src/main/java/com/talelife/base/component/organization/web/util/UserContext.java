package com.talelife.base.component.organization.web.util;

import com.talelife.base.component.organization.web.dto.TenantLoginInfo;

/**
 * 登录用户上下文
 * @author lwy
 *
 */
public class UserContext {
	private static ThreadLocal<TenantLoginInfo> threadLocal = new InheritableThreadLocal<>();
	private UserContext(){}
	
	public static TenantLoginInfo getLoginInfo(){
		return threadLocal.get();
	}
	
	public static void setLoginInfo(TenantLoginInfo tenantLoginInfo){
		threadLocal.remove();
		threadLocal.set(tenantLoginInfo);
	}
}