<%@page import="java.util.ArrayList"%>
<%@page import="com.kh.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>전체 회원 정보</h1>
		<h1>전체 회원 목록</h1>
		<a href="/">메인페이지로 이동</a>
		<% ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("allMemberInfo"); %>
		<table border = "1">
			<tr>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
			</tr>
			<% for (Member m : list){ %>
			<tr>
				<td><%= m.getId()%></td>
				<td><%= m.getPassword()%></td>
				<td><%= m.getName()%></td>
			</tr>
			<% }%>
		</table>
</body>
</html>