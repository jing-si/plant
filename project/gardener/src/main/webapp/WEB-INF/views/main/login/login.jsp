<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700;800&family=Noto+Sans+KR:wght@400;700;900&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="/resources/css/login.css">
</head>
<body>
    <div id="align">
    		<a href="admin/"><p style="color:red; font-weight:bold; font-size:2em;">관리자 야호!</p></a>
            <a href="login/"><p style="font-size: 2em;">홈화면</p></a>
            <a href="splash/"><p style="font-size: 2em;">스플래시 확인</p></a>
            <a href="login/userforest/"><p style="font-size: 2em;">숲 확인</p></a>
            
    <div id="logo">
        <img src="/resources/images/login-logo.png">
      </div>
      <form method="post">
    <input id="email" placeholder="아이디" type="text" name="userId">
    <input id="passWord" placeholder="비밀번호" type="password" name="userPass">
    	<input type="submit" id="login" class="border" value="로그인"></input>
    </form>
    
    <div id="pwRe"><a href="pwupdate">비밀번호 재설정</a></div>
    <div id="membership"><a href="membership/">회원가입</a></div>
    </div>
</body>
</html>