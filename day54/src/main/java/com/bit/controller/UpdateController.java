package com.bit.controller;

import javax.servlet.http.HttpServletRequest;

import com.bit.frame.web.Controller;
import com.bit.model.DeptDao;

public class UpdateController implements Controller {

	@Override
	public String execute(HttpServletRequest req) {
		DeptDao deptDao=new DeptDao();
		int deptno=Integer.parseInt(req.getParameter("deptno"));
		String dname=req.getParameter("dname");
		String loc=req.getParameter("loc");
		deptDao.updateOne(deptno, dname, loc);
		return "redirect:list.do";
	}

}
