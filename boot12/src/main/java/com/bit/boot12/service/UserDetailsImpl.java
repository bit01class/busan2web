package com.bit.boot12.service;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;

@Getter
public class UserDetailsImpl extends User {
	private String job;
	private LocalDate hiredate;
	private int mgr;

	public UserDetailsImpl(String username, 
			String password, Collection<? extends GrantedAuthority> authorities
			,String job,LocalDate hiredate,int mgr
			) {
		super(username, password, authorities);
		this.job=job;
		this.hiredate=hiredate;
		this.mgr=mgr;
	}

	

}
