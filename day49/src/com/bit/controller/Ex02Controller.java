package com.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		value = {"/ex02.do","/ex02.bit"}
		,initParams = {
		  @WebInitParam(name = "key2",value = "val2")
		  ,@WebInitParam(name = "key3",value = "val3")
		}
)
public class Ex02Controller extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(this.getInitParameter("key2"));
		System.out.println(this.getInitParameter("key3"));
		RequestDispatcher rd=req.getRequestDispatcher("ex02.jsp");
		rd.forward(req, resp);
	}
}




