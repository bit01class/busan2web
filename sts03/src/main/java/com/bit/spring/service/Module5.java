package com.bit.spring.service;

import java.util.List;
import java.util.Set;

public class Module5 implements Module {
	Set<String> list;

	public void setList(Set<String> list) {
		this.list = list;
	}
	
	@Override
	public void func() {
		for(String msg:list) System.out.println(msg);
	}
}
