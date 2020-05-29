package com.talelife.base.component.organization.web.vo;

import java.io.Serializable;
import java.util.Date;

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
public class OrgInfoUpdate implements Serializable{
	private static final long serialVersionUID = 1L;

	/**
	 * 租户id
	 */
	@NotNull(message = "租户id不能为空")
			@ApiModelProperty(value = "租户id")
	private Long tenantId;
	/**
	 * 组织ID
	 */
	@NotNull(message = "组织ID不能为空")
			@ApiModelProperty(value = "组织ID")
	private Long orgId;
	/**
	 * 部门名称
	 */
		@NotBlank(message="部门名称不能为空")
	@Size(max = 40,message = "部门名称最大40个字符")
	@ApiModelProperty(value = "部门名称")
	private String orgName;
	/**
	 * 排序号
	 */
	@NotNull(message = "排序号不能为空")
			@ApiModelProperty(value = "排序号")
	private Integer sort;
	/**
	 * 组织人数
	 */
	@NotNull(message = "组织人数不能为空")
			@ApiModelProperty(value = "组织人数")
	private Integer memberCount;
	/**
	 * 父组织id
	 */
	@NotNull(message = "父组织id不能为空")
			@ApiModelProperty(value = "父组织id")
	private Long parentOrgId;
	/**
	 * id路径
	 */
		@NotBlank(message="id路径不能为空")
	@Size(max = 65535,message = "id路径最大65535个字符")
	@ApiModelProperty(value = "id路径")
	private String idPath;
	/**
	 * 名称路径
	 */
		@NotBlank(message="名称路径不能为空")
	@Size(max = 65535,message = "名称路径最大65535个字符")
	@ApiModelProperty(value = "名称路径")
	private String namePath;
	/**
	 * 是否删除：1是 0否
	 */
	@NotNull(message = "是否删除：1是 0否不能为空")
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
	 * 设置：组织ID
	 */
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
	/**
	 * 获取：组织ID
	 */
	public Long getOrgId() {
		return orgId;
	}
	/**
	 * 设置：部门名称
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	/**
	 * 获取：部门名称
	 */
	public String getOrgName() {
		return orgName;
	}
	/**
	 * 设置：排序号
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	/**
	 * 获取：排序号
	 */
	public Integer getSort() {
		return sort;
	}
	/**
	 * 设置：组织人数
	 */
	public void setMemberCount(Integer memberCount) {
		this.memberCount = memberCount;
	}
	/**
	 * 获取：组织人数
	 */
	public Integer getMemberCount() {
		return memberCount;
	}
	/**
	 * 设置：父组织id
	 */
	public void setParentOrgId(Long parentOrgId) {
		this.parentOrgId = parentOrgId;
	}
	/**
	 * 获取：父组织id
	 */
	public Long getParentOrgId() {
		return parentOrgId;
	}
	/**
	 * 设置：id路径
	 */
	public void setIdPath(String idPath) {
		this.idPath = idPath;
	}
	/**
	 * 获取：id路径
	 */
	public String getIdPath() {
		return idPath;
	}
	/**
	 * 设置：名称路径
	 */
	public void setNamePath(String namePath) {
		this.namePath = namePath;
	}
	/**
	 * 获取：名称路径
	 */
	public String getNamePath() {
		return namePath;
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
