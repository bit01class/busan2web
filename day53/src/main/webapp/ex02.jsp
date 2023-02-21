<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>el 연산</h1>
	<table>
		<tr>
			<td>1+2</td>
			<td>${1+2 }</td>
		</tr>
		<tr>
			<td>6*2</td>
			<td>${6*2 }</td>
		</tr>
		<tr>
			<td>6/2</td>
			<td>${6/2 }</td>
		</tr>
		<tr>
			<td>6/2</td>
			<td>${6 div 2 }</td>
		</tr>
		<tr>
			<td>5%2</td>
			<td>${5%2 }</td>
		</tr>
		<tr>
			<td>5%2</td>
			<td>${5 mod 2 }</td>
		</tr>
		<tr>
			<td>5>2</td>
			<td>${5>2 }</td>
		</tr>
		<tr>
			<td>5>2</td>
			<td>${5 gt 2 }</td>
		</tr>
		<tr>
			<td>5<2</td>
			<td>${5<2 }</td>
		</tr>
		<tr>
			<td>5<2</td>
			<td>${5 lt 2 }</td>
		</tr>
		<tr>
			<td>5>=2</td>
			<td>${5 ge 2 }</td>
		</tr>
		<tr>
			<td>5<=2</td>
			<td>${5 le 2 }</td>
		</tr>
		<tr>
			<td>5==2</td>
			<td>${5 ==5 }</td>
		</tr>
		<tr>
			<td>5==2</td>
			<td>${5 eq 5 }</td>
		</tr>
		<jsp:useBean id="bean1" class="java.lang.Object"></jsp:useBean>
		<jsp:useBean id="bean2" class="java.lang.Object"></jsp:useBean>
		<tr>
			<td>bean1==bean2</td>
			<td>${bean1 == bean2 }</td>
		</tr>
		<tr>
			<td>bean1==bean2</td>
			<td>${bean1 eq bean2 }</td>
		</tr>
		<jsp:useBean id="msg1" class="java.lang.String"></jsp:useBean>
		<jsp:useBean id="msg2" class="java.lang.String"></jsp:useBean>
		<tr>
			<td>msg1==msg2</td>
			<td>${msg1==msg2 }</td>
		</tr>
		<tr>
			<td>msg1==msg2</td>
			<td>${msg1 eq msg2 }</td>
		</tr>
		<tr>
			<td>msg1==""</td>
			<td>${msg1 == "" }</td>
		</tr>
		<tr>
			<td>msg1==""</td>
			<td>${msg1 eq "" }</td>
		</tr>
		<tr>
			<td>msg1=="abc"</td>
			<td>${msg1 eq "abc" }</td>
		</tr>
		<tr>
			<td>msg1==null?"":msg1</td>
			<td>${msg1==null?"":msg1 }</td>
		</tr>
		<tr>
			<td>msg1==null?"":msg1</td>
			<td>${msg1}</td>
		</tr>
	</table>
	<pre>
	"}" ...
    "." ...
    "[" ...
    ">" ...
    "gt" ...
    "<" ...
    "lt" ...
    ">=" ...
    "ge" ...
    "<=" ...
    "le" ...
    "==" ...
    "eq" ...
    "!=" ...
    "ne" ...
    "&&" ...
    "and" ...
    "||" ...
    "or" ...
    "*" ...
    "+" ...
    "-" ...
    "/" ...
    "div" ...
    "%" ...
    "mod" ...
	</pre>
</body>
</html>










