package com.talelife.base.component.organization.web.service;

import java.util.List;

import com.talelife.base.component.organization.dao.entity.OrganizationInfo;
import com.talelife.base.component.organization.dao.entity.TenantInfo;
import com.talelife.base.component.organization.web.vo.OrgInfoSort;
import com.talelife.base.component.organization.web.vo.OrgInfoUpdate;
import com.talelife.framework.service.CrudService;
/**
 * 
 * @author lwy
 *
 */
public interface OrganizationInfoService extends CrudService<OrganizationInfo>{
	/**
	 * 添加顶级组织
	 * @param tenantInfo
	 */
	void addTopOrgInfo(TenantInfo tenantInfo);

	/**
	 * 更新组织
	 * @param orgInfoUpdate
	 */
	void updateOrgInfo(OrgInfoUpdate orgInfoUpdate);

	/**
	 * 组织排序
	 * @param orgInfoSorts 排序数据
	 */
	void sort(List<OrgInfoSort> orgInfoSorts);
}

