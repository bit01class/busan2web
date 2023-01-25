package com.bit.user;

import java.sql.*;
import java.util.Map;

public class LocalMysql {
	private static Connection conn;
	private LocalMysql() {}
	public static Connection getConnection() {
		Map<String,String> env=System.getenv();
		try {
			if(conn==null || conn.isClosed()) {
				Class.forName("com.mysql.jdbc.Driver");
				conn=DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/lecture"
						,env.get("local.mysql.user")
						,env.get("local.mysql.password")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
