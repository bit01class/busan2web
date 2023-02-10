package com.bit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BitSql {
	private static Connection conn;
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	static {
		driver="com.mysql.cj.jdbc.Driver";
		url="jdbc:mysql://localhost:3306/lecture";
		user=System.getenv("MYSQL_USER");
		password=System.getenv("MYSQL_PW");
	}
	
	private BitSql(){}
	
	public static Connection getConnection() {
		try {
			if(conn==null || conn.isClosed()) {
				Class.forName(driver);
				conn=DriverManager.getConnection(url, user, password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
}






