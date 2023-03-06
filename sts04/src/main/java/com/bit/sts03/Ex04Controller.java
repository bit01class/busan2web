package com.bit.sts03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Ex04Controller {

	@RequestMapping("/ex07.do")
	public String ex07() {
		return "ex02";
	}
}
