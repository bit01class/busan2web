package com.bit.sts05.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DeptDaoTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindAll() {
		ApplicationContext ac=null;
		ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		DeptDao deptDao=(DeptDao) ac.getBean("deptDao");
		assertNotNull(deptDao.findAll());
		assertTrue(deptDao.findAll().size()>0);
	}

//	@Test
	public void testFindObject() {
		fail("Not yet implemented");
	}

//	@Test
	public void testInsertOne() {
		fail("Not yet implemented");
	}

//	@Test
	public void testUpdateOne() {
		fail("Not yet implemented");
	}

//	@Test
	public void testDeleteOne() {
		fail("Not yet implemented");
	}

}
