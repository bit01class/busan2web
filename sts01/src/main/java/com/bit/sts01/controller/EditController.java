package com.bit.sts01.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.bit.sts01.model.DeptDao;

public class EditController implements Controller {
	DeptDao deptDao;
	
	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav=new ModelAndView();
		request.setCharacterEncoding("utf-8");
		int deptno=Integer.parseInt(request.getParameter("deptno"));
		String dname=request.getParameter("dname");
		String loc=request.getParameter("loc");
		String view="detail";
		if(request.getMethod().equals("GET")) {
			mav.addObject("bean", deptDao.findOne(deptno));
		}else {
			view="redirect:list.do";
			deptDao.updateOne(dname,loc,deptno);
		}
		mav.setViewName(view);
		return mav;
	}

}
