package com.bit.sts05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit.sts05.service.DeptService;

@Controller
@RequestMapping("/dept")
public class DeptController {
	@Autowired
	DeptService deptService;

	@RequestMapping("/")
	public String list(Model model) {
		model.addAttribute("list", deptService.getList());
		return "dept/list";
	}
	
	@RequestMapping(value = "/add",method = RequestMethod.GET)
	public void addForm() {}
	
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public String add() {
		return "redirect:./";
	}
}










