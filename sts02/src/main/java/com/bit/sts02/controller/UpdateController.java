package com.bit.sts02.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;
import org.springframework.web.servlet.mvc.AbstractFormController;

import com.bit.sts02.model.DeptDao;
import com.bit.sts02.model.DeptDaoImpl;
import com.bit.sts02.model.DeptVo;

public class UpdateController extends AbstractCommandController {
	DeptDao deptDao;
	
	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}

	@Override
	protected ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		DeptVo bean=(DeptVo) command;
		deptDao.updateOne(bean);
		return new ModelAndView("redirect:list.do");
	}

}
