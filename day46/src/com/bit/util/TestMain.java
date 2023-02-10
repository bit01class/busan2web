package com.bit.util;

import java.sql.Connection;
import java.sql.SQLException;

public class TestMain {

	public static void main(String[] args) throws SQLException {
		Connection conn = BitSql.getConnection();
		System.out.println(conn!=null);
		if(conn!=null)conn.close();
	}

}
