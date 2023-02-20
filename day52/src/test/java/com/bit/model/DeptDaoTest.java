package com.bit.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeptDaoTest {
	static DeptDto target;
	DeptDao dao;
	
	@BeforeClass
	public static void beforeClass() {
		target=new DeptDto();
		target.setDeptno(9999);
		target.setDname("test1");
		target.setLoc("test2");
	}
	
	@Before
	public void before() {
		dao=new DeptDao();
	}

	@Test
	public void test1SelectAll() {
		assertNotNull(dao.selectAll());
		assertTrue(dao.selectAll().size()>0);
	}

	@Test
	public void test3SelectOne() {
		assertEquals(target, dao.selectOne(target.getDeptno()));
	}

	@Test
	public void test2InsertOne() {
		assertSame(1, dao.insertOne(target.getDeptno()
							,target.getDname(),target.getLoc()));
	}

	@Test
	public void test4UpdateOne() {
		target.setDname("test2");
		target.setLoc("test1");
		assertSame(1, dao.updateOne(target.getDeptno()
							,target.getDname(),target.getLoc()));
	}

	@Test
	public void test5DeleteOne() {
		assertSame(1, dao.deleteOne(target.getDeptno()));
	}

}
