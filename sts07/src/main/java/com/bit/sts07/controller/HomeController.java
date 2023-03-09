package com.bit.sts07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String index() {return "index";}
	@RequestMapping("/intro")
	public void intro() {}
}
