package com.bit.sts02.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class DeptDaoImpl2 implements DeptDao{
	JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<DeptVo> findAll(){
		String sql="select * from dept order by deptno desc";
		return jdbcTemplate.query(sql,new RowMapper<DeptVo>() {

			@Override
			public DeptVo mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new DeptVo(
						rs.getInt(1),rs.getString(2),rs.getString(3)
						);
			}
		});
	}
	
	public void insertOne(DeptVo bean) {
		String sql="insert into dept values (?,?,?)";
		jdbcTemplate.update(sql, new Object[] {bean.getDeptno(),bean.getDname(),bean.getLoc()});
	}

	public DeptVo findOne(int deptno) {
		String sql="select * from dept where deptno=?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<DeptVo>() {

			@Override
			public DeptVo mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new DeptVo(
						rs.getInt(1),rs.getString(2),rs.getString(3)
						);
			}
			
		},deptno);
	}

	public int updateOne(DeptVo bean) {
		String sql="update dept set dname=?,loc=? where deptno=?";
		return jdbcTemplate
				.update(sql,bean.getDname(),bean.getLoc(),bean.getDeptno());
	}

	public int deleteOne(int deptno) {
		String sql="delete from dept where deptno=?";
		return jdbcTemplate.update(sql,deptno);
	}
}







