package com.talelife.base.component.organization.web;

import java.util.Objects;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;

import com.talelife.base.component.organization.web.constant.Constants;
/**
 * 控制器测试用例基类
 * date: 2020-05-27 15:34:20
 * 
 * @author Liuweiyao
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes=OrganizationApplication.class)
public abstract class AbstractControllerTest{
	protected MockMvc mvc;
	@Autowired
	private WebApplicationContext wac;
	
	protected static HttpHeaders getTokenParam(String token) {
		HttpHeaders headers = new HttpHeaders();
		headers.add(Constants.HEADER_TOKEN, token);
		return headers;
	}
	
	@Before
	public void setupMockMvc(){
		mvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	public static RequestBuilder get(String url) {
		return doHttp(RequestMethod.GET, url, null ,null);
	}
	
	public static RequestBuilder get(String url,String body) {
		return doHttp(RequestMethod.GET, url, body ,null);
	}
	
	public static RequestBuilder get(String url,String body,HttpHeaders headers) {
		return doHttp(RequestMethod.GET, url, body ,headers);
	}
	
	public static RequestBuilder post(String url) {
		return doHttp(RequestMethod.POST, url, null ,null);
	}
	
	public static RequestBuilder post(String url,String body) {
		return doHttp(RequestMethod.POST, url, body ,null);
	}
	
	public static RequestBuilder post(String url,String body,HttpHeaders headers) {
		return doHttp(RequestMethod.POST, url, body ,headers);
	}
	
	public static RequestBuilder put(String url) {
		return doHttp(RequestMethod.PUT, url, null ,null);
	}
	
	public static RequestBuilder put(String url,String body) {
		return doHttp(RequestMethod.PUT, url, body ,null);
	}
	
	public static RequestBuilder put(String url,String body,HttpHeaders headers) {
		return doHttp(RequestMethod.PUT, url, body ,headers);
	}
	
	public static RequestBuilder delete(String url) {
		return doHttp(RequestMethod.DELETE, url, null ,null);
	}
	
	public static RequestBuilder delete(String url,String body) {
		return doHttp(RequestMethod.DELETE, url, body ,null);
	}
	
	public static RequestBuilder delete(String url,String body,HttpHeaders headers) {
		return doHttp(RequestMethod.DELETE, url, body ,headers);
	}
	
	public static RequestBuilder doHttp(RequestMethod requestMethod ,String url,String body,HttpHeaders headers) {
		MockHttpServletRequestBuilder requestBuilder = null;
		switch (requestMethod) {
		case GET:
			requestBuilder = MockMvcRequestBuilders.get(url);
			break;
		case POST:
			requestBuilder = MockMvcRequestBuilders.post(url);
			break;
		case PUT:
			requestBuilder = MockMvcRequestBuilders.put(url);
			break;
		case DELETE:
			requestBuilder = MockMvcRequestBuilders.delete(url);
			break;
		default:
			throw new RuntimeException("requestMethod unknowed");
		}
	
		requestBuilder.contentType(MediaType.APPLICATION_JSON_UTF8)
		.accept(MediaType.APPLICATION_JSON_UTF8);
		if(Objects.nonNull(body)){
			((MockHttpServletRequestBuilder) requestBuilder).content(body.getBytes());
		}
		if(Objects.nonNull(headers)){
			((MockHttpServletRequestBuilder) requestBuilder).headers(headers);
		}
		return requestBuilder;
	}
	
}