package com.talelife.base.component.organization.web.vo;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

/**
 * 组织表
 * 
 * @author lwy
 * @email watye.qq.com
 * @date 2020-03-17 13:42:24
 */
public class OrgInfoUpdate implements Serializable {

	private static final long serialVersionUID = 4394514616138008403L;
	/**
	 * 部门id
	 */
	private Long orgId;
	/**
	 * 部门名称
	 */
	@NotBlank(message = "部门名称不能为空")
	@Size(max = 40, message = "部门名称最大40个字符")
	@ApiModelProperty(value = "部门名称")
	private String orgName;
	/**
	 * 父组织id
	 */
	@ApiModelProperty(value = "父组织id")
	private Long parentOrgId;
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public Long getParentOrgId() {
		return parentOrgId;
	}
	public void setParentOrgId(Long parentOrgId) {
		this.parentOrgId = parentOrgId;
	}
	public Long getOrgId() {
		return orgId;
	}
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
}