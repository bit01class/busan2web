package com.bit.spring.aop;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.MethodBeforeAdvice;

public class BeforePrint implements MethodBeforeAdvice {
	Logger log=Logger.getLogger(this.getClass());
	

	@Override
	public void before(Method method, Object[] args, Object me) throws Throwable {
		log.debug(method.getName()+Arrays.toString(args));
//		System.out.println(method.getReturnType());
//		System.out.println(Arrays.toString(args));
//		System.out.println(me);
	}

}
