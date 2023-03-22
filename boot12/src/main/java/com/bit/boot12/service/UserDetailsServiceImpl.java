package com.bit.boot12.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bit.boot12.domain.EmpRepo;
import com.bit.boot12.model.EmpVo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	final EmpRepo empRepo;
	final PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String ename) throws UsernameNotFoundException {
		EmpVo bean=empRepo.findByEname(ename).getEntity();
		return User.builder()
				.username(bean.getEname())
				.password(passwordEncoder.encode(String.valueOf(bean.getEmpno())))
				.authorities("USER")
				.build();
	}

}
