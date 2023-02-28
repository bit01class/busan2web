package com.bit.sts02.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class DeptDaoImpl extends JdbcDaoSupport implements DeptDao{

	public List<DeptVo> findAll(){
		String sql="select * from dept order by deptno";
		return getJdbcTemplate().query(sql,new RowMapper<DeptVo>() {

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
		getJdbcTemplate().update(sql, new Object[] {bean.getDeptno(),bean.getDname(),bean.getLoc()});
	}

	public DeptVo findOne(int deptno) {
		String sql="select * from dept where deptno=?";
		return getJdbcTemplate().queryForObject(sql, new RowMapper<DeptVo>() {

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
		return getJdbcTemplate()
				.update(sql,bean.getDname(),bean.getLoc(),bean.getDeptno());
	}

	public int deleteOne(int deptno) {
		String sql="delete from dept where deptno=?";
		return getJdbcTemplate().update(sql,deptno);
	}
}







