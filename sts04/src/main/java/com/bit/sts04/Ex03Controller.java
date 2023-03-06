package com.bit.sts04;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lec01")
public class Ex03Controller {

//	@RequestMapping("/ex06.do")
	public String ex06() {
		return "ex01";
	}
}
