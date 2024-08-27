<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<!-- 제이쿼리 사용중 -->
</head>
<body>
	<h2>Encoding 처리하기</h2>
	닉네임 : <input type= "text" id="nick">
	<input type="button" value="닉네임 보내기" id="btn" >
	<div id= "result"></div>
	
	<!-- 자바스크립트 방식 -->
	<!-- get 방식으로 /encoding <-- 닉네임 보내서 : 요청 
		해당 닉네임 받아서 result에 보여주기 ?사용
	-->
	<!-- <script> // 리액트에서는 사용 안함
		let xhr;
		function startRequest() {
			console.log(document.querySelector("#nick").value);
			// nickname 변수에 #nick 담기
			const nickname = (document.querySelector("#nick").value);
			xhr = new XMLHttpRequest();
			xhr.onreadystatechange = callback;
			// 컨트롤러에 nickname 전송
			xhr.open("get","/encoding?nickname=" + encodeURI(encodeURIComponent(nickname)));
			xhr.send(null);
		};
		function callback() {
			if (xhr.readyState === 4) {
				if (xhr.status === 200) {
					const result = xhr.responseText;
					// #result에 컨트롤러에서 받은 결과값 출력
					document.querySelector("#result").innerText = decodeURI(decodeURIComponent(result));
				}
			}
		}
	</script> -->
	
	<!-- jQuery -->
	<script>
		$("#btn").click(() => {
			const nickname = $("#nick").val();
			$.ajax({
				
				// 요청
				// Get or Post 타입
				type:"get",
				// 컨트롤러 uri
				url: "/encoding",
				// nickname 데이터 전송(인코딩)
				data: "nickname=" + encodeURIComponent(nickname),
				
				// 응답
				success: function(result) {
				// nickname 데이터 응답(디코딩)
					$("#result").text(result);
				},
				// 실패했을경우 
				// error: function() {}
					
				
				
				
				
			});
			
		});
	
	</script>
	
	
	
	
	
</body>
</html>