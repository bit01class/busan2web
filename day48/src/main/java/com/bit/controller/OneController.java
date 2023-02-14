package com.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.model.DeptDao;
import com.bit.model.DeptDto;

public class OneController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext context=req.getServletContext();
		String url=context.getInitParameter("url");
		String user=context.getInitParameter("user");
		String password=context.getInitParameter("password");
		DeptDao dao=new DeptDao(url, user, password);
		
		int deptno=Integer.parseInt(req.getParameter("deptno"));
		
		resp.setHeader("Access-Control-Allow-Origin","*");
		try(PrintWriter out = resp.getWriter();){
			out.print("{\"dept\":[");
			DeptDto bean=dao.selectOne(deptno);
			out.print(bean);
			out.print("]}");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}











