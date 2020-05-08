package com.tao.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.log4j.Log4j;

@Log4j
public class AdminInterceptor extends HandlerInterceptorAdapter {

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if(session.getAttribute("admin")==null){
			response.sendRedirect("/deny");
			return false;
		} else {
			log.info("AdminInterceptor - admin !!!!!!! " + request.getRequestURI());
			if(request.getContextPath() != "/admin") response.sendRedirect("/admin" + request.getRequestURI());
			return true;
		}
	}
}
