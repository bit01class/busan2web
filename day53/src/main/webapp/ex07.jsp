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
<%@ page import="java.util.*,com.bit.model.DeptVo" %>
<%
String[] arr1=java.util.Arrays
						.asList("item1","item2","item3","item4")
						.toArray(new String[]{});
List list=java.util.Arrays.asList("list1","list2","list3","list4");
Set set=new HashSet(list);
Map map=new HashMap();
map.put("key1", "val1");
map.put("key2", "val2");
map.put("key3", "val3");
map.put("key4", "val4");


List<DeptVo> alist=Arrays.asList(
		new DeptVo(1111,"user1","test"),
		new DeptVo(2222,"user2","test"),
		new DeptVo(3333,"user3","test"),
		new DeptVo(4444,"user4","test")
		);

pageContext.setAttribute("arr1", alist);

/*
${status.current} 현재 for문의 해당하는 번호
${status.index} 0부터의 순서
${status.count} 1부터의 순서
${status.first} 첫 번째인지 여부
${status.last} 마지막인지 여부
${status.begin} for문의 시작 번호
${status.end} for문의 끝 번호
${status.step} for문의 증가값
*/

%>
	<h1>반복문</h1>
	<ol>
	<c:forEach begin="1" end="10" var="num" step="2" varStatus="status">
		<li>item - ${num }  - ${status.current } - ${status.index } - ${status.count }</li>
	</c:forEach>
	</ol>
	<ol>
	<c:forEach items="${arr1 }" var="item" varStatus="status">
		<li>${item } - ${status.current } - ${status.index } - ${status.count }</li>
	</c:forEach>
	</ol>
</body>
</html>










