package com.talelife.base.component.organization.web.service;

import com.talelife.base.component.organization.dao.entity.TenantInfo;
import com.talelife.base.component.organization.web.dto.TenantLoginInfo;
import com.talelife.base.component.organization.web.vo.TenantInfoRegister;
import com.talelife.base.component.organization.web.vo.TenantLoginVO;
import com.talelife.framework.service.CrudService;
/**
 * 
 * @author lwy
 *
 */
public interface TenantInfoService extends CrudService<TenantInfo>{

	/**
	 * 注册租户
	 * @param infoRegister
	 * @return 租户id
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
	 * @return 登录信息
	 */
	TenantLoginInfo login(TenantLoginVO tenantLoginVO);
	
	/**
	 * 更新登录信息
	 * @param tenantId
	 * @param lastLoginIp
	 */
	void updateLastLoginInfo(Long tenantId, String lastLoginIp);
	
	/**
	 * 查询登录信息
	 * @param token
	 * @return 登录信息
	 */
	TenantLoginInfo getLoginInfo(String token);
	
	/**
	 * 查询token
	 * @param tenantId
	 * @param email
	 * @return 登录的token
	 */
	String getAndUpdateToken(Long tenantId, String email);
}