package com.bit.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AroundPrint implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("before...");
		Object obj=null;
		try {
			obj=invocation.proceed();
			System.out.println("after returning...");
		}catch (Exception e) {
			System.out.println("after throw...");
		}
		System.out.println("after around...");
		return obj;
	}

}
