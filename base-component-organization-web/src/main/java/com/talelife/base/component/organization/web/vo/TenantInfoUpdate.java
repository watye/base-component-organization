package com.talelife.base.component.organization.web.vo;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

/**
 * 租户表
 * 
 * @author lwy
 * @email watye.qq.com
 * @date 2020-03-17 13:42:24
 */
public class TenantInfoUpdate implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 租户id
	 */
	@NotNull(message = "租户id不能为空")
	@ApiModelProperty(value = "租户id")
	private Long tenantId;
	/**
	 * 租户名称
	 */
	@NotBlank(message = "租户名称不能为空")
	@Size(max = 50, message = "租户名称最大50个字符")
	@ApiModelProperty(value = "租户名称")
	private String tenantName;
	/**
	 * 密码md5值
	 */
	@NotBlank(message = "密码md5值不能为空")
	@Size(max = 32, message = "密码md5值最大32个字符")
	@ApiModelProperty(value = "密码md5值")
	private String password;
	/**
	 * 盐值时间戳
	 */
	@NotBlank(message = "盐值时间戳不能为空")
	@Size(max = 13, message = "盐值时间戳最大13个字符")
	@ApiModelProperty(value = "盐值时间戳")
	private String passwordSalt;
	/**
	 * 绑定手机号
	 */
	@NotBlank(message = "绑定手机号不能为空")
	@Size(max = 30, message = "绑定手机号最大30个字符")
	@ApiModelProperty(value = "绑定手机号")
	private String phone;
	/**
	 * 绑定邮箱
	 */
	@NotBlank(message = "绑定邮箱不能为空")
	@Size(max = 50, message = "绑定邮箱最大50个字符")
	@ApiModelProperty(value = "绑定邮箱")
	private String email;
	/**
	 * 是否启用 1是，0否
	 */
	@NotNull(message = "是否启用 1是，0否不能为空")
	@ApiModelProperty(value = "是否启用 1是，0否")
	private Integer isEnable;
	/**
	 * 最后登录时间
	 */
	@ApiModelProperty(value = "最后登录时间")
	private Date lastLoginTime;
	/**
	 * 最后登录IP
	 */
	@NotBlank(message = "最后登录IP不能为空")
	@Size(max = 20, message = "最后登录IP最大20个字符")
	@ApiModelProperty(value = "最后登录IP")
	private String lastLoginIp;
	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间")
	private Date gmtCreate;
	/**
	 * 更新时间
	 */
	@ApiModelProperty(value = "更新时间")
	private Date gmtModified;

	/**
	 * 设置：租户id
	 */
	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}

	/**
	 * 获取：租户id
	 */
	public Long getTenantId() {
		return tenantId;
	}

	/**
	 * 设置：租户名称
	 */
	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}

	/**
	 * 获取：租户名称
	 */
	public String getTenantName() {
		return tenantName;
	}

	/**
	 * 设置：密码md5值
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 获取：密码md5值
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 设置：盐值时间戳
	 */
	public void setPasswordSalt(String passwordSalt) {
		this.passwordSalt = passwordSalt;
	}

	/**
	 * 获取：盐值时间戳
	 */
	public String getPasswordSalt() {
		return passwordSalt;
	}

	/**
	 * 设置：绑定手机号
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * 获取：绑定手机号
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * 设置：绑定邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 获取：绑定邮箱
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 设置：是否启用 1是，0否
	 */
	public void setIsEnable(Integer isEnable) {
		this.isEnable = isEnable;
	}

	/**
	 * 获取：是否启用 1是，0否
	 */
	public Integer getIsEnable() {
		return isEnable;
	}

	/**
	 * 设置：最后登录时间
	 */
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	/**
	 * 获取：最后登录时间
	 */
	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	/**
	 * 设置：最后登录IP
	 */
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	/**
	 * 获取：最后登录IP
	 */
	public String getLastLoginIp() {
		return lastLoginIp;
	}

	/**
	 * 设置：创建时间
	 */
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	/**
	 * 获取：创建时间
	 */
	public Date getGmtCreate() {
		return gmtCreate;
	}

	/**
	 * 设置：更新时间
	 */
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	/**
	 * 获取：更新时间
	 */
	public Date getGmtModified() {
		return gmtModified;
	}
}
