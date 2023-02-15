package com.bit.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.model.EmpDao;
import com.bit.model.EmpDto;

@WebServlet("/emp/add.do")
public class AddController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("add.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EmpDto bean=new EmpDto();
		bean.setEmpno(Integer.parseInt(req.getParameter("empno")));
		bean.setEname(req.getParameter("ename"));
		bean.setHiredate(new Date());
		bean.setJob(req.getParameter("job"));
		bean.setSal(Integer.parseInt(req.getParameter("sal")));
		
		EmpDao dao=new EmpDao();
		dao.insertOne(bean);
		
		resp.sendRedirect("/day49/emp/list.do");
	}
}







