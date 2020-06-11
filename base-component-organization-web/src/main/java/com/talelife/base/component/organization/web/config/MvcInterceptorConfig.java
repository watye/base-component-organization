package com.talelife.base.component.organization.web.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.talelife.base.component.organization.web.interceptor.LoginInterceptor;
import com.talelife.framework.interceptor.ResponseResultInterceptor;

/**
 * 
 * @author lwy
 *
 */
@Configuration
public class MvcInterceptorConfig extends WebMvcConfigurationSupport {
	private static final String STATIC_RESOURCE_PATH = "/static/**";
	private static List<String> nonLoginPath = new ArrayList<>();
	static{
		nonLoginPath.add(STATIC_RESOURCE_PATH);
		nonLoginPath.add("/web/tenantInfo/register");
		nonLoginPath.add("/web/tenantInfo/login");
	}
	@Autowired
	private ResponseResultInterceptor responseResultInterceptor;
	@Autowired
	private LoginInterceptor loginInterceptor;
	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(responseResultInterceptor).addPathPatterns("/**").excludePathPatterns(STATIC_RESOURCE_PATH);
		registry.addInterceptor(loginInterceptor).addPathPatterns("/web/**").excludePathPatterns(nonLoginPath);
		super.addInterceptors(registry);
	}
	
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(STATIC_RESOURCE_PATH).addResourceLocations("classpath:/static/");
	}

}
