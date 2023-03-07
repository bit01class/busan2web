package com.bit.sts05.utils;

import java.util.ArrayList;
import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;

import com.bit.sts05.model.DeptVo;

public class AroundAdvice {

	public Object aroundTargetMethod(ProceedingJoinPoint thisJoinPoint) throws Throwable {
		System.out.println("before..");
		Object obj=null;
		try {
			obj=thisJoinPoint.proceed();
			System.out.println("after returnning.. return value:"+obj);
		}catch (Exception e) {
			System.out.println("after throws..");
		}
		System.out.println("after..");
		return obj;
	}
}











