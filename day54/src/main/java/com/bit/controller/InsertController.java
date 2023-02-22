package com.bit.controller;

import javax.servlet.http.HttpServletRequest;

import com.bit.frame.web.Controller;
import com.bit.model.DeptDao;

public class InsertController implements Controller {

	@Override
	public String execute(HttpServletRequest req) {
		int deptno=Integer.parseInt(req.getParameter("deptno"));
		String dname=req.getParameter("dname");
		String loc=req.getParameter("loc");
		DeptDao deptDao=new DeptDao();
		deptDao.insertOne(deptno, dname, loc);
		
		return "redirect:list.do";
	}

}
