package com.bit.boot03.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bit.boot03.service.DeptService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/")
@AllArgsConstructor
public class DeptController {
	
	private final DeptService deptService;

	@CrossOrigin
	@GetMapping
	public List<?> getList(){
		return deptService.selectAll();
	}
}
