package com.bit.boot06.domain;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bit.boot06.domain.entity.Dept03;

public class DeptRepoTest {
	@Autowired
	DeptRepo deptRepo;

	@Test
	public void test() {
		Dept03 entity =Dept03.builder()	
				.deptno(1111)
				.dname("test1")
				.loc("test")
				.build();
		
		deptRepo.save(entity);
	}

	@Test
	public void test2() {
		
	}
}







