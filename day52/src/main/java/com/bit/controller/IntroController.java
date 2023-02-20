package com.bit.controller;

import javax.servlet.http.HttpServletRequest;

import com.bit.framework.handler.Controller;

public class IntroController implements Controller{
	public String execute(HttpServletRequest req) {
		return "intro";
	}
}
