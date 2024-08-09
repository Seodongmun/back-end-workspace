<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 부트 스트랩 링크 (https://getbootstrap.com/docs/5.3/getting-started/download/)-->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" />
<!-- 부트 스트랩 링크 -->
</head>
<body>
  <!-- Default container ( https://getbootstrap.com/docs/5.3/layout/containers/ -->
	<div class="container">
	<!-- .container-fluid 는 여백 없이 꽉참 -->
	<!-- 로그인 (https://getbootstrap.com/docs/5.3/forms/overview/) -->
	<h1>로그인</h1>
		<form action="/login" method="post" onsubmit="return validate()" > <!-- 자바스크립트 -->
		<!-- 클래스는 건들면 안됨 -->
			<div class="mb-3">
				<label for="id" class="form-label">아이디
				</label> <input type="text" class="form-control" id="id" >
				<div id="idCheck" class="form-text">아이디를 입력하세요</div>
			</div>
			<div class="mb-3">
				<label for="password" class="form-label">비밀번호</label>
				<input type="password" class="form-control" id="password">
				<div id="pwdCheck" class="form-text">비밀번호를 입력하세요</div>
			</div>
			<button type="submit" class="btn btn-dark">로그인</button>
		</form>
	</div>
	<script src="${pageContext.request.contextPath}/js/login.js"></script>
</body>
</html>














