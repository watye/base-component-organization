package com.talelife.base.component.organization.web.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

/**
 * 租户表
 * 
 * @author lwy
 * @email watye.qq.com
 * @date 2020-03-17 13:42:24
 */
public class TenantInfoQuery implements Serializable{

	private static final long serialVersionUID = 514492454657232277L;
	/**
	 * 租户名称
	 */
	@ApiModelProperty(value = "租户名称")
	private String tenantName;
	/**
	 * 绑定手机号
	 */
	@ApiModelProperty(value = "绑定手机号")
	private String phone;
	/**
	 * 绑定邮箱
	 */
	@ApiModelProperty(value = "绑定邮箱")
	private String email;
	/**
	 * 是否启用 1是，0否
	 */
	@ApiModelProperty(value = "是否启用 1是，0否")
	private Integer isEnable;
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
	public Integer getIsEnable() {
		return isEnable;
	}
	public void setIsEnable(Integer isEnable) {
		this.isEnable = isEnable;
	}
}