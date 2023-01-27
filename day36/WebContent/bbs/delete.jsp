<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="bean" class="com.bit.EmpBean"/>
<jsp:setProperty property="empno" name="bean"/>
<%@ include file="../template/sql.jspf" %>
<%
String sql="delete from emp where empno="+bean.getEmpno();
try{
	conn=getConnection();
	stmt=conn.createStatement();
	stmt.executeUpdate(sql);
}finally{
	if(stmt!=null)stmt.close();
	if(conn!=null)conn.close();
}
response.sendRedirect("../?title=bbs/list");
%>
</body>
</html>