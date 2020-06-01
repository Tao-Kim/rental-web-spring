package com.tao.interceptor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;

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

		log.info("\n\n request.getRequestURL() : " + request.getRequestURL()
		+ "\n request.getContextPath() : " + request.getContextPath()
		+ "\n request.getRequestURI() : " + request.getRequestURI()
		+ "\n session.getAttribute(\"admin\") : " + session.getAttribute("admin")
		+ "\n");



			if (session.getAttribute("admin") == null) {
				log.info("1-1. session.getAttribute(\"admin\") == null --- true");
				response.sendRedirect("/deny");
				return false;
			} else {
				log.info("1-2. session.getAttribute(\"admin\") == null --- false");
				return true;
			}
		

	}
}

//
//if (request.getRequestURI().contains("/admin")) {
//	log.info("1. request.getRequestURI().contains(\"/admin\") --- true");
//	if (session.getAttribute("admin") == null) {
//		log.info("1-1. session.getAttribute(\"admin\") == null --- true");
//		response.sendRedirect("/deny");
//		return false;
//	} else {
//		log.info("1-2. session.getAttribute(\"admin\") == null --- false");
//		return true;
//	}
//} 
//else {
//	log.info("2. request.getRequestURI().contains(\"/admin\") --- false");
//	if (session.getAttribute("admin") != null) {
//		log.info("2-1. session.getAttribute(\"admin\") != null --- true");
//		response.sendRedirect("/admin" + request.getRequestURI());
//		return false;
//	} else {
//		log.info("2-2. session.getAttribute(\"admin\") != null --- false");
//		return true;
//	}
//}

