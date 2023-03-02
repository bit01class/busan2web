package com.bit.sts02.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.bit.spring.model.DeptDao;
import com.bit.spring.model.DeptVo;

public class UpdateController extends AbstractCommandController {
	@Autowired
	DeptDao deptDao;

	@Override
	protected ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		DeptVo bean=(DeptVo) command;
		deptDao.updateOne(bean);
		return new ModelAndView("redirect:list.do");
	}

}
