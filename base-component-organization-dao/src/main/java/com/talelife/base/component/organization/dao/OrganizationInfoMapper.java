package com.talelife.base.component.organization.dao;

import com.talelife.base.component.organization.dao.entity.OrganizationInfo;
import com.talelife.framework.mapper.CrudMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 组织表
 * 
 * @author lwy
 * @email watye.qq.com
 * @date 2020-03-17 13:42:24
 */
@Mapper
public interface OrganizationInfoMapper extends CrudMapper<OrganizationInfo> {

	/**
	 * 更新路径
	 * @param parentIdPath 父路径
	 * @return
	 */
	int updatePathByParent(@Param("parentIdPath") String parentIdPath);
	
}
