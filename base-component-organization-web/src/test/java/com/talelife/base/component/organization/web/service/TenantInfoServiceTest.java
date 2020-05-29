package com.talelife.base.component.organization.web.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.talelife.base.component.organization.dao.entity.TenantInfo;
import com.talelife.base.component.organization.web.AbstractTest;

public class TenantInfoServiceTest extends AbstractTest{
	@Autowired
	private TenantInfoService tenantInfoService;
	
	@Test
	public void testSave(){
		TenantInfo entity = new TenantInfo();
		tenantInfoService.save(entity);
	}
	
	@Test
	public void testGetById(){
		tenantInfoService.getById(1L);
	}
	
	@Test
	public void testGetByIds(){
		List<Long> ids = new ArrayList<>();
		ids.add(1L);
		ids.add(2L);
		tenantInfoService.getByIds(ids);
	}
	
	@Test
	public void testGet(){
		TenantInfo entity = new TenantInfo();
		tenantInfoService.get(entity);
	}
	
	@Test
	public void testFindList(){
		TenantInfo entity = new TenantInfo();
		tenantInfoService.findList(entity);
	}
	
	@Test
	public void testFindAll(){
		tenantInfoService.findAll();
	}
	
	@Test
	public void testGetCount(){
		TenantInfo entity = new TenantInfo();
		tenantInfoService.getCount(entity);
	}
	
	@Test
	public void testUpdateById(){
		TenantInfo entity = new TenantInfo();
		tenantInfoService.updateById(entity);
	}
	
	@Test
	public void testUpdateByIds(){
		TenantInfo entity = new TenantInfo();
		tenantInfoService.updateByIds(entity,new Long[]{2L,3L});
	}
	
	@Test
	public void testDeleteById(){
		tenantInfoService.deleteById(4L);
	}
	
	@Test
	public void testDeleteByIds(){
		tenantInfoService.deleteByIds(Arrays.asList(2L,3L));
	}
	
	@Test
	public void testDelete(){
		TenantInfo entity = new TenantInfo();
		tenantInfoService.delete(entity);
	}
}
