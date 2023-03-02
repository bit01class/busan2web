package com.bit.spring;

import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bit.spring.aop.CoreService;
import com.bit.spring.non.module.Module1;
import com.bit.spring.non.module.Module2;
import com.bit.spring.non.service.ModuleService;
import com.bit.spring.service.Module;
import com.bit.spring.service.Module3;
import com.bit.spring.service.Module4;

public class App {

	public static void main(String[] args) {
		// IoC
		// DI
//		ModuleService service=new ModuleService(new Module2());

//		ModuleService service=new ModuleService();
//		service.setModule(new Module1());
		ApplicationContext ac=null;
		ac=new ClassPathXmlApplicationContext("/applicationContext.xml");
		
		CoreService my=(CoreService) ac.getBean("myService");
		my.helloMsg("환영합니다");
		my.printMsg();
		my.printName();
		try {
			my.printDiv();
		} catch (Exception e) {
		}
	}
}














