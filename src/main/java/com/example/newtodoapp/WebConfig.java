package com.example.newtodoapp;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.newtodoapp.filter.LoginCheckFilter;

import jakarta.servlet.Filter;

@Configuration
public class WebConfig {

	@Bean
	public FilterRegistrationBean loginCheckFilter(){

		FilterRegistrationBean<Filter> filterFilterRegistrationBean =new FilterRegistrationBean<>();
		filterFilterRegistrationBean.setFilter(new LoginCheckFilter());
		filterFilterRegistrationBean.setOrder(1);
		filterFilterRegistrationBean.addUrlPatterns("/*");

		return filterFilterRegistrationBean;
	}
}
