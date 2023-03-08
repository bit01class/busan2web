package com.bit.sts06.utils;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DaoAop {
	
	@Around("execution(* com.bit.sts06.model.DeptDao.*(..))")
	public Object around(ProceedingJoinPoint join) {
		Object obj=null;
		
		System.out.println(join.getSignature().getName()+">>>>>>>>>>>");
		try {
			System.out.println(Arrays.toString(join.getArgs()));
			obj=join.proceed();
			System.out.println(obj);
		} catch (Throwable e) {
			System.out.println(e.toString());
		}
		System.out.println(">>>>>>>>>>>>>"+join.getSignature().getName());
		return obj;
	}

//	@Before(value = "execution(* com.bit.sts06.model.DeptDao.*(..))")
//	public void before(JoinPoint join) {
//		System.out.println(Arrays.toString(join.getArgs()));
//	}
//	
//	@AfterReturning(
//			value = "execution(* com.bit.sts06.model.DeptDao.*(..))"
//			,returning = "rv"
//			)
//	public void afterSuccess(JoinPoint join,Object rv) {
//		System.out.println(rv);
//	}
//	
//	@AfterThrowing(
//			value = "execution(* com.bit.sts06.model.DeptDao.*(..))"
//			,throwing = "err"
//			)
//	public void afterError(JoinPoint join,Exception err) {
//		System.out.println(err.toString());
//	}
//	
//	@After(value = "execution(* com.bit.sts06.model.DeptDao.*(..))")
//	public void after(JoinPoint join) {}
}



