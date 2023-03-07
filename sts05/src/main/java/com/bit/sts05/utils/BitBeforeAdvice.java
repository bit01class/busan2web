package com.bit.sts05.utils;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;

public class BitBeforeAdvice{

	public void before(JoinPoint point) {
		System.out.println(point.getSignature().getName());
		System.out.println(point.getArgs());
		System.out.println(point.getTarget());
	}

//	public void before(Method method, Object[] args, Object target) throws Throwable {}
}
