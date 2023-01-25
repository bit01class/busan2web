<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../template/head.jspf" %>
<%
int num=Integer.parseInt(request.getParameter("num"));
if(request.getMethod().equals("POST")){
	String sql="delete from stu33 where num="+num;
	
	try{
		stmt=getConnection().createStatement();
		stmt.executeUpdate(sql);
	}finally{
		if(stmt!=null)stmt.close();
		if(getConnection()!=null)getConnection().close();
	}
	response.sendRedirect("list.jsp");
}
%>
<%@ include file="../template/header.jspf" %>
<%@ include file="../template/menu2.jspf" %>
<center>
<h2><%=num %>번 성적을 삭제하시겠습니까?</h2>
<form action="delete.jsp" method="post">
	<input type="hidden" name="num" value="<%=num%>">
	<input type="submit" value="확인">
	<input type="button" value="취소" onclick="history.back()">
</form>
</center>
<%@ include file="../template/footer.jspf" %>
</body>
</html>





