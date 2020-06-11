package com.talelife.base.component.organization.web.dto;

import java.io.Serializable;

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
}