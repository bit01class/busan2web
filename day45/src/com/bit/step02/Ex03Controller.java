package com.bit.step02;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public abstract class Ex03Controller implements Servlet {
	ServletConfig config;

	@Override
	public void destroy() {}

	@Override
	public ServletConfig getServletConfig() {return config;}

	@Override
	public String getServletInfo() {return "";}

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config=config;
	}

	@Override
	public abstract void service(ServletRequest req, ServletResponse res) throws ServletException, IOException;

}
