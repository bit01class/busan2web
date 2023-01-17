<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="refresh" content="0; url=list.jsp">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.sql.*,java.util.Map" %>
<%
String id=request.getParameter("id");
String sub=request.getParameter("sub");
String content=request.getParameter("content");
String sql="insert into bbs01 (id,sub,content,nalja)";
sql+="values ('"+id+"','"+sub+"','"+content+"',now())";
System.out.println(sql);
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
	stmt.executeUpdate(sql);
}finally{
	if(stmt!=null)stmt.close();
	if(conn!=null)conn.close();
}
%>
</body>
</html>











