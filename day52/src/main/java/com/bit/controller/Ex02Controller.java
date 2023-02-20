package com.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class Ex02Controller extends HttpServlet {
	Logger log=Logger.getLogger("com.bit.controller.Ex02Controller");

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doDo(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		doDo(req,resp);
	}
	
	protected void doDo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String param=req.getParameter("id");
		log.debug(param);
		resp.setContentType("text/html; charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		try(PrintWriter out=resp.getWriter()){
			out.println("Ex02 controller...param:"+param);
		}
	}
}









