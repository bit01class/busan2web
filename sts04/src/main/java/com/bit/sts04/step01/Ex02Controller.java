package com.bit.sts04.step01;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

@Controller
@RequestMapping("/lec02")
public class Ex02Controller {
	
	@RequestMapping(value="/ex02.do")
	public ModelAndView ex02(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("ex02");
	}
	
	@RequestMapping("/ex03.do")
	public ModelAndView ex03(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("ex03");
	}
	
	@RequestMapping("/ex04.do")
	public String ex04(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "ex04";
	}
	
	@RequestMapping("/ex05.do")
	public String Ex05(HttpServletResponse resp) {
		System.out.println(resp.getBufferSize());
		return "ex05";
	}
}





















