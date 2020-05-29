package com.talelife.base.component.organization.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talelife.base.component.organization.dao.OrganizationMemberMapper;
import com.talelife.base.component.organization.dao.entity.OrganizationMember;
import com.talelife.base.component.organization.web.service.OrganizationMemberService;
import com.talelife.framework.mapper.CrudMapper;

@Service
public class OrganizationMemberServiceImpl implements OrganizationMemberService {
	@Autowired
	private OrganizationMemberMapper mapper;

	@Override
	public CrudMapper<OrganizationMember> getDao() {
		return this.mapper;
	}
}
