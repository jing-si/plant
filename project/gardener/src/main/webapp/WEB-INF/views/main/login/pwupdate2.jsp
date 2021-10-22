<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가꿈_비밀번호 재설정</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700;800&family=Noto+Sans+KR:wght@400;700;900&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="/resources/css/pwupdate.css">
    <script src="/resources/js/jquery.min.js"></script>
</head>
<body>

	<script>
	$(document).ready(function(){
		
		//뒤로가기 버튼
		$(".historyBack").click(function(){
			window.history.back();
		})
		
	})	//ready끝
	</script>



        <div id="header">
        	<svg class="historyBack" xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 0 24 24" width="24px" fill="#000000"><path d="M0 0h24v24H0V0z" fill="none"/><path d="M19 6.41L17.59 5 12 10.59 6.41 5 5 6.41 10.59 12 5 17.59 6.41 19 12 13.41 17.59 19 19 17.59 13.41 12 19 6.41z"/></svg>
            <p>비밀번호 재설정</p>
        </div>
    <div id="align">
    <form method="post">
        <div id="email" class="info">
            <p class="title">이메일 주소와 생년월일을 입력 후 비밀번호 재설정이 가능합니다.</p>
            <input placeholder="아이디" type="text" name="userId">
            <!-- <p id="send">전송</p> -->
        </div>
        <div id="nickName" class="info">
            <input placeholder="생년월일" type="date" name="certification">
        </div>

    
    </div>
        <input id="submit" value="확인" type="submit">
         <!--    <p>동의하고 완료</p> -->
    </form>
    
    </body>
</html>