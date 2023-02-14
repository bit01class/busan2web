package com.bit.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.model.DeptDao;

public class AddController extends HttpServlet {
	Logger log=Logger.getLogger(this.getClass().getName());

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext context=req.getServletContext();
		String url=context.getInitParameter("url");
		String user=context.getInitParameter("user");
		String password=context.getInitParameter("password");
		DeptDao dao=new DeptDao(url,user,password);

		int deptno=Integer.parseInt(req.getParameter("deptno"));
		String dname=req.getParameter("dname");
		String loc=req.getParameter("loc");
		log.info(deptno+","+dname+","+loc);

		resp.setHeader("Access-Control-Allow-Origin","*");
		resp.setStatus(resp.SC_CREATED);
		try {
			dao.insertOne(deptno,dname,loc);
		} catch (SQLException e) {
			resp.sendError(resp.SC_BAD_REQUEST);
		}
	}
}









