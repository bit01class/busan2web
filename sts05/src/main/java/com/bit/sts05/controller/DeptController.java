package com.bit.sts05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit.sts05.model.DeptVo;
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
	public String add(@ModelAttribute("bean") DeptVo bean) {
		deptService.pushList(bean);
		return "redirect:./";
	}
	
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	public void detail(int deptno,Model model) {
		model.addAttribute("bean", deptService.pullList(deptno));
	}
	
	@RequestMapping(value="/detail",method=RequestMethod.POST)
	public String delete(int deptno) {
		deptService.removeList(deptno);
		return "redirect:./";
	}

	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public void edit(int deptno,Model model) {
		model.addAttribute("bean", deptService.pullList(deptno));
	}
	
	@RequestMapping(value = "/edit",method = RequestMethod.POST)
	public String update(@ModelAttribute("bean") DeptVo bean) {
		deptService.editList(bean);
		return "redirect:./detail?deptno="+bean.getDeptno();
	}
}










