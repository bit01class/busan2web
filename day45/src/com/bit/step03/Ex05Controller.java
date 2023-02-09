package com.bit.step03;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex05Controller extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response =(HttpServletResponse) res;
		if("GET".equals(request.getMethod())) {
			doGet(request,response);
		}else if("POST".equals(request.getMethod())) {
			doPost(request,response);
		}

	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
					throws ServletException, IOException {
		res.setStatus(405,"허용되지 않는 메서드");
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) 
					throws ServletException, IOException {
		res.setStatus(405,"허용되지 않는 메서드");
	}

}






