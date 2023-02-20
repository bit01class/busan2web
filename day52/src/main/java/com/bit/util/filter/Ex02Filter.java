package com.bit.util.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;

public class Ex02Filter implements Filter {
	Logger log=Logger.getLogger("com.bit.util.filter.Ex02Filter");

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		log.debug("before ex02filter");
		chain.doFilter(request, response);
		log.debug("after ex02filter");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
