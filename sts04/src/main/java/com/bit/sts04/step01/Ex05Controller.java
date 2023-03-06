package com.bit.sts04.step01;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit.sts04.model.DeptVo;

@Controller
public class Ex05Controller {

	@RequestMapping(value="/ex11",method = {RequestMethod.GET,RequestMethod.POST})
	public String ex11() {
		return "ex01";
	}
	
	@RequestMapping(value = "/ex12",method = {RequestMethod.POST})
	public String ex12(int deptno,String dname,Model model) {
		System.out.println("dname:"+dname);
		System.out.println("deptno:"+deptno);
		model.addAttribute("dname", dname);
		model.addAttribute("deptno", deptno);
		return "ex02";
	}
	
	@RequestMapping("/ex13/{deptno}")
	public String ex13(@PathVariable int deptno) {
		System.out.println(deptno);
		return "ex03";
	}
	
	@RequestMapping("/ex14")
	public String ex14(@ModelAttribute("bean") DeptVo bean) {
		System.out.println(bean);
		bean.setDeptno(2222);
		bean.setDname("test3");
		bean.setLoc("test4");
		return "ex04";
	}
}














