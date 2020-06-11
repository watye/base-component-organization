package com.talelife.base.component.organization.web.vo;

import javax.validation.constraints.NotBlank;
/**
 * 
 * @author lwy
 *
 */
public class TenantLoginVO {
	/**
	 * 账号（手机/邮箱）
	 */
	@NotBlank(message="账号不能为空")
	private String account;
	/**
	 * 密码
	 */
	@NotBlank(message="密码不能为空")
	private String password;
	/**
	 * 登录ip
	 */
	private String lastLoginIp;
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLastLoginIp() {
		return lastLoginIp;
	}
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}
	@Override
	public String toString() {
		return "TenantLoginVO [account=" + account + ", password=" + password + ", lastLoginIp=" + lastLoginIp + "]";
	}
}
