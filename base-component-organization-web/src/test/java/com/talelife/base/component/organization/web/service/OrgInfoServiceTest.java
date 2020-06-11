package com.talelife.base.component.organization.web.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.talelife.base.component.organization.dao.entity.OrganizationInfo;
import com.talelife.base.component.organization.web.AbstractTest;
/**
 * 
 * @author lwy
 *
 */
public class OrgInfoServiceTest extends AbstractTest{
	@Autowired
	private OrganizationInfoService orgInfoService;
	
	@Test
	public void testSave(){
		OrganizationInfo entity = new OrganizationInfo();
		orgInfoService.save(entity);
	}
	
	@Test
	public void testGetById(){
		orgInfoService.getById(1L);
	}
	
	@Test
	public void testGetByIds(){
		List<Long> ids = new ArrayList<>();
		ids.add(1L);
		ids.add(2L);
		orgInfoService.getByIds(ids);
	}
	
	@Test
	public void testGet(){
		OrganizationInfo entity = new OrganizationInfo();
		orgInfoService.get(entity);
	}
	
	@Test
	public void testFindList(){
		OrganizationInfo entity = new OrganizationInfo();
		orgInfoService.findList(entity);
	}
	
	@Test
	public void testFindAll(){
		orgInfoService.findAll();
	}
	
	@Test
	public void testGetCount(){
		OrganizationInfo entity = new OrganizationInfo();
		orgInfoService.getCount(entity);
	}
	
	@Test
	public void testUpdateById(){
		OrganizationInfo entity = new OrganizationInfo();
		orgInfoService.updateById(entity);
	}
	
	@Test
	public void testUpdateByIds(){
		OrganizationInfo entity = new OrganizationInfo();
		orgInfoService.updateByIds(entity,new Long[]{2L,3L});
	}
	
	@Test
	public void testDeleteById(){
		orgInfoService.deleteById(4L);
	}
	
	@Test
	public void testDeleteByIds(){
		orgInfoService.deleteByIds(Arrays.asList(2L,3L));
	}
	
	@Test
	public void testDelete(){
		OrganizationInfo entity = new OrganizationInfo();
		orgInfoService.delete(entity);
	}
}
