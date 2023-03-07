package com.bit.sts05.utils;

import org.aspectj.lang.JoinPoint;

public class DaoAdvice{

	public void afterReturning(JoinPoint thisJoinPoint,Object rv){
		System.out.println("afterReturn....");
		System.out.println(rv);
	}

}
