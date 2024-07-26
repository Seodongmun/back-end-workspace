<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원검색</h1>
	<h2>검색할 아이디를 입력하세요</h2>
	<!-- get방식은 생략 가능 -->>
	<form action="/search" method = "get">
	검색할 회원 아아디 : <input type="text" name="id">
	<input type="submit" value ="검색">
	</form>
</body>
</html>