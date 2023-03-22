package com.bit.boot12;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.bit.boot12.service.UserDetailsImpl;

@Controller
public class HomeController {

	@GetMapping("/login")
	public void login() {}
	
	@GetMapping("/dept/")
	public String list(Authentication authentication,@AuthenticationPrincipal UserDetails userDetails) {
		System.out.println(userDetails.getUsername());
		System.out.println(((UserDetailsImpl)authentication.getPrincipal()).getHiredate());
		SecurityContext context = SecurityContextHolder.getContext();
		String name=context.getAuthentication().getName();
		System.out.println(name);
		return "dept/index";
	}
}









