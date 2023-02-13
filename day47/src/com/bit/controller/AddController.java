package com.bit.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.model.EmpDao;

public class AddController extends HttpServlet {
	Logger log=Logger.getGlobal();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd=req.getRequestDispatcher("add.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int empno=Integer.parseInt(req.getParameter("empno"));
		String ename=req.getParameter("ename");
		int sal=Integer.parseInt(req.getParameter("sal"));
		log.info("empno:"+empno+",ename="+ename+",sal="+sal);
		EmpDao dao=new EmpDao();
		try {
			dao.pushList(empno, ename, sal);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		resp.sendRedirect("list.do");
	}
}







