package com.talelife.base.component.organization.web.dto;

import java.io.Serializable;

/**
 * 租户表
 * 
 * @author lwy
 * @email watye.qq.com
 * @date 2020-03-17 13:42:24
 */
public class TenantLoginInfo implements Serializable{

	private static final long serialVersionUID = -4940273415535971325L;
	/**
	 * 登录token
	 */
	private String token;
	/**
	 * 租户id
	 */
	private Long tenantId;
	/**
	 * 租户名称
	 */
	private String tenantName;
	/**
	 * 绑定手机号
	 */
	private String phone;
	/**
	 * 绑定邮箱
	 */
	private String email;
	public Long getTenantId() {
		return tenantId;
	}
	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
	public String getTenantName() {
		return tenantName;
	}
	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
}