<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>파일업로드</h1>
	<form method="post" enctype="multipart/form-data">
		<div>
			<label>name</label>
			<input name="name"/>
		</div>
		<div>
			<label>file</label>
			<input type="file" name="file1"/>
		</div>
		<div>
			<button>전송</button>
		</div>
	</form>
</body>
</html>