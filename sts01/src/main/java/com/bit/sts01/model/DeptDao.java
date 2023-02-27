package com.bit.sts01.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

public class DeptDao {
	DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public DeptDao() {}
	
	public List<DeptVo> findAll() throws SQLException{
		String sql="select * from dept";
		List<DeptVo> list=new ArrayList<DeptVo>();
		try(
				Connection conn=dataSource.getConnection();
				PreparedStatement pstmt=conn.prepareStatement(sql);
				ResultSet rs=pstmt.executeQuery();
				){
			while(rs.next())
				list.add(new DeptVo(
						rs.getInt("deptno")
						,rs.getString("dname")
						,rs.getString("loc")
						));
		}
		
		return list;
	}
	public void insertOne(int deptno, String dname, String loc) throws SQLException {
		String sql="insert into dept values (?,?,?)";
		try(
				Connection conn=dataSource.getConnection();
				PreparedStatement pstmt=conn.prepareStatement(sql);
				){
			pstmt.setInt(1, deptno);
			pstmt.setString(2, dname);
			pstmt.setString(3, loc);
			pstmt.executeUpdate();
		}
	}

	public Object findOne(int deptno) throws SQLException {
		String sql="select * from dept where deptno=?";
		try(
				Connection conn=dataSource.getConnection();
				PreparedStatement pstmt=conn.prepareStatement(sql);
				){
			pstmt.setInt(1, deptno);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
				return new DeptVo(
						rs.getInt("deptno")
						,rs.getString("dname")
						,rs.getString("loc")
						);
		}
		return null;
	}

	public void updateOne(String dname, String loc, int deptno) throws SQLException {
		String sql="update dept set dname=?,loc=? where deptno=?";
		try(
				Connection conn=dataSource.getConnection();
				PreparedStatement pstmt=conn.prepareStatement(sql);
				){
			pstmt.setInt(3, deptno);
			pstmt.setString(1, dname);
			pstmt.setString(2, loc);
			pstmt.executeUpdate();
		}
	}
}














