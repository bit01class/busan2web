<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>상세보기</h1>
<jsp:useBean id="bean" class="com.bit.BbsBean"/>
<jsp:setProperty property="num" name="bean"/>
<%@ include file="template/sql.jspf" %>
<%
String sql="select * from bbs36 where num="+bean.getNum();
try{
	conn=getConnection();
	stmt=conn.createStatement();
	rs=stmt.executeQuery(sql);
	if(rs.next()){
		bean.setSub(rs.getString("sub"));
		bean.setContent(rs.getString("content"));
		bean.setRef(rs.getInt("ref"));
		bean.setSeq(rs.getInt("seq"));
		bean.setLvl(rs.getInt("lvl"));
	}
}finally{
	if(rs!=null)rs.close();
	if(stmt!=null)stmt.close();
	if(conn!=null)conn.close();
}
%>
<h3><jsp:getProperty name="bean" property="sub"/></h3>
<p><pre><jsp:getProperty property="content" name="bean"/></pre></p>
<p><a href="re.jsp?num=<%=bean.getNum()%>&ref=<%=bean.getRef()%>&seq=<%=bean.getSeq() %>&lvl=<%=bean.getLvl()%>">[답글]</a></p>
</body>
</html>

