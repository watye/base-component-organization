package com.talelife.base.component.organization.dao;

import org.apache.ibatis.annotations.Mapper;

import com.talelife.base.component.organization.dao.entity.TenantInfo;
import com.talelife.framework.mapper.CrudMapper;

/**
 * 租户表
 * 
 * @author lwy
 * @email watye.qq.com
 * @date 2020-03-17 13:42:24
 */
@Mapper
public interface TenantInfoMapper extends CrudMapper<TenantInfo> {
}
