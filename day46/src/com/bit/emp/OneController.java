package com.bit.emp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.emp.model.EmpDao;
import com.bit.emp.model.EmpDto;

public class OneController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int empno=Integer.parseInt(req.getParameter("empno"));
		System.out.println("one param:"+empno);
		EmpDao dao=new EmpDao();
		EmpDto bean=dao.getOne(empno);
		//resp.setContentType("application/json");
		PrintWriter out = resp.getWriter();
		try {
			out.println("{\"emp\":[");
			out.println("{\"empno\":"+bean.getEmpno()
				+",\"ename\":\""+bean.getEname()
				+"\",\"sal\":"+bean.getSal()
				+",\"hiredate\":\""+bean.getHiredate()
				+"\",\"comm\":"+bean.getComm()
				+",\"mgr\":"+bean.getMgr()
				+",\"deptno\":"+bean.getDeptno()+"}");
			out.println("]}");
		}finally {
			if(out!=null)out.close();
		}
	}
}








