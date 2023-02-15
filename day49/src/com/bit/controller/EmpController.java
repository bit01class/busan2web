package com.bit.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.types.ObjectId;

import com.bit.model.EmpDao;
import com.bit.model.EmpDto;

@WebServlet("/emp/emp.do")
public class EmpController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String param=req.getParameter("id");
		ObjectId _id=new ObjectId(param);
		EmpDao dao=new EmpDao();
		req.setAttribute("bean", dao.selectOne(_id));
		req.getRequestDispatcher("/emp/detail.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EmpDto bean=new EmpDto();
		bean.setEmpno(Integer.parseInt(req.getParameter("empno")));
		bean.setEname(req.getParameter("ename"));
		bean.setHiredate(new Date());
		bean.setId(new ObjectId(req.getParameter("id")));
		bean.setJob(req.getParameter("job"));
		bean.setSal(Integer.parseInt(req.getParameter("sal")));
		EmpDao dao=new EmpDao();
		dao.updateOne(bean);
		doGet(req,resp);
	}
}










