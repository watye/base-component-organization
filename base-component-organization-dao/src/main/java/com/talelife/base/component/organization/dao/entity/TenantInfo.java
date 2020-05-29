package com.talelife.base.component.organization.dao.entity;

import java.util.Date;

import com.talelife.framework.entity.BaseEntity;

/**
 * 租户表
 * 
 * @author lwy
 * @email watye.qq.com
 * @date 2020-03-17 13:42:24
 */
public class TenantInfo extends BaseEntity {
	private static final long serialVersionUID = 1L;

	/**
	 * 租户id
	 */
	private Long tenantId;
	/**
	 * 租户名称
	 */
	private String tenantName;
	/**
	 * 密码md5值
	 */
	private String password;
	/**
	 * 盐值时间戳
	 */
	private String passwordSalt;
	/**
	 * 绑定手机号
	 */
	private String phone;
	/**
	 * 绑定邮箱
	 */
	private String email;
	/**
	 * 是否启用 1是，0否
	 */
	private Integer isEnable;
	/**
	 * 最后登录时间
	 */
	private Date lastLoginTime;
	/**
	 * 最后登录IP
	 */
	private String lastLoginIp;

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}

	public Long getTenantId() {
		return tenantId;
	}
	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}

	public String getTenantName() {
		return tenantName;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}
	public void setPasswordSalt(String passwordSalt) {
		this.passwordSalt = passwordSalt;
	}

	public String getPasswordSalt() {
		return passwordSalt;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return phone;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}
	public void setIsEnable(Integer isEnable) {
		this.isEnable = isEnable;
	}

	public Integer getIsEnable() {
		return isEnable;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}
}