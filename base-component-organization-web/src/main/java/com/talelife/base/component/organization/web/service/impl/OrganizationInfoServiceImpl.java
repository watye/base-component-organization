package com.talelife.base.component.organization.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imadcn.framework.idworker.generator.IdGenerator;
import com.talelife.base.component.organization.dao.OrganizationInfoMapper;
import com.talelife.base.component.organization.dao.entity.OrganizationInfo;
import com.talelife.base.component.organization.dao.entity.TenantInfo;
import com.talelife.base.component.organization.web.service.OrganizationInfoService;
import com.talelife.framework.enums.YesNoEnum;
import com.talelife.framework.mapper.CrudMapper;
import com.talelife.framework.util.EntityUtils;

@Service
public class OrganizationInfoServiceImpl implements OrganizationInfoService {
	@Autowired
	private OrganizationInfoMapper mapper;
	@Autowired
	private IdGenerator idGenerator;
	@Override
	public CrudMapper<OrganizationInfo> getDao() {
		return this.mapper;
	}
	
	@Override
	public boolean save(OrganizationInfo entity) {
		
		entity.setOrgId(idGenerator.nextId());
		entity.setIsDeleted(YesNoEnum.NO.getValue());
		entity.setMemberCount(0);
		entity.setIdPath(String.format("%s,", entity.getOrgId()));
		entity.setNamePath(entity.getOrgName());
		EntityUtils.setCreateProperty(entity);
		return OrganizationInfoService.super.save(entity);
	}


	@Override
	public void addTopOrgInfo(TenantInfo tenantInfo) {
		OrganizationInfo orgInfo = new OrganizationInfo();
		orgInfo.setOrgId(idGenerator.nextId());
		orgInfo.setTenantId(tenantInfo.getTenantId());
		orgInfo.setOrgName(tenantInfo.getTenantName());
		orgInfo.setIsDeleted(YesNoEnum.NO.getValue());
		orgInfo.setMemberCount(0);
		orgInfo.setIdPath(String.format("%s,", orgInfo.getOrgId()));
		orgInfo.setNamePath(orgInfo.getOrgName());
		orgInfo.setSort(0);
		orgInfo.setParentOrgId(0L);
		EntityUtils.setCreateProperty(orgInfo);
		save(orgInfo);
	}
}
