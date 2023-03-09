package com.bit.sts07.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit.sts07.model.entity.DeptVo;

@Controller
@RequestMapping("/join")
public class JoinController {
	@GetMapping("/")
	public String form() {
		return "join/login";
	}
	@PostMapping("/")
	public String login(@ModelAttribute("bean") DeptVo bean,HttpSession session,Model model) {
		if("user1".equals(bean.getDname())&&"test".equals(bean.getLoc())) {
			session.setAttribute("result", true);
			session.setAttribute("user", bean.getDname()+"�� ȯ���մϴ�");
			return "redirect:../";
		}
		model.addAttribute("err", "�α��� ������ ��Ȯ���� �ʽ��ϴ�");
		return "join/login";
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:../";
	}
}














