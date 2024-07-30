<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>로그인 페이지</title>
    <link rel="stylesheet" href="login.css" />
    <link rel="stylesheet" href="reset.css" />
    <link rel="stylesheet" href="loginActive.css" />
    <link rel="stylesheet" href="loginKeyFrames.css" />
  </head>
  <body>
    <div class="header">
      <div class="header_left">
        <div class="LOGO">LOGO</div>
        <div class="menu">menu1</div>
        <div class="menu">menu2</div>
        <div class="menu">menu3</div>
        <div class="menu">menu4</div>
        <div class="header_right">
          <div class="header_right_menu">회원가입</div>
          <div class="header_right_menu">로그인</div>
          <div class="header_right_menu">마이페이지</div>
        </div>
      </div>
    </div>
    <div class="container">
      <div class="login-box">
        <h1>로그인</h1>
        <form action="/login" method="post">
          <div class="textbox">
            <i class="fas fa-user"></i>
            <input type="text" placeholder="아이디" name="id" required />
          </div>
          <div class="textbox">
            <i class="fas fa-lock"></i>
            <input type="password" placeholder="비밀번호" name="password" />
          </div>
          <input type="submit" class="btn" value="로그인" />
        </form>
        <div class="login-boxs">
          <div class="google_box">GOOGLE</div>
          <div class="naver_box">NAVER</div>
          <div class="facebook_box">FACEBOOK</div>
        </div>
      </div>
    </div>
    <div></div>
    <script src="https://kit.fontawesome.com/a076d05399.js"></script>
    <script src="login.js"></script>
  </body>
</html>