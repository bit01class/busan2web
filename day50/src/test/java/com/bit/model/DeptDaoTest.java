package com.bit.model;

import static org.junit.Assert.*;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.junit.Test;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
import com.mysql.jdbc.Driver;

public class DeptDaoTest {

	@Test
	public void testSelectAll() throws SQLException, ClassNotFoundException, NamingException {
		DeptDao dao=new DeptDao();
		Class.forName(Driver.class.getCanonicalName());
		String url="jdbc:mysql://localhost:3306/lecture";
		String user=System.getenv("MYSQL_USER");
		String password=System.getenv("MYSQL_PW");
//		dao.conn=DriverManager.getConnection(url, user, password);
		MysqlConnectionPoolDataSource ds=null;
		ds=new MysqlConnectionPoolDataSource();
		ds.setUrl(url);
		ds.setUser(user);
		ds.setPassword(password);
		dao.conn=ds.getConnection();
		List<DeptDto>list=dao.selectAll();
		assertNotNull("널이 아닐꺼야",list);
		assertTrue("분명 사이즈가 0일꺼야",list.size()>0);
	}

}








