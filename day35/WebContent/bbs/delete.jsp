<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../template/header.jsp"/>
<jsp:include page="../template/menu.jsp">
	<jsp:param value=".." name="path"/>
</jsp:include>
<jsp:useBean id="bean" class="com.bit.BbsBean"/>
<jsp:setProperty property="num" name="bean"/>
<%@ page import="com.bit.LocalSql,java.sql.*" %>
<%
if("POST".equals(request.getMethod())){
	String sql="delete from bbs35 where num="+bean.getNum();
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
	response.sendRedirect("list.jsp");
	return;
}
%>
<center>
	<h1><jsp:getProperty property="num" name="bean"/>번 글삭제</h1>
	<p>삭제 하시겠습니까?</p>
	<form action="delete.jsp" method="post">
		<input type="hidden" name="num" value="<%=bean.getNum()%>">
		<input type="submit" value="확인">
		<input type="button" value="뒤로" onclick="history.back()">
	</form>
</center>
<jsp:include page="../template/footer.jsp"/>

</body>
</html>