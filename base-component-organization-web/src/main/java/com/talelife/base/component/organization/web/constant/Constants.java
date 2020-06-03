package com.talelife.base.component.organization.web.constant;

/**
 * 常量
 * 
 * @author lwy
 *
 */
public final class Constants {
	private Constants() {
	}

	public static final String PROJECT_NAME = "base-component-organization";
	/**
	 * token过期时间（10分钟）
	 */
	public static final int TOKEN_EXPIRE_TIME = 10;
	/**
	 * 登录租房
	 */
	public static final String TENANT_INFO = "tenant_info";
	/**
	 * 登录租房
	 */
	public static final String TENANT_TOKEN = "tenant_token";
	/**
	 * token请求头
	 */
	public static final String HEADER_TOKEN = "X-tenant-Token";

}
