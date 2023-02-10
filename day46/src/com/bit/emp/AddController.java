package com.bit.emp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.emp.model.EmpDao;

public class AddController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String param1=req.getParameter("empno");
		String param2=req.getParameter("ename");
		String param3=req.getParameter("sal");
		int empno=Integer.parseInt(param1.trim());
		String ename=param2.trim();
		int sal=Integer.parseInt(param3.trim());
		EmpDao dao=new EmpDao();
		if(dao.insertOne(empno,ename,sal)>0) {
			resp.setStatus(201);
		}else {
			resp.setStatus(400);
		}
	}
}







