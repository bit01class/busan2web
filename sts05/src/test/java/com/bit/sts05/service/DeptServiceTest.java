package com.bit.sts05.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.bit.sts05.model.DeptVo;

public class DeptServiceTest {

	static ApplicationContext ac=null;
	private DeptService deptService;
	private static int size;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ac=new GenericXmlApplicationContext("/applicationContext.xml");
	}

	@Before
	public void setUp() throws Exception {
		deptService = ac.getBean(DeptService.class);
	}

//	@Test
	public void testGetList() {
		List<?> list = deptService.getList();
		assertNotNull(list);
		size=list.size();
		assertNotSame(0, size);
	}

	@Test
	public void testPushList() {
		int before=deptService.getList().size();
		DeptVo target=new DeptVo(0,"test","success");
//		DeptVo target=new DeptVo(0,"aaaaaaaaaaaaaaaa","err");
		deptService.pushList(target);
		assertSame(before+1,deptService.getList().size());
	}

//	@Test
	public void testPullList() {
		fail("Not yet implemented");
	}

//	@Test
	public void testEditList() {
		fail("Not yet implemented");
	}

//	@Test
	public void testRemoveList() {
		fail("Not yet implemented");
	}

//	@After
//	public void tearDown() throws Exception {
//	}
//
//	@AfterClass
//	public static void tearDownAfterClass() throws Exception {
//	}

}
