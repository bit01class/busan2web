package com.bit.step01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Ex01Controller implements Servlet {
	ServletConfig config;

	@Override
	public void destroy() {
		System.out.println("destroy");
	}

	@Override
	public ServletConfig getServletConfig() {
		System.out.println("config..");
		return config;
	}

	@Override
	public String getServletInfo() {
		System.out.println("info");
		return "테스트삼아 한번 작성하지만 출력되진 않는다";
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("init");
		config=arg0;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out=res.getWriter();
		try {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset=\"utf-8\">");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>servlet 테스트 페이지</h1>");
			out.println("</body>");
			out.println("</html>");
		}finally {
			out.close();
		}
	}
}









