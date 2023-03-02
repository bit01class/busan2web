package com.bit.spring.aop;

public class CoreService {

	String msg;
	String name;
	int su;
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setSu(int su) {
		this.su = su;
	}
	public String getMsg() {
		return msg;
	}
	public void printMsg() {
		///
		System.out.println(msg);
	}
	public String helloMsg(String msg2) {
		String result=name+"님 "+msg2;
		System.out.println(result);
		return result;
	}
	public void printName() {
		System.out.println(name);
	}
	public void printDiv() throws Exception {
//		double result=msg.toCharArray()[su];
//		System.out.println(result);
		if(su==0) throw new Exception("내가 던진 오류...");
	}
}
