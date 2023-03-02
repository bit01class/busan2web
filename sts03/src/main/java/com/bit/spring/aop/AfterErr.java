package com.bit.spring.aop;

import org.springframework.aop.ThrowsAdvice;

public class AfterErr implements ThrowsAdvice {

	public void afterThrowing(Exception ex) {
		System.out.println("에러발생..");
		System.out.println(ex);
	}
	
}
