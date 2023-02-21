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
<h1>ex09 page</h1>
<div id="target">
	<c:import url="http://www.kma.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=159"></c:import>
</div>
<p>여기까지</p>
</body>
</html>