package com.bit.sts06.service;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class DeptServiceTest {

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
	public void testSelectAll() {
		ApplicationContext ac;
		ac=new GenericXmlApplicationContext("file:D:\\webspace\\sts06\\src\\main\\webapp\\WEB-INF\\spring\\root-context.xml");
		DeptService deptService=ac.getBean(DeptService.class);
		assertNotNull(deptService.selectAll());
	}

}









