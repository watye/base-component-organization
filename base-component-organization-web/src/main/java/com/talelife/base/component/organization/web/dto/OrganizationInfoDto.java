package com.talelife.base.component.organization.web.dto;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

/**
 * 组织表
 * 
 * @author lwy
 * @email watye.qq.com
 * @date 2020-03-17 13:42:24
 */
public class OrganizationInfoDto implements Serializable{

	private static final long serialVersionUID = -2311948080966776482L;
	/**
	 * 租户id
	 */
	@ApiModelProperty(value = "租户id")
	private Long tenantId;
	/**
	 * 组织ID
	 */
	@ApiModelProperty(value = "组织ID")
	private Long orgId;
	/**
	 * 部门名称
	 */
	@ApiModelProperty(value = "部门名称")
	private String orgName;
	/**
	 * 父组织id
	 */
	@ApiModelProperty(value = "父组织id")
	private Long parentOrgId;
	/**
	 * 父组织名称
	 */
	@ApiModelProperty(value = "父组织名称")
	private String parentOrgName;
	/**
	 * 排序号
	 */
	private Integer sort;
	/**
	 * 员工数量
	 */
	private Integer memberCount;
	/**
	 * 创建日期
	 */
	private Date gmtCreate;
	public Integer getMemberCount() {
		return memberCount;
	}
	public void setMemberCount(Integer memberCount) {
		this.memberCount = memberCount;
	}
	public Date getGmtCreate() {
		return gmtCreate;
	}
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
	public Long getTenantId() {
		return tenantId;
	}
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
	public Long getOrgId() {
		return orgId;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setParentOrgId(Long parentOrgId) {
		this.parentOrgId = parentOrgId;
	}
	public Long getParentOrgId() {
		return parentOrgId;
	}
	public String getParentOrgName() {
		return parentOrgName;
	}
	public void setParentOrgName(String parentOrgName) {
		this.parentOrgName = parentOrgName;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
}