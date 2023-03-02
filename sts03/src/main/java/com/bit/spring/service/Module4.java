package com.bit.spring.service;

public class Module4 {
	String[] msgs;
	
	public void setMsgs(String[] msgs) {
		this.msgs = msgs;
	}
	
	public void func() {
		for(String msg: msgs) System.out.println(msg);
	}
}
