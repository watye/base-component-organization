package com.talelife.base.component.organization.web.service;

import com.talelife.base.component.organization.dao.entity.TenantInfo;
import com.talelife.base.component.organization.web.dto.TenantLoginInfo;
import com.talelife.base.component.organization.web.vo.TenantInfoRegister;
import com.talelife.base.component.organization.web.vo.TenantLoginVO;
import com.talelife.framework.service.CrudService;

public interface TenantInfoService extends CrudService<TenantInfo>{

	/**
	 * 注册租户
	 * @param infoRegister
	 */
	Long register(TenantInfoRegister infoRegister);

	/**
	 * 启用租户
	 * @param tenantId
	 */
	void start(Long tenantId);
	
	/**
	 * 停用租户
	 * @param tenantId
	 */
	void stop(Long tenantId);

	/**
	 * 租户登录
	 * @param tenantLoginVO
	 * @return 
	 */
	TenantLoginInfo login(TenantLoginVO tenantLoginVO);
	
	/**
	 * 更新登录信息
	 * @param tenantId
	 * @param lastLoginIp
	 */
	void updateLastLoginInfo(Long tenantId, String lastLoginIp);
}