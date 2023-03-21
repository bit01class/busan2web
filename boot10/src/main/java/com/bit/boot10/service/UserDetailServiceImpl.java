package com.bit.boot10.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserDetailServiceImpl implements UserDetailsService {
	final PasswordEncoder passwordEncoder;
//	DeptMapper deptMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		mybatis //DeptVo bean=deptMapper.selectOne(username);
//		jpa		//DeptVo bean=findByDname(username);
		
		return User.builder()
				.username("user01")
				.password(passwordEncoder.encode("1234"))
				.roles("USER,ADMIN")
				.build();
	}

}
