package com.example.newtodoapp;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.newtodoapp.filter.LoginCheckFilter;
import com.example.newtodoapp.filter.URICheckFilter;

import jakarta.servlet.Filter;

@Configuration
public class WebConfig {

	/*URL 형식을 체크하는 필터*/
	@Bean
	public FilterRegistrationBean urlCheckFilter() {
		FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
		filterFilterRegistrationBean.setFilter(new URICheckFilter());
		filterFilterRegistrationBean.setOrder(1);
		filterFilterRegistrationBean.addUrlPatterns("/*");

		return filterFilterRegistrationBean;
	}

	/*로그인 상태인지 체크하는 필터*/
	@Bean
	public FilterRegistrationBean loginCheckFilter() {

		FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
		filterFilterRegistrationBean.setFilter(new LoginCheckFilter());
		filterFilterRegistrationBean.setOrder(2);
		filterFilterRegistrationBean.addUrlPatterns("/*");

		return filterFilterRegistrationBean;
	}
}
