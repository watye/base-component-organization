package com.talelife.base.component.organization.web.controller;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.talelife.base.component.organization.web.AbstractControllerTest;
import com.talelife.base.component.organization.web.vo.TenantInfoRegister;
import com.talelife.base.component.organization.web.vo.TenantLoginVO;
/**
 * 
 * @author lwy
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TenantInfoControllerTest extends AbstractControllerTest{
	private static String randomNum = String.valueOf(System.currentTimeMillis()).substring(10);
	private static String token;
	private static TenantInfoRegister infoRegister;
	@Test
	public void test1001Register() throws Exception{
		infoRegister = new TenantInfoRegister();
		infoRegister.setEmail("dev"+randomNum+"@qq.com");
		infoRegister.setPassword("123");
		infoRegister.setPhone("18823660"+randomNum);
		infoRegister.setTenantName("dev1"+randomNum);
		mvc.perform(post("/web/tenantInfo/register", JSON.toJSONString(infoRegister))).andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(MockMvcResultHandlers.print()).andReturn().getResponse().getContentAsString();
	}
	
	@Test
	public void test1002Login() throws Exception{
		TenantLoginVO tenant = new TenantLoginVO();
		tenant.setAccount(infoRegister.getEmail());
		tenant.setPassword(infoRegister.getPassword());
		String response = mvc.perform(post("/web/tenantInfo/login", JSON.toJSONString(tenant))).andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(MockMvcResultHandlers.print()).andReturn().getResponse().getContentAsString();
		JSONObject json = JSONObject.parseObject(response);
		token = json.getJSONObject("data").getString("token");
	}
	
	@Test
	public void test1003Stop() throws Exception{
		mvc.perform(put("/web/tenantInfo/stop",null,getTokenParam(token))).andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void test1004Start() throws Exception{
		mvc.perform(put("/web/tenantInfo/start",null,getTokenParam(token))).andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(MockMvcResultHandlers.print());
	}
}