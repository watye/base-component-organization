package com.talelife.base.component.organization.web.vo;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

/**
 * 用户表
 * 
 * @author lwy
 * @email watye.qq.com
 * @date 2020-03-17 13:42:24
 */
public class MemberInfoUpdate implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 租户id
	 */
	@NotNull(message = "租户id不能为空")
	@ApiModelProperty(value = "租户id")
	private Long tenantId;
	/**
	 * 成员id
	 */
	@NotNull(message = "成员id不能为空")
	@ApiModelProperty(value = "成员id")
	private Long memberId;
	/**
	 * 成员名称
	 */
	@NotBlank(message = "成员名称不能为空")
	@Size(max = 30, message = "成员名称最大30个字符")
	@ApiModelProperty(value = "成员名称")
	private String memberName;
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
	@Size(max = 8, message = "盐值时间戳最大8个字符")
	@ApiModelProperty(value = "盐值时间戳")
	private String passwordSalt;
	/**
	 * 性别：1男 2女 0未知
	 */
	@NotNull(message = "性别：1男 2女 0未知不能为空")
	@ApiModelProperty(value = "性别：1男 2女 0未知")
	private Integer sex;
	/**
	 * 电子邮件
	 */
	@NotBlank(message = "电子邮件不能为空")
	@Size(max = 50, message = "电子邮件最大50个字符")
	@ApiModelProperty(value = "电子邮件")
	private String email;
	/**
	 * 手机号码
	 */
	@NotBlank(message = "手机号码不能为空")
	@Size(max = 20, message = "手机号码最大20个字符")
	@ApiModelProperty(value = "手机号码")
	private String mobile;
	/**
	 * 是否删除：1是 0否
	 */
	@NotNull(message = "是否删除：1是 0否不能为空")
	@ApiModelProperty(value = "是否删除：1是 0否")
	private Integer isDeleted;
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
	 * 设置：成员id
	 */
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	/**
	 * 获取：成员id
	 */
	public Long getMemberId() {
		return memberId;
	}

	/**
	 * 设置：成员名称
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	/**
	 * 获取：成员名称
	 */
	public String getMemberName() {
		return memberName;
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
	 * 设置：性别：1男 2女 0未知
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}

	/**
	 * 获取：性别：1男 2女 0未知
	 */
	public Integer getSex() {
		return sex;
	}

	/**
	 * 设置：电子邮件
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 获取：电子邮件
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 设置：手机号码
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * 获取：手机号码
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * 设置：是否删除：1是 0否
	 */
	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	/**
	 * 获取：是否删除：1是 0否
	 */
	public Integer getIsDeleted() {
		return isDeleted;
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
