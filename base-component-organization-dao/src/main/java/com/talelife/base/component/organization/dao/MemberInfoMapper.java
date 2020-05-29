package com.talelife.base.component.organization.dao;

import com.talelife.base.component.organization.dao.entity.MemberInfo;
import com.talelife.framework.mapper.CrudMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户表
 * 
 * @author lwy
 * @email watye.qq.com
 * @date 2020-03-17 13:42:24
 */
@Mapper
public interface MemberInfoMapper extends CrudMapper<MemberInfo> {
	
}
