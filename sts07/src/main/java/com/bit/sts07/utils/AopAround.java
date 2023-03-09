package com.bit.sts07.utils;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AopAround {

	@Around("execution(* com.bit.sts07.service.*.*(..))")
	public Object around(ProceedingJoinPoint join) {
		Object obj=null;
		
		try {
			System.out.println("params:"+Arrays.toString(join.getArgs()));
			obj=join.proceed();
			System.out.println("result:"+obj);
		}catch (Throwable e) {
			e.printStackTrace();
		}
		
		return obj;
	}
}
