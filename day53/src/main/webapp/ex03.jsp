<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.util.*" %>
<%
String[] arr1={"item1","item2","item3","item4"};
pageContext.setAttribute("arr1", arr1);
List arr2=new ArrayList();
//Set arr2=new HashSet();
arr2.add(1111);
arr2.add(2222);
arr2.add(3333);
arr2.add(4444);
pageContext.setAttribute("arr2", arr2);
Map map=new HashMap();
map.put("key1", "val1");
map.put("key2", "val2");
map.put("key3", "val3");
map.put("key4", "val4");
pageContext.setAttribute("map", map);
com.bit.model.DeptVo bean1=new com.bit.model.DeptVo();
pageContext.setAttribute("bean1", bean1);
bean1.setDeptno(1111);
bean1.setDname("user1");
%>
<p>${arr1 }</p>
<ul>
	<li>${arr1[0] }</li>
	<li>${arr1[1] }</li>
	<li>${arr1[2] }</li>
	<li>${arr1[3] }</li>
</ul>
<p>${arr2 }</p>
<ul>
	<li>${arr2[0] }</li>
	<li>${arr2[1] }</li>
	<li>${arr2[2] }</li>
	<li>${arr2[3] }</li>
</ul>
<p>${map }</p>
<ul>
	<li>${map['key1'] }</li>
	<li>${map['key2'] }</li>
	<li>${map['key3'] }</li>
	<li>${map['key4'] }</li>
</ul>
<ul>
	<li>${map.key1 }</li>
	<li>${map.key2 }</li>
	<li>${map.key3 }</li>
	<li>${map.key4 }</li>
</ul>
<p>${bean1 }</p>
<ul>
	<li>${bean1.deptno }</li>
	<li>${bean1.dname }</li>
	<li>${bean1.loc }</li>
</ul>

</body>
</html>








