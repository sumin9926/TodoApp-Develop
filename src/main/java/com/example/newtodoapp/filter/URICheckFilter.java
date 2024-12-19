package com.example.newtodoapp.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class URICheckFilter implements Filter {

	//허용되는 패턴 목록
	private static final List<Pattern> ALLOWED_PATTERNS = new ArrayList<>();

	static{
		ALLOWED_PATTERNS.add(Pattern.compile("^/login$"));
		ALLOWED_PATTERNS.add(Pattern.compile("^/logout$"));
		ALLOWED_PATTERNS.add(Pattern.compile("^/members$"));
		ALLOWED_PATTERNS.add(Pattern.compile("^/members/signup$"));
		ALLOWED_PATTERNS.add(Pattern.compile("^/members/\\d+$")); // /members/{숫자}
		ALLOWED_PATTERNS.add(Pattern.compile("^/todos$"));
		ALLOWED_PATTERNS.add(Pattern.compile("^/todos/save$"));
		ALLOWED_PATTERNS.add(Pattern.compile("^/todos/\\d+$")); // /todos/{숫자}
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws
		IOException,
		ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
		HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
		String requestURI = httpRequest.getRequestURI();

		//허용되는 URL이 아닌 경우
		if(!isAllowedURL(requestURI)){
			httpResponse.setStatus(HttpServletResponse.SC_NOT_FOUND);
			httpResponse.getWriter().write("Please check your URL.");
			return;
		}

		filterChain.doFilter(servletRequest, servletResponse);
	}

	/*허용되는 URL 인지 확인하는 메서드(URL 패턴 확인)*/
	private boolean isAllowedURL(String url) {
		for (Pattern pattern : ALLOWED_PATTERNS) {
			if (pattern.matcher(url).matches()) {
				return true;
			}
		}
		return false;
	}
}
