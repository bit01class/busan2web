package com.bit.sts04.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.DefaultTransactionStatus;
import org.springframework.transaction.support.TransactionOperations;

public class DeptDaoImpl extends JdbcDaoSupport implements DeptDao{
	PlatformTransactionManager transactionManager;
	
	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}
	
	@Override
	public List<DeptVo> findAll(){
		String sql="select * from dept";
		return getJdbcTemplate().query(sql, new RowMapper<DeptVo>() {

			@Override
			public DeptVo mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new DeptVo(
						rs.getInt("deptno"),rs.getString("dname"),rs.getNString("loc")
						);
			}
			
		});
	}
	@Override
	public DeptVo findOne(int key) {
		String sql="select * from dept where deptno=?";
		return getJdbcTemplate().queryForObject(sql, new RowMapper<DeptVo>() {

			@Override
			public DeptVo mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new DeptVo(
						rs.getInt("deptno"),rs.getString("dname"),rs.getString("loc")
						);
			}
			
		},key);
	}
	@Override
	public void insertOne(final DeptVo bean) {
		final String sql="UPDATE dept_seq SET num=num+1";
		final String sql2="INSERT INTO dept VALUE ((SELECT num FROM dept_seq),CONCAT(?,(SELECT num FROM dept_seq)),?)";
		
		TransactionDefinition definition=new DefaultTransactionDefinition();
		TransactionStatus status=transactionManager.getTransaction(definition);
		try {
			PreparedStatementCreator psc=new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
					System.out.println(conn.hashCode());
					return conn.prepareStatement(sql);
				}
			};
			getJdbcTemplate().update(psc);
			psc=new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
					System.out.println(conn.hashCode());
					PreparedStatement pstmt = conn.prepareStatement(sql2);
					pstmt.setString(1, bean.getDname());
					pstmt.setString(2, bean.getLoc());
					return pstmt;
				}
			};
			getJdbcTemplate().update(psc);

			transactionManager.commit(status);
		}catch (Exception e) {
			transactionManager.rollback(status);
		}
	}
	@Override
	public int updateOne(DeptVo bean) {
		String sql="update dept set dname=?,loc=? where deptno=?";
		return getJdbcTemplate().update(sql,bean.getDname(),bean.getLoc(),bean.getDeptno());
	}
	@Override
	public int deleteOne(int key) {
		String sql="delete from dept where deptno=?";
		return getJdbcTemplate().update(sql,key);
	}
	

}
