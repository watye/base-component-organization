package com.talelife.base.component.organization.web.vo;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.talelife.framework.entity.KeywordQuery;

import io.swagger.annotations.ApiModelProperty;

/**
 * 组织表
 * 
 * @author lwy
 * @email watye.qq.com
 * @date 2020-03-17 13:42:24
 */
public class OrgInfoQuery extends KeywordQuery implements Serializable{

	private static final long serialVersionUID = -506892511687648542L;
	/**
	 * 父组织id
	 */
	@ApiModelProperty(value = "父组织id")
	@NotNull
	private Long parentOrgId;
	public Long getParentOrgId() {
		return parentOrgId;
	}
	public void setParentOrgId(Long parentOrgId) {
		this.parentOrgId = parentOrgId;
	}

}
