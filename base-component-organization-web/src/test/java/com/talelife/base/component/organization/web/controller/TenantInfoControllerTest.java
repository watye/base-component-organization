package com.talelife.base.component.organization.web.controller;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.alibaba.fastjson.JSON;
import com.talelife.base.component.organization.web.AbstractControllerTest;
import com.talelife.base.component.organization.web.vo.TenantInfoQuery;
import com.talelife.base.component.organization.web.vo.TenantInfoRegister;
import com.talelife.base.component.organization.web.vo.TenantLoginVO;
import com.talelife.framework.entity.PageQueryParameter;
import com.talelife.framework.entity.Result;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TenantInfoControllerTest extends AbstractControllerTest{
	private static String randomNum = String.valueOf(System.currentTimeMillis()).substring(10);
	private static Long tenantId;
	private static TenantInfoRegister infoRegister;
	@Test
	public void test1001Register() throws Exception{
		infoRegister = new TenantInfoRegister();
		infoRegister.setEmail("dev"+randomNum+"@qq.com");
		infoRegister.setPassword("123");
		infoRegister.setPhone("18823660"+randomNum);
		infoRegister.setTenantName("dev1"+randomNum);
		String response = mvc.perform(post("/web/tenantInfo/register", JSON.toJSONString(infoRegister))).andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(MockMvcResultHandlers.print()).andReturn().getResponse().getContentAsString();
		Result result = JSON.parseObject(response, Result.class);
		tenantId = Long.valueOf(result.getData().toString());
	}
	
	@Test
	public void test1002Login() throws Exception{
		TenantLoginVO tenant = new TenantLoginVO();
		tenant.setAccount(infoRegister.getEmail());
		tenant.setPassword(infoRegister.getPassword());
		mvc.perform(post("/web/tenantInfo/login", JSON.toJSONString(tenant))).andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void test1003Stop() throws Exception{
		mvc.perform(put("/web/tenantInfo/stop/"+tenantId)).andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void test1004Start() throws Exception{
		mvc.perform(put("/web/tenantInfo/start/"+tenantId)).andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void test1005Page() throws Exception{
		PageQueryParameter<TenantInfoQuery> pageQuery = new PageQueryParameter<>();
		pageQuery.setQuery(new TenantInfoQuery());
		mvc.perform(post("/web/tenantInfo/page/",JSON.toJSONString(pageQuery))).andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(MockMvcResultHandlers.print());
	}
	
	/******************** 临时测试 *********************************/
	@Test
	public void testLogin() throws Exception{
		//{"account":"dev652@qq.com","password":"123"}
		TenantLoginVO tenant = new TenantLoginVO();
		tenant.setAccount("dev652@qq.com");
		tenant.setPassword("123");
		mvc.perform(post("/web/tenantInfo/login", JSON.toJSONString(tenant))).andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(MockMvcResultHandlers.print());
	}
}
