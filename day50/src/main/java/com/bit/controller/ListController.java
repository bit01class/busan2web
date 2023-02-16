package com.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.model.DeptDao;
import com.bit.model.DeptDto;

@WebServlet("/api/dept")
public class ListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Access-Control-Allow-Origin","*");
		resp.setHeader("Access-Control-Allow-Methods","GET");
		resp.setContentType("application/json; charset=utf8");
		try {
			DeptDao dao=new DeptDao();
			
			PrintWriter out = resp.getWriter();
			out.print("{\"depts\":");
			out.print(dao.selectAll());
			out.print("}");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Access-Control-Allow-Origin","*");
		resp.setHeader("Access-Control-Allow-Methods","POST");
		resp.setContentType("application/json; charset=utf8");
		DeptDto bean=new DeptDto();
		bean.setDeptno(Integer.parseInt(req.getParameter("deptno")));
		bean.setDname(req.getParameter("dname"));
		bean.setLoc(req.getParameter("loc"));
		try {
			DeptDao dao=new DeptDao();
			dao.insertOne(bean);
			resp.setStatus(HttpServletResponse.SC_CREATED);
			resp.getWriter().print("{}");
		} catch (SQLException e) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			resp.getWriter().print("{}");
		}
		
	}
}











