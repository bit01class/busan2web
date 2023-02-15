package com.bit.model;

import java.util.Date;

import org.bson.types.ObjectId;

public class EmpDto {
	private ObjectId id;
	private int empno,sal;
	private String ename,job;
	private Date hiredate;

	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
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
		return "EmpDto [id=" + id + ", empno=" + empno + ", sal=" + sal + ", ename=" + ename + ", job=" + job
				+ ", hiredate=" + hiredate + "]";
	}
	
}
