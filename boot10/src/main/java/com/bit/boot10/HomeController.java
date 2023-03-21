package com.bit.boot10;

import java.util.Arrays;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/ex01")
	public String ex01() {
		return "ex01";
	}

	@GetMapping("/ex02")
	public String ex02(HttpSession session,@AuthenticationPrincipal User user) {
		System.out.println(Arrays.toString(session.getValueNames()));
		System.out.println(user.getUsername());
		return "ex02";
	}

	@GetMapping("/ex03")
	public String ex03() {
		return "ex03";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
}
