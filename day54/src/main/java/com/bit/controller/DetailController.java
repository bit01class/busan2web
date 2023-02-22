package com.bit.controller;

import javax.servlet.http.HttpServletRequest;

import com.bit.frame.web.Controller;
import com.bit.model.DeptDao;

public class DetailController implements Controller {

	@Override
	public String execute(HttpServletRequest req) {
		int deptno=Integer.parseInt(req.getParameter("deptno"));
		DeptDao deptDao=new DeptDao();
		req.setAttribute("bean", deptDao.selectOne(deptno));
		return "dept/detail";
	}

}
