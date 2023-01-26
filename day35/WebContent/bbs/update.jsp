<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="bean" class="com.bit.BbsBean"/>
<jsp:setProperty property="*" name="bean"/>
<%@ page import="com.bit.LocalSql,java.sql.*" %>
<%
if(request.getMethod().equals("GET")){
	response.sendRedirect("edit.jsp?num="+bean.getNum());
	return;
}
String sql="update bbs35 set sub='"+bean.getSub();
sql+="',content='"+bean.getContent()+"' where num=";
sql+=bean.getNum();
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
response.sendRedirect("detail.jsp?num="+bean.getNum());
%>
</body>
</html>


