package com.talelife.base.component.organization.web.controller;

import java.util.ArrayList;
import java.util.List;

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
import com.talelife.base.component.organization.web.vo.OrgInfoSort;
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
	private static Long rootOrgId = null;
	private static String TOKEN = "f742d123-bdf4-4219-9285-dc89a9296681";
	
	@Test
	public void test1000GetRootOrgInfo() throws Exception{
		String response = mvc.perform(get("/web/orgInfo/rootOrgInfo", null, getTokenParam(TOKEN)))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(MockMvcResultHandlers.print()).andReturn().getResponse().getContentAsString();
		rootOrgId = JSONObject.parseObject(response).getLong("data");
	}
	
	@Test
	public void test1001Save() throws Exception{
		OrgInfoAdd add = new OrgInfoAdd();
		add.setOrgName("dept1");
		add.setParentOrgId(rootOrgId);
		String response = mvc.perform(post("/web/orgInfo/add", JSON.toJSONString(add), getTokenParam(TOKEN)))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(MockMvcResultHandlers.print()).andReturn().getResponse().getContentAsString();
		orgId = JSONObject.parseObject(response).getLong("data");
	}
	
	@Test
	public void test1002Children() throws Exception{
		mvc.perform(get("/web/orgInfo/children/"+orgId,null, getTokenParam(TOKEN)))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void test1003GetOrgInfo() throws Exception{
		mvc.perform(get("/web/orgInfo/"+orgId,null, getTokenParam(TOKEN)))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void test1004Update() throws Exception{
		OrgInfoUpdate edit = new OrgInfoUpdate();
		edit.setOrgName("dept_ud1");
		edit.setParentOrgId(452792944735293522L);
		mvc.perform(put("/web/orgInfo/"+orgId,JSON.toJSONString(edit), getTokenParam(TOKEN)))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void test1005Page() throws Exception{
		PageQueryParameter<OrgInfoQuery> pageQuery = new PageQueryParameter<>();
		OrgInfoQuery infoQuery = new OrgInfoQuery();
		infoQuery.setParentOrgId(0L);
		pageQuery.setQuery(infoQuery);
		mvc.perform(post("/web/orgInfo/page", JSON.toJSONString(pageQuery), getTokenParam(TOKEN)))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(MockMvcResultHandlers.print()).andReturn();
	}
	
	@Test
	public void test1006BatchSort() throws Exception{
		List<OrgInfoSort> orgInfoSorts = new ArrayList<>();
		OrgInfoSort sort = new OrgInfoSort();
		sort.setOrgId(orgId);
		sort.setSort(1);
		orgInfoSorts.add(sort);
		
		mvc.perform(put("/web/orgInfo/batchSort",JSON.toJSONString(orgInfoSorts), getTokenParam(TOKEN)))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void test1007Delete() throws Exception{
		mvc.perform(delete("/web/orgInfo/"+orgId,null, getTokenParam(TOKEN)))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(MockMvcResultHandlers.print());
	}
}
