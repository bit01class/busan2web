package com.bit.sts06.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import lombok.Setter;

//@Repository
public class DeptDaoJdbcImpl implements DeptDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<DeptVo> findAll(){
		return jdbcTemplate.query("select * from dept", new RowMapper<DeptVo>() {

			@Override
			public DeptVo mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new DeptVo(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
			
		});
	}
	@Override
	public DeptVo findObject(int key) {
		String sql="select * from dept where deptno=?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<DeptVo>() {

			@Override
			public DeptVo mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new DeptVo(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
			
		},key);
	}
	@Override
	public void insertOne(DeptVo bean) {
		String sql="insert into dept values (?,?,?)";
		jdbcTemplate.update(sql,bean.getDeptno(),bean.getDname(),bean.getLoc());
	}
	@Override
	public int updateOne(DeptVo bean) {
		return jdbcTemplate.update("update dept set dname=?,loc=? where deptno=?"
					,bean.getDname(),bean.getLoc(),bean.getDeptno());
	}
	@Override
	public int deleteOne(int key) {
		return jdbcTemplate.update("delete from dept where deptno=?",key);
	}
	
}














