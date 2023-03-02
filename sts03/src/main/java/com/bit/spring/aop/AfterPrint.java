package com.bit.spring.aop;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;

public class AfterPrint implements AfterReturningAdvice {
	Logger log=Logger.getLogger(this.getClass());

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		log.debug(returnValue);
	}

}
