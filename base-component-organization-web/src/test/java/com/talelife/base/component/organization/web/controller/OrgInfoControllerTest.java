package com.talelife.base.component.organization.web.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.talelife.base.component.organization.web.AbstractTest;
import com.talelife.base.component.organization.web.controller.OrganizationInfoController;
import com.talelife.base.component.organization.web.vo.OrgInfoAdd;

public class OrgInfoControllerTest extends AbstractTest{
	@Autowired
	private OrganizationInfoController orgInfoController;
	
	@Test
	public void testSave(){
		OrgInfoAdd add = new OrgInfoAdd();
		add.setOrgName("dept1");
		add.setParentOrgId(0L);
		add.setSort(1);
		orgInfoController.add(add);
	}
	
}
