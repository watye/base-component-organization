package com.talelife.base.component.organization.web.vo;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

/**
 * 组织表
 * 
 * @author lwy
 * @email watye.qq.com
 * @date 2020-03-17 13:42:24
 */
public class OrgInfoAdd implements Serializable {

	private static final long serialVersionUID = 1487792744136874335L;
	/**
	 * 部门名称
	 */
	@NotBlank(message = "部门名称不能为空")
	@Size(max = 40, message = "部门名称最大40个字符")
	@ApiModelProperty(value = "部门名称")
	private String orgName;
	/**
	 * 排序号
	 */
	@NotNull(message = "排序号不能为空")
	@ApiModelProperty(value = "排序号")
	private Integer sort;
	/**
	 * 父组织id
	 */
	@NotNull(message = "父组织id不能为空")
	@ApiModelProperty(value = "父组织id")
	private Long parentOrgId;
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public Long getParentOrgId() {
		return parentOrgId;
	}
	public void setParentOrgId(Long parentOrgId) {
		this.parentOrgId = parentOrgId;
	}
}