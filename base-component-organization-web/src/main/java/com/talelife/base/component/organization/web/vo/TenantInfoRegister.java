package com.talelife.base.component.organization.web.vo;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
/**
 * 租户表
 * 
 * @author lwy
 * @email watye.qq.com
 * @date 2020-03-17 13:42:24
 */
public class TenantInfoRegister implements Serializable{

	private static final long serialVersionUID = 1340072713077878411L;
	/**
	 * 租户名称
	 */
	@NotBlank(message="租户名称不能为空")
	@Size(max = 50,message = "租户名称最大50个字符")
	@ApiModelProperty(value = "租户名称")
	private String tenantName;
	/**
	 * 密码md5值
	 */
	@NotBlank(message="密码md5值不能为空")
	@Size(max = 32,message = "密码md5值最大32个字符")
	@ApiModelProperty(value = "密码md5值")
	private String password;
	/**
	 * 绑定手机号
	 */
	@NotBlank(message="绑定手机号不能为空")
	@Size(max = 30,message = "绑定手机号最大30个字符")
	@ApiModelProperty(value = "绑定手机号")
	private String phone;
	/**
	 * 绑定邮箱
	 */
	@Email
	@NotBlank(message="绑定邮箱不能为空")
	@Size(max = 50,message = "绑定邮箱最大50个字符")
	@ApiModelProperty(value = "绑定邮箱")
	private String email;
	public String getTenantName() {
		return tenantName;
	}
	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
}