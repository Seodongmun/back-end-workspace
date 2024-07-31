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
<c:choose>
		<c:when test="${not empty vo}">
<!-- 업데이트, 비밀번호 변경, 로그아웃 -->
			<ul>
				<li><a href="/logout">로그아웃</a></li>
			</ul>
			<form action="/update" method="post">
				아이디 : <input type="text" name="id" value="${vo.id}" readonly><br> 
				비밀번호 : <input type="text" name="password" value="${vo.password}"><br>
				이름 : <input type="text" name="name" value="${vo.name}"><br>
				<input type="submit" value="수정">
			</form>
			<h2>비밀번호 변경</h2>
			<form action="/update" method="post">
			<!-- 클라이언트에서 hidden으로 보낼때 -->
			<!-- <input type="hidden" name="id" value="${vo.id}">
				 <input type="hidden" name="name" value="${vo.name}"> -->
			비밀번호 : <input type="text" name="password" value="${vo.password}"><br>
				<input type= "submit" value="비밀번호 수정">
			</form>
		</c:when>
		<c:otherwise>
			<ul>
				<li><a href="/register">회원가입</a></li>
				<li><a href="/login">로그인</a></li>
			</ul>
			<table border="1">
				<tr>
					<th>아이디</th>
					<th>비밀번호</th>
					<th>이름</th>
				</tr>
				<c:forEach items="${allMember}" var="member">
					<tr>
						<td>${member.id}</td>
						<td>${member.password}</td>
						<td>${member.name}</td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>