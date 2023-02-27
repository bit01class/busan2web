package com.bit.struts.model;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.mysql.cj.jdbc.MysqlDataSource;

public class DeptDao {
	SqlMapClient sqlMapClient;

	public DeptDao(){
		try {
			Reader reader= Resources.getResourceAsReader("/SqlMapConfig.xml");
			System.out.println(reader.ready());
			sqlMapClient=SqlMapClientBuilder.buildSqlMapClient(reader);
			System.out.println(sqlMapClient);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<DeptVo> findAll() throws SQLException{
		List<DeptVo> list=sqlMapClient.queryForList("selectAll");
		return list;
	}

	public void insertOne(DeptVo bean) throws SQLException {
		sqlMapClient.insert("insertOne",bean);
	}

	public DeptVo findOne(int deptno) throws SQLException {
		return (DeptVo) sqlMapClient.queryForObject("selectOne",deptno);
	}
	
	public int updateOne(DeptVo bean) throws SQLException {
		return sqlMapClient.update("updateOne",bean);
	}

	public int deleteOne(int deptno) throws SQLException {
		return sqlMapClient.delete("deleteOne",deptno);
	}
}














