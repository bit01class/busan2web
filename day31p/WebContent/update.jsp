<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="refresh" content="0; url=detail.jsp?num=<%=request.getParameter("num")%>">
<title>Insert title here</title>
</head>
<body>
	<%@ page import="java.sql.*,java.util.Map" %>
	<%
	String sql="update bbs01 set sub='"+request.getParameter("sub");
	sql+="', content='"+request.getParameter("content")+"', nalja=now() ";
	sql+=" where num="+request.getParameter("num");
	System.out.println(sql);
	Map<String,String> env=System.getenv();
	String driver="com.mysql.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/lecture";
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









