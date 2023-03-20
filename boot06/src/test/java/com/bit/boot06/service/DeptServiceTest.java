package com.bit.boot06.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.bit.boot06.domain.RequestDeptVo;
import com.bit.boot06.domain.ResponseDeptVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class DeptServiceTest {
	@Autowired
	DeptService deptService;
	RequestDeptVo target;
	
	@BeforeEach
	public void before() {
		target=RequestDeptVo.builder()
				.deptno(7777)
				.dname("test7")
				.loc("test")
				.build();
	}
	
	@Test
	@Transactional
	@Commit
	@Order(1)
	void test1InsertOne() {
		
		
		ResponseDeptVo result=deptService.insertOne(RequestDeptVo.builder()
				.deptno(target.getDeptno())
				.dname(target.getDname())
				.loc(target.getLoc())
				.build());
		
		log.debug(result.toString());
		assertEquals(target.getDeptno(), result.getDeptno());
		assertEquals(target.getDname(), result.getDname());
		assertEquals(target.getLoc(), result.getLoc());
	}
	
	@Test
	@Order(2)
	public void test2SelectOne() {
		ResponseDeptVo result = deptService.selectOne((int)target.getDeptno());
		log.debug(result.toString());
		assertEquals(target.getDeptno(), result.getDeptno());
		assertEquals(target.getDname(), result.getDname());
		assertEquals(target.getLoc(), result.getLoc());
	}
	
	@Test
	@Order(3)
	public void test3UpdateOne() {
		target.setDname("한글");
		ResponseDeptVo result = deptService.updateOne(target);
		log.debug(result.toString());
		assertEquals(target.getDeptno(), result.getDeptno());
		assertEquals(target.getDname(), result.getDname());
		assertEquals(target.getLoc(), result.getLoc());
		
	}
	
	@Test
	@Order(4)
	public void test4DeleteOne() {
		deptService.deleteOne(target.getDeptno());
	}
	
	@Test
	public void test5selectAll() {
		for(ResponseDeptVo bean: deptService.selectAll())
			System.out.println(bean.toString());

	}
	
	@Test
	public void test6SelectPaging() {
		for(ResponseDeptVo bean:deptService.selectAll(0,5))
			System.out.println(bean);
	}	
}












