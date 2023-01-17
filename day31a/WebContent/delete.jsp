<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.sql.*,java.util.Map" %>
<%
String driver="com.mysql.jdbc.Driver";
String url="jdbc:mysql://localhost:3306/lecture";
Map<String,String> env=System.getenv();
String user=env.get("local.mysql.user");
String password=env.get("local.mysql.password");
Connection conn=null;
Statement stmt=null;
try{
	Class.forName(driver);
	conn=DriverManager.getConnection(url, user, password);
	stmt=conn.createStatement();
	if(stmt.executeUpdate("delete from emp where empno="
					+request.getParameter("empno"))
			>0
	){
	out.println("<h1 align=\"center\">삭제 완료</h1>");
	out.print("<p align=\"center\">");
	out.print("<a href=\"index.jsp\">");
	out.print("돌아가기</a>");	
	out.println("</p>");
	}
}finally{
	if(stmt!=null)stmt.close();
	if(conn!=null)conn.close();
}
%>
</body>
</html>










