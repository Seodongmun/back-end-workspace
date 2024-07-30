<%@page import="com.kh.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 관리 기능</h1>
	<ul>
		<c:choose>
			<c:when test="${member == null}">
				<li><a href="/register">회원가입</a></li>
				<li><a href="/login">로그인</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="/search">회원검색</a></li>
				<li><a href="/allMember">전체회원보기</a></li>
				<!-- 전체회원보기 : views/allMember.jsp에 리스트 출력 -->
				<li><a href="/logout">로그아웃</a></li>
				<!-- 로그아웃 : 로그아웃 하고 index.jsp로 이동 -->
			</c:otherwise>
		</c:choose>
	</ul>
</body>
</html>
