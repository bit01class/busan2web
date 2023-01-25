<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../template/header.jspf" %>
<%@ include file="../template/menu2.jspf" %>
	<h2>학생목록</h2>
	<table align="center" width="400">
		<tr>
			<th>학번</th>
			<th>이름</th>
		</tr>
		<%@page import="com.bit.user.LocalMysql,java.sql.*" %>
		<%!
		Connection conn;
		Statement stmt;
		ResultSet rs;
		%>
		<%
		try{
			conn=LocalMysql.getConnection();
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from user33");
			while(rs.next()){
		%>
		<tr>
			<td><%=rs.getInt("num") %></td>
			<td bgcolor="<%=rs.getString("gender").equals("m")?"9999ff":"ff9999"%>"><%=rs.getString("name") %></td>
		</tr>
		<%}
		}finally{
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		} 
		%>
	</table>
<%@ include file="../template/footer.jspf" %>
</body>
</html>