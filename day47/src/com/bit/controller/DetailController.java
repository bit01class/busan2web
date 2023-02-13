package com.bit.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.model.EmpDao;
import com.bit.model.EmpDto;

public class DetailController extends HttpServlet {
	Logger log=Logger.getLogger(
			"com.bit.controller.DetailController");

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int empno=Integer.parseInt(req.getParameter("idx"));
		EmpDao dao=new EmpDao();
		try {
			EmpDto bean=dao.getOne(empno);
			req.setAttribute("dto", bean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String viewName="detail.jsp";
		
		RequestDispatcher rd=req.getRequestDispatcher(viewName);
		rd.forward(req, resp);
	}
}








