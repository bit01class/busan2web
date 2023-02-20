package com.bit.controller;

import javax.servlet.http.HttpServletRequest;

import com.bit.framework.handler.Controller;

public class InsertController implements Controller {

	@Override
	public String execute(HttpServletRequest req) {
		return "redirect:list.do";
	}

}
