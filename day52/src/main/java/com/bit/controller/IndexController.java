package com.bit.controller;

import javax.servlet.http.HttpServletRequest;

import com.bit.framework.handler.Controller;

public class IndexController implements Controller{
	public String execute(HttpServletRequest req) {
		return "index";
	}
}
