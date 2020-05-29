package com.talelife.base.component.organization.web.vo;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
/**
 * 组织成员表
 * 
 * @author lwy
 * @email watye.qq.com
 * @date 2020-03-17 13:42:24
 */
public class OrgMemberAdd implements Serializable{
	private static final long serialVersionUID = 1L;

	/**
	 * 租户id
	 */
	@NotNull(message = "租户id不能为空")
			@ApiModelProperty(value = "租户id")
	private Long tenantId;
	/**
	 * 主键
	 */
	@NotNull(message = "主键不能为空")
			@ApiModelProperty(value = "主键")
	private Long id;
	/**
	 * 组织id
	 */
	@NotNull(message = "组织id不能为空")
			@ApiModelProperty(value = "组织id")
	private Long orgId;
	/**
	 * 成员id
	 */
	@NotNull(message = "成员id不能为空")
			@ApiModelProperty(value = "成员id")
	private Long memberId;
	/**
	 * 组织名称
	 */
		@NotBlank(message="组织名称不能为空")
	@Size(max = 40,message = "组织名称最大40个字符")
	@ApiModelProperty(value = "组织名称")
	private String orgName;
	/**
	 * 成员名称
	 */
		@NotBlank(message="成员名称不能为空")
	@Size(max = 30,message = "成员名称最大30个字符")
	@ApiModelProperty(value = "成员名称")
	private String memberName;
	/**
	 * 排序
	 */
	@NotNull(message = "排序不能为空")
			@ApiModelProperty(value = "排序")
	private Integer sort;
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
	 * 设置：主键
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：主键
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：组织id
	 */
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
	/**
	 * 获取：组织id
	 */
	public Long getOrgId() {
		return orgId;
	}
	/**
	 * 设置：成员id
	 */
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	/**
	 * 获取：成员id
	 */
	public Long getMemberId() {
		return memberId;
	}
	/**
	 * 设置：组织名称
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	/**
	 * 获取：组织名称
	 */
	public String getOrgName() {
		return orgName;
	}
	/**
	 * 设置：成员名称
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	/**
	 * 获取：成员名称
	 */
	public String getMemberName() {
		return memberName;
	}
	/**
	 * 设置：排序
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	/**
	 * 获取：排序
	 */
	public Integer getSort() {
		return sort;
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
