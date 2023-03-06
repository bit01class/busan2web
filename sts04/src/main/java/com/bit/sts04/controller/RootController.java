package com.bit.sts04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit.sts04.model.DeptDao;
import com.bit.sts04.model.DeptVo;

@Controller
public class RootController {
	@Autowired
	DeptDao deptDao;

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/dept/list")
	public String list(Model model) {
		model.addAttribute("list", deptDao.findAll());
		return "dept/list";
	}
	
	@RequestMapping(value = "/dept/add",method = RequestMethod.GET)
	public String add() {
		return "dept/add";
	}
	
	@RequestMapping(value = "/dept/add",method=RequestMethod.POST)
	public String add(String dname,String loc) {
		deptDao.insertOne(new DeptVo(0,dname,loc));
		return "redirect:list";
	}
	
	@RequestMapping("/dept/detail")
	public String detail(@RequestParam("deptno") int deptno,Model model) {
		model.addAttribute("bean",deptDao.findOne(deptno));
		return "dept/detail";
	}
	
	@RequestMapping(value = "/dept/update",method=RequestMethod.POST)
	public String edit(@ModelAttribute DeptVo bean) {
		deptDao.updateOne(bean);
		return "redirect:list";
	}
	
	@RequestMapping(value = "/dept/delete",method=RequestMethod.POST)
	public String delete(int deptno){
		deptDao.deleteOne(deptno);
		return "redirect:list";
	}
}











