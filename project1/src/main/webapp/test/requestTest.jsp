<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>출력테스트</h1>
	<form action="forwardTest.jsp" method="post">
		<div>forwardTest</div>
		<input type="text" name="fTest"/>
		<input type="submit"/>
	</form>
	<form action="sendRedirectionTest.jsp" method="post">
		<div>sendredirectTest</div>
		<input type="text" name="sTest"/>
		<input type="submit"/>
	</form>
</body>
</html>