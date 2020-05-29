package com.talelife.base.component.organization.web.vo;

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
public class OrgInfoQuery implements Serializable{
	private static final long serialVersionUID = 1L;

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
	 * 排序号
	 */
	@ApiModelProperty(value = "排序号")
	private Integer sort;
	/**
	 * 组织人数
	 */
	@ApiModelProperty(value = "组织人数")
	private Integer memberCount;
	/**
	 * 父组织id
	 */
	@ApiModelProperty(value = "父组织id")
	private Long parentOrgId;
	/**
	 * id路径
	 */
	@ApiModelProperty(value = "id路径")
	private String idPath;
	/**
	 * 名称路径
	 */
	@ApiModelProperty(value = "名称路径")
	private String namePath;
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
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public Integer getSort() {
		return sort;
	}
	public void setMemberCount(Integer memberCount) {
		this.memberCount = memberCount;
	}
	public Integer getMemberCount() {
		return memberCount;
	}
	public void setParentOrgId(Long parentOrgId) {
		this.parentOrgId = parentOrgId;
	}
	public Long getParentOrgId() {
		return parentOrgId;
	}
	public void setIdPath(String idPath) {
		this.idPath = idPath;
	}
	public String getIdPath() {
		return idPath;
	}
	public void setNamePath(String namePath) {
		this.namePath = namePath;
	}
	public String getNamePath() {
		return namePath;
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
