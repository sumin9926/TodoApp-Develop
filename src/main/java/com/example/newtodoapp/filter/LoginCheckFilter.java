package com.example.newtodoapp.filter;

import java.io.IOException;

import org.springframework.util.PatternMatchUtils;

import com.example.newtodoapp.session.SessionConst;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginCheckFilter implements Filter {

	private static final String[] whiteList = {"/", "/members/signup", "/login", "/logout"};

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws
		IOException,
		ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest)servletRequest;
		String requestURI = httpRequest.getRequestURI(); //클라이언트 요청 URI
		HttpServletResponse httpResponse = (HttpServletResponse)servletResponse;

		try {
			//인증 체크 시작
			if (isLoginCheckPath(requestURI)) {
				//세션 확인
				HttpSession session = httpRequest.getSession(false);
				//인증되지 않은 상태
				if (session == null || session.getAttribute(SessionConst.LOGIN_MEMBER) == null) {
					httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
					httpResponse.getWriter().write("Unauthorized access. Please log in first.");
					return;
				}
			}
			filterChain.doFilter(servletRequest, servletResponse);
		} catch (Exception e) {
			throw e;
		}
	}

	/*인증 체크 필요 URL 확인 메서드*/
	public boolean isLoginCheckPath(String requestURI) {

		return !PatternMatchUtils.simpleMatch(whiteList, requestURI);
	}
}
