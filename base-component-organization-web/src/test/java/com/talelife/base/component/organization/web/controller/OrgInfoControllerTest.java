package com.talelife.base.component.organization.web.controller;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.talelife.base.component.organization.web.AbstractControllerTest;
import com.talelife.base.component.organization.web.vo.OrgInfoAdd;
import com.talelife.base.component.organization.web.vo.OrgInfoQuery;
import com.talelife.base.component.organization.web.vo.OrgInfoUpdate;
import com.talelife.framework.entity.PageQueryParameter;
/**
 * 
 * @author lwy
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrgInfoControllerTest extends AbstractControllerTest{
	private static Long orgId = null;
	private static String TOKEN = "2dfd8cde-df4d-4011-93b5-d6f8b85a8621";
	@Test
	public void testSave() throws Exception{
		OrgInfoAdd add = new OrgInfoAdd();
		add.setOrgName("dept1");
		add.setParentOrgId(0L);
		String response = mvc.perform(post("/web/orgInfo/add", JSON.toJSONString(add), getTokenParam(TOKEN)))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(MockMvcResultHandlers.print()).andReturn().getResponse().getContentAsString();
		orgId = JSONObject.parseObject(response).getLong("data");
	}
	
	@Test
	public void testPage() throws Exception{
		PageQueryParameter<OrgInfoQuery> pageQuery = new PageQueryParameter<>();
		OrgInfoQuery infoQuery = new OrgInfoQuery();
		infoQuery.setParentOrgId(0L);
		pageQuery.setQuery(infoQuery);
		mvc.perform(post("/web/orgInfo/page", JSON.toJSONString(pageQuery), getTokenParam(TOKEN)))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(MockMvcResultHandlers.print()).andReturn();
	}
	
	@Test
	public void testGetOrgInfo() throws Exception{
		orgId = 455365727348592640L;
		mvc.perform(get("/web/orgInfo/"+orgId,null, getTokenParam(TOKEN)))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void testUpdate() throws Exception{
		orgId = 455365727348592640L;
		OrgInfoUpdate edit = new OrgInfoUpdate();
		edit.setOrgName("dept_ud1");
		edit.setParentOrgId(452792944735293522L);
		mvc.perform(put("/web/orgInfo/"+orgId,JSON.toJSONString(edit), getTokenParam(TOKEN)))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void testDelete() throws Exception{
		orgId = 455365727348592640L;
		mvc.perform(delete("/web/orgInfo/"+orgId,null, getTokenParam(TOKEN)))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void testChildren() throws Exception{
		orgId = 452792944735293522L;
		mvc.perform(get("/web/orgInfo/children/"+orgId,null, getTokenParam(TOKEN)))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(MockMvcResultHandlers.print());
	}
}
