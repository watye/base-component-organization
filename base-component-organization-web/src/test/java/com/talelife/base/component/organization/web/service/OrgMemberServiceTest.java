package com.talelife.base.component.organization.web.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.talelife.base.component.organization.dao.entity.OrganizationMember;
import com.talelife.base.component.organization.web.AbstractTest;
/**
 * 
 * @author lwy
 *
 */
public class OrgMemberServiceTest extends AbstractTest{
	@Autowired
	private OrganizationMemberService orgMemberService;
	
	@Test
	public void testSave(){
		OrganizationMember entity = new OrganizationMember();
		orgMemberService.save(entity);
	}
	
	@Test
	public void testGetById(){
		orgMemberService.getById(1L);
	}
	
	@Test
	public void testGetByIds(){
		List<Long> ids = new ArrayList<>();
		ids.add(1L);
		ids.add(2L);
		orgMemberService.getByIds(ids);
	}
	
	@Test
	public void testGet(){
		OrganizationMember entity = new OrganizationMember();
		orgMemberService.get(entity);
	}
	
	@Test
	public void testFindList(){
		OrganizationMember entity = new OrganizationMember();
		orgMemberService.findList(entity);
	}
	
	@Test
	public void testFindAll(){
		orgMemberService.findAll();
	}
	
	@Test
	public void testGetCount(){
		OrganizationMember entity = new OrganizationMember();
		orgMemberService.getCount(entity);
	}
	
	@Test
	public void testUpdateById(){
		OrganizationMember entity = new OrganizationMember();
		orgMemberService.updateById(entity);
	}
	
	@Test
	public void testUpdateByIds(){
		OrganizationMember entity = new OrganizationMember();
		orgMemberService.updateByIds(entity,new Long[]{2L,3L});
	}
	
	@Test
	public void testDeleteById(){
		orgMemberService.deleteById(4L);
	}
	
	@Test
	public void testDeleteByIds(){
		orgMemberService.deleteByIds(Arrays.asList(2L,3L));
	}
	
	@Test
	public void testDelete(){
		OrganizationMember entity = new OrganizationMember();
		orgMemberService.delete(entity);
	}
}
