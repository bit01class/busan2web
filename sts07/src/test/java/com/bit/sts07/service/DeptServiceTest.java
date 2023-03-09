package com.bit.sts07.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.bit.sts07.model.entity.DeptVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
public class DeptServiceTest {
	@Autowired
	DeptService deptService;
	
	@Test
	public void testSelectAll() {
		assertNotNull(deptService.selectAll());
		assertNotSame(0,deptService.selectAll().size());
	}

	@Test
	public void testSelectOne() {
		DeptVo target=new DeptVo(50,"테스팅","테스트");
		assertNotNull(deptService.selectOne(target.getDeptno()));
		assertEquals(target,deptService.selectOne(target.getDeptno()));
		
	}
	@Transactional
	@Test
	public void testInsertOne() {
		DeptVo target=new DeptVo(60,"테스팅","테스트");
		deptService.insertOne(target);
	}

}






