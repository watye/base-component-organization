package com.talelife.base.component.organization.dao.entity;

import com.talelife.framework.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户表
 * 
 * @author lwy
 * @email watye.qq.com
 * @date 2020-03-17 13:42:24
 */
public class MemberInfo extends BaseEntity {
	private static final long serialVersionUID = 1L;

	/**
	 * 租户id
	 */
	private Long tenantId;
	/**
	 * 成员id
	 */
		private Long memberId;
	/**
	 * 成员名称
	 */
	private String memberName;
	/**
	 * 密码md5值
	 */
	private String password;
	/**
	 * 盐值时间戳
	 */
	private String passwordSalt;
	/**
	 * 性别：1男 2女 0未知
	 */
	private Integer sex;
	/**
	 * 电子邮件
	 */
	private String email;
	/**
	 * 手机号码
	 */
	private String mobile;
	/**
	 * 是否删除：1是 0否
	 */
	private Integer isDeleted;
	/**
	 * 最后登录时间
	 */
	private Date lastLoginTime;
	/**
	 * 最后登录IP
	 */
	private String lastLoginIp;
	/**
	 * 创建时间
	 */
	private Date gmtCreate;
	/**
	 * 更新时间
	 */
	private Date gmtModified;

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}

	public Long getTenantId() {
		return tenantId;
	}
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public Long getMemberId() {
		return memberId;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberName() {
		return memberName;
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
	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getSex() {
		return sex;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMobile() {
		return mobile;
	}
	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Integer getIsDeleted() {
		return isDeleted;
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
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	public Date getGmtModified() {
		return gmtModified;
	}
}
