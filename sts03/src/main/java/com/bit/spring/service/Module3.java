package com.bit.spring.service;

import java.util.Date;

public class Module3 {
	boolean boo;
	char ch1;
	int su1;
	long su2;
	double su3;
	String msg;
	Date nalja;

	public void setBoo(boolean boo) {
		this.boo = boo;
	}

	public void setCh1(char ch1) {
		this.ch1 = ch1;
	}

	public void setSu1(int su1) {
		this.su1 = su1;
	}

	public void setSu2(long su2) {
		this.su2 = su2;
	}

	public void setSu3(double su3) {
		this.su3 = su3;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void setNalja(Date nalja) {
		this.nalja = nalja;
	}

	public void func() {
		System.out.println(boo);
		System.out.println(ch1);
		System.out.println(su1);
		System.out.println(su2);
		System.out.println(su3);
		System.out.println(msg);
		System.out.println(nalja);
	}
}
