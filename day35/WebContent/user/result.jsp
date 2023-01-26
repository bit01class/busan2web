<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="user" class="com.bit.UserBean"/>
<jsp:setProperty property="*" name="user"/>
<%
if("GET".equals(request.getMethod())){
	response.sendRedirect("../login/login.jsp");
	return ;
}
if(!user.getPw().equals(user.getRe())){
	response.sendRedirect("join.jsp?id="+user.getId());
	return;
}
String sql="insert into user35 values (0,'";
sql+=user.getId()+"',md5('"+user.getPw()+"'))";
Connection conn=null;
Statement stmt=null;
try{
	conn=LocalSql.getConnection();
	stmt=conn.createStatement();
	stmt.executeUpdate(sql);
}finally{
	if(stmt!=null)stmt.close();
	if(conn!=null)conn.close();
}
%>
<%@ page import="java.sql.*,com.bit.LocalSql" %>
<jsp:forward page="list.jsp"></jsp:forward>
</body>
</html>

