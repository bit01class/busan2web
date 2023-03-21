package com.bit.boot09.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.HandlerInterceptor;

import com.bit.boot09.service.JwtService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeptControllerIntercepter implements HandlerInterceptor{
	final JwtService jwtService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(request.getRequestURI().startsWith("/api/")){
			String authorization=request.getHeader("authorization");
			if(authorization==null) {
				response.sendRedirect("/login");
				return false;
			}
			String token=authorization.split(" ")[1];
			String user=jwtService.verify(token);
			System.out.println(user);
			if(user==null){
				response.sendRedirect("/login");
				return false;
			}
				
		}
		return true;
	}

}
