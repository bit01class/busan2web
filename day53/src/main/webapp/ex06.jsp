<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>jstl 조건문</h1>
	<jsp:useBean id="bean" class="com.bit.model.DeptVo"></jsp:useBean>
	<jsp:setProperty property="deptno" name="bean" value="-12"/>
	<c:if test="${bean.deptno gt 0 }">
		<p>0보다 크고</p>
		<c:if test="${bean.deptno gt 1 }">
		<p>1보다 크다</p>
		</c:if>
		<c:if test="${bean.deptno le 1 }">
		<p>1보다 작거나 같다</p>		
		</c:if>
	</c:if>
	<hr/>
	<c:choose>
		<c:when test="${bean.deptno>2 }">item1</c:when>
		<c:when test="${bean.deptno>1 }">item2</c:when>
		<c:when test="${bean.deptno>0 }">item3</c:when>
		<c:otherwise>몰라</c:otherwise>
	</c:choose>
	
</body>
</html>









