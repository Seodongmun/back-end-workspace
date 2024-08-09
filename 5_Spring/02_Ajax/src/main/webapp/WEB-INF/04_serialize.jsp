<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>

	<h1>회원가입</h1>
	<form id="frm">
		아이디 : <input type= "text" name ="id" id="id"/><br>
		비밀번호 : <input type="password" name="password" id="password"/> <br>
		이름 : <input type="text" name ="name" id="name"/><br>
		<input type="button" value="가입" id= "btn"/>
	</form>
	
	<div id="result"></div>
	
	<script>
	
	/* $("#btn").click(() => {
		alert();
	}) */
		$("#btn").click(() => {
			$.ajax({
				// post 방식으로
				type: "post",
				// /serial
				url: "/serial",
				// id,password,name 값 넘겨서 회원가입 하고
				/* {
					키 : 값
					키 : 값
					...
				} */
				// post 방식은 인코딩 필요없음
				data: $("#frm").serialize(),
				
					/*{
						id : $('#id').val(),
						password : $('#password').val(),
						name : $('#name').val()
					   },*/
				// 돌아와서 result에 정보 기재
				success: function (result) {
					console.log(result);
					alert("회원가입 완료!");
					$("#result").html(result.name + "님이 회원가입 하셨습니다.")
				},
				error: function() {
					alert("회원가입 실패!")
				}
			});
		}); 
	</script>
</body>
</html>






