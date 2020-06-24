package com.talelife.base.component.organization.dao;

import com.talelife.base.component.organization.dao.dto.OrgInfoPath;
import com.talelife.base.component.organization.dao.dto.OrgInfoSort;
import com.talelife.base.component.organization.dao.entity.OrganizationInfo;
import com.talelife.framework.mapper.CrudMapper;

import java.util.List;

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
	 * 更新子组织路径(包括idPath和namePath)
	 * @param orgInfoPath 路径信息
	 * @return 更新数量
	 */
	int updateChilrenOrgPath(OrgInfoPath orgInfoPath);
	
	/**
	 * 更新子组织路径(只更新namePath)
	 * @param orgInfoPath 路径信息
	 * @return 更新数量
	 */
	int updateChilrenNamePath(OrgInfoPath orgInfoPath);
	
	/**
	 * 是否叶子组织
	 * @param idPath 组织路径
	 * @return 叶子节点：true，否则false
	 */
	boolean isLeaf(@Param("idPath") String idPath);

	/**
	 * 排序
	 * @param infoSorts 排序数据
	 */
	void batchSort(List<OrgInfoSort> infoSorts);
}