package com.talelife.base.component.organization.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.talelife.framework.interceptor.ResponseResultInterceptor;


@Configuration
public class MvcInterceptorConfig extends WebMvcConfigurationSupport {
	@Autowired
	private ResponseResultInterceptor responseResultInterceptor;
	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(responseResultInterceptor).addPathPatterns("/**").excludePathPatterns("/static/**");
		super.addInterceptors(registry);
	}
	
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
	}

}
