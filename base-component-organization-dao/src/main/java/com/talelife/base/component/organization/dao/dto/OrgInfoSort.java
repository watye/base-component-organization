package com.talelife.base.component.organization.dao.dto;

import java.io.Serializable;

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
	private Long orgId;
	/**
	 * 序号
	 */
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