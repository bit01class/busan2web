<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>EL 표현식</h1>
	<p><%=1+2+3+4 %></p>
	<p>${1+2+3+4 }</p>
	<h2>자료형 표현</h2>
	<table>
	<tr>
		<td>자료형</td>
		<td>jsp</td>
		<td>el</td>
	</tr>
	<tr>
		<td>숫자(10진수 정수)</td>
		<td><%=1234 %></td>
		<td>${1234 }</td>
	</tr>
	<tr>
		<td>숫자(실수)</td>
		<td><%=3.14 %></td>
		<td>${3.14 }</td>
	</tr>
	<tr>
		<td>연산(정수)</td>
		<td><%=1+2+3 %></td>
		<td>${1+2+3 }</td>
	</tr>
	<tr>
		<td>연산(정수)</td>
		<td><%=6*2 %></td>
		<td>${6*2 }</td>
	</tr>
	<tr>
		<td>연산(정수)</td>
		<td><%=5/2 %></td>
		<td>${5/2 }</td>
	</tr>
	<tr>
		<td>연산(정수)</td>
		<td><%=5%2 %></td>
		<td>${5%2 }</td>
	</tr>
	<tr>
		<td>문자열</td>
		<td><%='A' %></td>
		<td>${'Abc' }</td>
	</tr>
	<tr>
		<td>문자열</td>
		<td><%="Abc" %></td>
		<td>${"Abc" }</td>
	</tr>
	<tr>
		<td>boolean</td>
		<td><%=true %></td>
		<td>${true }</td>
	</tr>
	<tr>
		<td>boolean</td>
		<td><%=false %></td>
		<td>${false }</td>
	</tr>
	<tr>
		<td>object</td>
		<td><%=new java.util.Date() %></td>
		<td>${null }</td>
	</tr>
	<tr>
		<td>object</td>
		<td><%="" %></td>
		<td>${"" }</td>
	</tr>
	<jsp:useBean id="bean" class="java.util.Date"></jsp:useBean>
	<tr>
		<td>객체</td>
		<td><%=bean %></td>
		<td>${bean }</td>
	</tr>
	</table>
</body>
</html>













