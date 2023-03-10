package com.bit.boot02.controller;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bit.boot02.model.DeptDao;
import com.bit.boot02.model.entity.DeptVo;

@Controller
public class MainController {
	@Autowired
	SqlSessionFactory sqlSessionFactory;

	@GetMapping("/")
	public String index(Model model) {
		try(SqlSession sqlSession =sqlSessionFactory.openSession()){
			model.addAttribute("list", sqlSession.getMapper(DeptDao.class).findAll());
		}
		return "index";
	}
	
	@GetMapping("/add")
	public void add() {}
	
	@PostMapping("/")
	public String add(@ModelAttribute("bean")DeptVo bean) {
		try(
				SqlSession sqlSession =sqlSessionFactory.openSession();
				){
			sqlSession.getMapper(DeptDao.class).insertOne(bean);
		}
		return "redirect:/";
	}
	
	@GetMapping("/detail")
	public void detail(int idx,Model model) {
		try(SqlSession sqlSession=sqlSessionFactory.openSession()){
			model.addAttribute("bean"
					, sqlSession.getMapper(DeptDao.class).findOne(idx));
		}
	}
}









