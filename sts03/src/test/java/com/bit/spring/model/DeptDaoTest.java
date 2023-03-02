package com.bit.spring.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeptDaoTest {

	static ApplicationContext ac;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ac=new ClassPathXmlApplicationContext("/applicationContext.xml");
	}

	private DeptDao deptDao;
	private DeptVo target;

	@Before
	public void setUp() throws Exception {
		deptDao=(DeptDao)ac.getBean("deptDao");
		target=new DeptVo(99, "test", "test");
	}

	//@Test
	public void testDataSource() throws SQLException {
		DataSource dataSource=(DataSource) ac.getBean("dataSource");
		Connection conn=dataSource.getConnection();
		assertNotNull(conn);
		conn.close();	
	}
	
	//@Test
	public void testJdbcTemplate() {
		JdbcTemplate jdbcTemplate=(JdbcTemplate) ac.getBean("jdbcTemplate");
		assertNotNull(jdbcTemplate);
	}
	
	@Test
	public void test1FindAll() {
		List<DeptVo> list=deptDao.findAll();
		assertNotNull(list);
		assertSame(10, list.size());
	}
	
	@Test
	public void test3FindOne() {
		DeptVo bean=deptDao.findOne(target.getDeptno());
		assertEquals(target, bean);
	}
	
	@Test
	public void test2InsertOne() {
		deptDao.insertOne(target);
		assertFalse(false);
	}
	
	@Test
	public void test4UpdateOne() {
		target.setDname("테스트");
		assertSame(1,deptDao.updateOne(target));
	}
	
	@Test
	public void test5DeleteOne() {
		assertSame(1, deptDao.deleteOne(target.getDeptno()));
	}

	@After
	public void tearDown() throws Exception {}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {}

}
