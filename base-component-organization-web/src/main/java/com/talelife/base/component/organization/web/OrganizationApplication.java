package com.talelife.base.component.organization.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * 
 * @author lwy
 *
 */
@SpringBootApplication
@MapperScan("com.talelife.base.component.organization.dao")
@EnableSwagger2
@ComponentScan(basePackages = {
		"com.talelife.framework.handler",
		"com.talelife.framework.interceptor",
		"com.talelife.base.component.organization"
		})
public class OrganizationApplication {

	public static void main(String[] args) {
       SpringApplication.run(OrganizationApplication.class, args);
  }


}