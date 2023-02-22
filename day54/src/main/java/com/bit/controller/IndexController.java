package com.bit.controller;

import javax.servlet.http.HttpServletRequest;

import com.bit.frame.web.Controller;

public class IndexController implements Controller {

	@Override
	public String execute(HttpServletRequest arg0) {
		return "index";
	}

}
