package com.bit.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmpDao {
	java.util.logging.Logger log=Logger.getGlobal();
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public void getConnection() {
		String url="jdbc:mysql://localhost:3306/lecture";
		String user=System.getenv("MYSQL_USER");
		String password=System.getenv("MYSQL_PW");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			if(conn==null || conn.isClosed())
			conn=DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int deleteOne(int empno) throws SQLException {
		String sql="delete from emp where empno=?";
		try {
			getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, empno);
			int result=pstmt.executeUpdate();
			log.info("delete result="+result);
			return result;
		}finally {
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
	}
	
	public int editOne(int empno,String ename,int comm,int sal,int mgr) throws SQLException {
		String sql="update emp set ename=?,sal=?,comm=?,mgr=? where empno=?";
		try {
			getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,ename);
			pstmt.setInt(2, sal);
			pstmt.setInt(3, comm);
			pstmt.setInt(4, mgr);
			pstmt.setInt(5, empno);
			int result=pstmt.executeUpdate();
			log.info("update cnt="+result);
			return result;
		}finally {
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
	}
	
	public EmpDto getOne(int empno) throws SQLException {
		String sql="select * from emp where empno=?";
		EmpDto bean=new EmpDto();
		try {
			getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, empno);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				bean.setComm(rs.getInt("comm"));
				bean.setEmpno(rs.getInt("empno"));
				bean.setEname(rs.getNString("ename"));
				bean.setHiredate(rs.getDate("hiredate"));
				bean.setJob(rs.getNString("job"));
				bean.setMgr(rs.getInt("mgr"));
				bean.setSal(rs.getInt("sal"));
				log.info(bean.toString());
			}
		}finally {
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
		
		return bean;
	}
	
	public int pushList(int empno,String ename, int sal) 
									throws SQLException {
		String sql="insert into emp (empno,ename,hiredate,sal)";
		sql+=" values (?,?,now(),?)";
		try {
			getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, empno);
			pstmt.setString(2, ename);
			pstmt.setInt(3, sal);
			return pstmt.executeUpdate();
		}finally {
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
	}

	public List<EmpDto> getList() throws SQLException{
		String sql="select * from emp";
		List<EmpDto> list=null;
		list=new ArrayList<EmpDto>();
		try {
			getConnection();
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				EmpDto bean=new EmpDto();
				bean.setEmpno(rs.getInt("empno"));
				bean.setEname(rs.getNString("ename"));
				bean.setHiredate(rs.getDate("hiredate"));
				bean.setSal(rs.getInt("sal"));
				log.info(bean.toString());
				list.add(bean);
			}
		} finally {
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				log.severe(e.toString());
			}
		}
		return list;
	}
}




