<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.Map" %>
<%
String sql="insert into emp (empno,ename,hiredate,sal,comm,deptno) "	
		+"values ("+request.getParameter("empno")
		+",'"+request.getParameter("ename")+"', now(),"
		+request.getParameter("sal")+","
		+request.getParameter("comm")+","
		+request.getParameter("deptno")+")";
System.out.println(sql);
Connection conn=null;
Statement stmt=null;
Map<String,String> env=System.getenv();
try{
	Class.forName("com.mysql.jdbc.Driver");
	conn=DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/lecture"
			,env.get("local.mysql.user")
			,env.get("local.mysql.password")
			);
	stmt=conn.createStatement();
	stmt.executeUpdate(sql);
	out.println("<h1 align=\"center\">입력 성공</h1>");
	out.println("<p align=\"center\"><a href=\"index.jsp\">이동</a></p>");
}finally{
	if(stmt!=null)stmt.close();
	if(conn!=null)conn.close();
}
%>
</body>
</html>










