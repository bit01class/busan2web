<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../template/sql.jspf" %>
<jsp:useBean id="bean" class="com.bit.EmpBean"/>
<jsp:setProperty property="empno" name="bean"/>
<jsp:setProperty property="read" name="bean"/>
<%
String sql="select * from emp where empno="+bean.getEmpno();
try{
	conn=getConnection();
	stmt=conn.createStatement();
	rs=stmt.executeQuery(sql);
	if(rs.next()){
		bean.setEname(rs.getString("ename"));
		bean.setJob(rs.getString("job"));
		bean.setMgr(rs.getInt("mgr"));
		bean.setHiredate(rs.getTimestamp("hiredate"));
		bean.setSal(rs.getInt("sal"));
		bean.setComm(rs.getInt("comm"));
		bean.setDeptno(rs.getInt("deptno"));
	}
}finally{
	if(rs!=null)rs.close();
	if(stmt!=null)stmt.close();
	if(conn!=null)conn.close();
}
%>
	<h1>상세페이지</h1>
	<form action="bbs/update.jsp">
	<table width="400" align="center">
		<tr>
			<td>empno</td>
			<td><input type="text" name="empno" value="<%=bean.getEmpno()%>" readonly></td>
		</tr>
		<tr>
			<td>ename</td>
			<td><input type="text" name="ename" value="<%=bean.getEname()%>" <%=bean.isRead()?"readonly":"" %>></td>
		</tr>
		<tr>
			<td>job</td>
			<td><input type="text" name="job" value="<%=bean.getJob()%>" <%=bean.isRead()?"readonly":"" %>></td>
		</tr>
		<tr>
			<td>mgr</td>
			<td><jsp:getProperty property="mgr" name="bean"/></td>
		</tr>
		<tr>
			<td>hiredate</td>
			<td><jsp:getProperty property="hiredate" name="bean"/></td>
		</tr>
		<tr>
			<td>sal</td>
			<td><input type="text" name="sal" value="<%=bean.getSal()%>" <%=bean.isRead()?"readonly":"" %>></td>
		</tr>
		<tr>
			<td>comm</td>
			<td><input type="text" name="comm" value="<%=bean.getComm()%>" <%=bean.isRead()?"readonly":"" %>></td>
		</tr>
		<tr>
			<td>deptno</td>
			<td><input type="text" name="deptno" value="<%=bean.getDeptno()%>" <%=bean.isRead()?"readonly":"" %>></td>
		</tr>
		<tr>
			<td colspan="2">
			<%if(!bean.isRead()){ %>
			<input type="submit" value="수정">
			<input type="reset" value="취소">
			<%}else{ %>
			<a href="./?title=bbs/detail&empno=<%=bean.getEmpno() %>&read=false">[수정]</a>
			<a href="bbs/delete.jsp?empno=<%=bean.getEmpno() %>">[삭제]</a>
			<%}%>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>