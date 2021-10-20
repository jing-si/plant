<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
<title>Insert title here</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700;800&family=Noto+Sans+KR:wght@400;700;900&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="/resources/css/login.css">
    <script src="/resources/jq/jquery.js"></script>
</head>
<body>
<script>
//submit하기전 검사
function check(){
	
	//아이디 공백 확인 
    if ($("#email").val() == "") {
        alert("아이디를 입력하세요");
        $("#email").focus(); 
        return false;
    }
	
	//비밀번호 공백 확인 
    if ($("#passWord").val() == "") {
        alert("비밀번호를 입력하세요");
        $("#passWord").focus(); 
        return false;
    }
}
</script>



    <div id="align">
    		<a href="admin/"><p style="color:red; font-weight:bold; font-size:2em;">관리자 야호!</p></a>
            <a href="login/"><p style="font-size: 2em;">홈화면</p></a>
            <a href="splash/"><p style="font-size: 2em;">스플래시 확인</p></a>
            <a href="login/userforest/"><p style="font-size: 2em;">숲 확인</p></a>
            <a href="login/camera/"><p style="font-size: 2em;">카메라</p></a>
            
    <div id="logo">
        <img src="/resources/images/login-logo.png">
      </div>
      <form method="post" onsubmit="return check();">
    <input id="email" placeholder="아이디" type="text" name="userId">
    <input id="passWord" placeholder="비밀번호" type="password" name="userPass">
    	<input type="submit" id="login" class="border" value="로그인"></input>
    </form>
    
    <div id="pwRe"><a href="pwupdate">비밀번호 재설정</a></div>
    <div id="membership"><a href="membership/">회원가입</a></div>
    </div>
</body>
</html>