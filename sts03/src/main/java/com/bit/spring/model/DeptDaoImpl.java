package com.bit.spring.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class DeptDaoImpl extends JdbcDaoSupport implements DeptDao {

	@Override
	public List<DeptVo> findAll() {
		String sql="select * from dept";
		return getJdbcTemplate().query(sql, new RowMapper<DeptVo>() {

			@Override
			public DeptVo mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new DeptVo(
						rs.getInt("deptno"),rs.getString("dname"),rs.getString("loc")
						);
			}
			
		});
	}

	@Override
	public DeptVo findOne(int rownum) {
		String sql="select * from dept where deptno=?";
		return getJdbcTemplate().queryForObject(sql, new RowMapper<DeptVo>() {

			@Override
			public DeptVo mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new DeptVo(
						rs.getInt("deptno")
						,rs.getString("dname")
						,rs.getString("loc")
						);
			}
			
		},rownum);
	}

	@Override
	public void insertOne(DeptVo bean) {
		String sql="insert into dept values (?,?,?)";
		getJdbcTemplate().update(sql,bean.getDeptno(),bean.getDname(),bean.getLoc());
	}

	@Override
	public int updateOne(DeptVo bean) {
		String sql="update dept set dname=?,loc=? where deptno=?";
		return getJdbcTemplate().update(sql,bean.getDname(),bean.getLoc(),bean.getDeptno());
	}

	@Override
	public int deleteOne(int rownum) {
		String sql="delete from dept where deptno=?";
		return getJdbcTemplate().update(sql,rownum);
	}

}
