<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="bean" class="com.bit.BbsBean"/>
<jsp:setProperty property="*" name="bean"/>
<%@ include file="template/sql.jspf" %>
<%
if("POST".equals(request.getMethod())){
	String sql="insert into bbs36 values ";
	sql+="((select max(num)+1 from bbs36 a),'";
	sql+=bean.getSub()+"','"+bean.getContent();
	sql+="',(select max(num)+1 from bbs36 b),0,0)";
	try{
		conn=getConnection();
		stmt=conn.createStatement();
		stmt.executeUpdate(sql);
	}finally{
		if(stmt!=null)stmt.close();
		if(conn!=null)conn.close();
	}
	response.sendRedirect("list.jsp");
	return;
}
%>
<h1>입력페이지</h1>
<form  method="post">
	<input type="text" name="sub" placeholder="제목입력"><br>
	<textarea name="content" placeholder="내용입력"></textarea><br>
	<input type="submit" value="입력">
</form>
</body>
</html>