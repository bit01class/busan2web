package com.bit.sts07.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.annotations.Delete;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit.sts07.model.entity.DeptVo;
import com.bit.sts07.service.DeptService;

@Controller
@RequestMapping("/dept")
public class DeptController {
	Logger log=LoggerFactory.getLogger(getClass());
	@Inject
	DeptService deptService;
	

	@GetMapping("/")
	public String list(Model model) {
		model.addAttribute("list", deptService.selectAll());
		return "dept/list";
	}
	
	@PostMapping("/")
	public String add(@ModelAttribute("bean") DeptVo bean) {
		deptService.insertOne(bean);
		return "redirect:./";
	}
	
	@GetMapping("/{1}")
	public @ResponseBody DeptVo detail(@PathVariable("1") int deptno) {
		
		return deptService.selectOne(deptno);
	}
	
	@PutMapping("/{1}")
	public ResponseEntity<?> update(@RequestBody DeptVo bean) {
		if(deptService.updateOne(bean)>0)
			return new ResponseEntity(null,HttpStatus.OK);
		return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@DeleteMapping("/{deptno}")
	public @ResponseBody String delete(@PathVariable("deptno")int deptno) {
		deptService.deleteOne(deptno);
		return "";
	}
}















