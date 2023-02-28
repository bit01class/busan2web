package com.bit.sts02.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.bit.sts02.model.DeptDao;
import com.bit.sts02.model.DeptDaoImpl;

public class DeleteController implements Controller {
	DeptDao deptDao;
	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		deptDao.deleteOne(deptno);
		return new ModelAndView("redirect:list.do");
	}

}
