<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
com.bit.model.DeptVo bean1=new com.bit.model.DeptVo(1111,"user1",null);
com.bit.model.DeptVo bean2=new com.bit.model.DeptVo(2222,"user2",null);
com.bit.model.DeptVo bean3=new com.bit.model.DeptVo(3333,"user3",null);
com.bit.model.DeptVo bean4=new com.bit.model.DeptVo(4444,"user4",null);
pageContext.setAttribute("bean", bean1);
request.setAttribute("bean", bean2);
session.setAttribute("bean", bean3);
application.setAttribute("bean",bean4);
%>

<p>${bean }</p>
<p>${pageScope.bean }</p>
<p>${requestScope.bean }</p>
<p>${sessionScope.bean }</p>
<p>${applicationScope.bean }</p>


<hr/>
<p>${request }</p>
<p>${response }</p>
<p>${pageContext.request.contextPath }/emp/list.do</p>
</body>
</html>

















