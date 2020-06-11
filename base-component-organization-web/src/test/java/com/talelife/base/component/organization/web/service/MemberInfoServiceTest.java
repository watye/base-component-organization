package com.talelife.base.component.organization.web.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.talelife.base.component.organization.dao.entity.MemberInfo;
import com.talelife.base.component.organization.web.AbstractTest;
/**
 * 
 * @author lwy
 *
 */
public class MemberInfoServiceTest extends AbstractTest{
	@Autowired
	private MemberInfoService memberInfoService;
	
	@Test
	public void testSave(){
		MemberInfo entity = new MemberInfo();
		memberInfoService.save(entity);
	}
	
	@Test
	public void testGetById(){
		memberInfoService.getById(1L);
	}
	
	@Test
	public void testGetByIds(){
		List<Long> ids = new ArrayList<>();
		ids.add(1L);
		ids.add(2L);
		memberInfoService.getByIds(ids);
	}
	
	@Test
	public void testGet(){
		MemberInfo entity = new MemberInfo();
		memberInfoService.get(entity);
	}
	
	@Test
	public void testFindList(){
		MemberInfo entity = new MemberInfo();
		memberInfoService.findList(entity);
	}
	
	@Test
	public void testFindAll(){
		memberInfoService.findAll();
	}
	
	@Test
	public void testGetCount(){
		MemberInfo entity = new MemberInfo();
		memberInfoService.getCount(entity);
	}
	
	@Test
	public void testUpdateById(){
		MemberInfo entity = new MemberInfo();
		memberInfoService.updateById(entity);
	}
	
	@Test
	public void testUpdateByIds(){
		MemberInfo entity = new MemberInfo();
		memberInfoService.updateByIds(entity,new Long[]{2L,3L});
	}
	
	@Test
	public void testDeleteById(){
		memberInfoService.deleteById(4L);
	}
	
	@Test
	public void testDeleteByIds(){
		memberInfoService.deleteByIds(Arrays.asList(2L,3L));
	}
	
	@Test
	public void testDelete(){
		MemberInfo entity = new MemberInfo();
		memberInfoService.delete(entity);
	}
}
