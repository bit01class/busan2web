package com.bit.model;

import java.sql.Date;

public class EmpDto {
	private int empno,sal,mgr,comm;
	private String ename,job;
	private Date hiredate;
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	public int getComm() {
		return comm;
	}
	public void setComm(int comm) {
		this.comm = comm;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	
	@Override
	public String toString() {
		return "EmpDto [empno=" + empno + ", sal=" + sal + ", mgr=" + mgr + ", comm=" + comm + ", ename=" + ename
				+ ", job=" + job + ", hiredate=" + hiredate + "]";
	}
}
