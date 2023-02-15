package com.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex01Controller extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(this.getInitParameter("key1"));
		System.out.println(this.getInitParameter("key2"));
		RequestDispatcher rd=req.getRequestDispatcher("ex01.jsp");
		rd.forward(req, resp);
	}
}








