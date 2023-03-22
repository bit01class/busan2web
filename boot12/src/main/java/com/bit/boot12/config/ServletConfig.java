package com.bit.boot12.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class ServletConfig implements WebMvcConfigurer{
	@Bean
	PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void addViewControllers(ViewControllerRegistry reg) {
		reg.addViewController("/").setViewName("index");
//		reg.addViewController("/login").setViewName("login");
		reg.addViewController("/join").setViewName("join");
//		reg.addViewController("/dept/").setViewName("dept/index");
	}
}








