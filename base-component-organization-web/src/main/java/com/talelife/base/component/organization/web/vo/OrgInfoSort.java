package com.talelife.base.component.organization.web.vo;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

/**
 * 组织表
 * 
 * @author lwy
 * @email watye.qq.com
 * @date 2020-03-17 13:42:24
 */
public class OrgInfoSort implements Serializable {

	private static final long serialVersionUID = -6744430504835176430L;
	/**
	 * 部门id
	 */
	@NotNull(message="部门id不能为空")
	private Long orgId;
	/**
	 * 序号
	 */
	@NotNull(message="序号不能为空")
	private Integer sort;
	public Long getOrgId() {
		return orgId;
	}
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
}