package com.bit.stu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StuDao {
	Connection conn;
	Statement stmt;
	ResultSet rs;
	
	public ArrayList<int[]> selectAll() {
		ArrayList<int[]> list=new ArrayList<int[]>();
		String sql="select num,kor,eng,math from stu33 order by num";
		try {
			conn=LocalMySql.getConnection();
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				int[] stu=new int[] {
						rs.getInt(1),rs.getInt(2)
						,rs.getInt(3),rs.getInt(4)};
				list.add(stu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
		
	}
	
	
	public void insertOne(int kor, int eng, int math) {
		String sql="insert into stu33 (kor,eng,math) values (";
		sql+=kor+","+eng+","+math+")";
		try {
			conn=LocalMySql.getConnection();
			stmt=conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt!=null)stmt.close();
				if(LocalMySql.getConnection()!=null)
					LocalMySql.getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
