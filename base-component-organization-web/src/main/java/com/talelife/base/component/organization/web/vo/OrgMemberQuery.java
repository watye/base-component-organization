package com.talelife.base.component.organization.web.vo;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

/**
 * 组织成员表
 * 
 * @author lwy
 * @email watye.qq.com
 * @date 2020-03-17 13:42:24
 */
public class OrgMemberQuery implements Serializable{
	private static final long serialVersionUID = 1L;

	/**
	 * 租户id
	 */
	@ApiModelProperty(value = "租户id")
	private Long tenantId;
	/**
	 * 主键
	 */
	@ApiModelProperty(value = "主键")
	private Long id;
	/**
	 * 组织id
	 */
	@ApiModelProperty(value = "组织id")
	private Long orgId;
	/**
	 * 成员id
	 */
	@ApiModelProperty(value = "成员id")
	private Long memberId;
	/**
	 * 组织名称
	 */
	@ApiModelProperty(value = "组织名称")
	private String orgName;
	/**
	 * 成员名称
	 */
	@ApiModelProperty(value = "成员名称")
	private String memberName;
	/**
	 * 排序
	 */
	@ApiModelProperty(value = "排序")
	private Integer sort;
	/**
	 * 是否删除：1是 0否
	 */
	@ApiModelProperty(value = "是否删除：1是 0否")
	private Integer isDeleted;
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

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
	public Long getTenantId() {
		return tenantId;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
	public Long getOrgId() {
		return orgId;
	}
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	public Long getMemberId() {
		return memberId;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public Integer getSort() {
		return sort;
	}
	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}
	public Integer getIsDeleted() {
		return isDeleted;
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
