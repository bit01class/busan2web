package com.bit.sts05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RootController {

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/intro")
	public void intro() {}
}
