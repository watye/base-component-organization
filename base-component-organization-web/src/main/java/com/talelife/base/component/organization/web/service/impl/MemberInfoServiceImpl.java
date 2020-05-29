package com.talelife.base.component.organization.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talelife.base.component.organization.dao.MemberInfoMapper;
import com.talelife.base.component.organization.dao.entity.MemberInfo;
import com.talelife.base.component.organization.web.service.MemberInfoService;
import com.talelife.framework.mapper.CrudMapper;

@Service
public class MemberInfoServiceImpl implements MemberInfoService {
	@Autowired
	private MemberInfoMapper mapper;

	@Override
	public CrudMapper<MemberInfo> getDao() {
		return this.mapper;
	}
}
