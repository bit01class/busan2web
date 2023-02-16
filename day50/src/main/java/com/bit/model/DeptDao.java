package com.bit.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DeptDao {
	Logger log=Logger.getLogger(this.getClass().getCanonicalName());
	Connection conn;
	
	public DeptDao() throws SQLException {
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/TestDB");
			conn = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public int updateOne(DeptDto bean) throws SQLException {
		String sql="update dept set dname=?,loc=? where deptno=?";
		try(
				Connection conn=this.conn;
				PreparedStatement pstmt=conn.prepareStatement(sql);
				){
			pstmt.setString(1, bean.getDname());
			pstmt.setString(2, bean.getLoc());
			pstmt.setInt(3, bean.getDeptno());
			return pstmt.executeUpdate();
		}
	}
	
	public void insertOne(DeptDto bean) throws SQLException{
		String sql="insert into dept values (?,?,?)";
		try(
				Connection conn=this.conn;
				PreparedStatement pstmt=conn.prepareStatement(sql);
				){
			pstmt.setInt(1, bean.getDeptno());
			pstmt.setString(2, bean.getDname());
			pstmt.setString(3, bean.getLoc());
			pstmt.executeUpdate();
		}
	}
	
	public List<DeptDto> selectAll() throws SQLException{
		String sql="select * from dept";
		List<DeptDto> list=new ArrayList<>();
		try(
				Connection conn=this.conn;
				PreparedStatement pstmt=conn.prepareStatement(sql);
				ResultSet rs=pstmt.executeQuery();
				){
			while(rs.next()) {
				DeptDto bean=new DeptDto();
				bean.setDeptno(rs.getInt("deptno"));
				bean.setDname(rs.getString("dname"));
				bean.setLoc(rs.getString("loc"));
				log.info(bean.toString());
				list.add(bean);
			}
		}
		return list;
	}

	
	public List<DeptDto> selectOne(int deptno) throws SQLException{
		String sql="select * from dept where deptno=?";
		List<DeptDto> list=new ArrayList<>();
		try(
				Connection conn=this.conn;
				PreparedStatement pstmt=conn.prepareStatement(sql);
				){
			pstmt.setInt(1, deptno);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				DeptDto bean=new DeptDto();
				bean.setDeptno(rs.getInt("deptno"));
				bean.setDname(rs.getString("dname"));
				bean.setLoc(rs.getString("loc"));
				log.info(bean.toString());
				list.add(bean);
			}
		}
		return list;
	}
}
