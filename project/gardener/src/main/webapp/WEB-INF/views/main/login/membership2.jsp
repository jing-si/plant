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
    <!-- <script src="/resources/js/test.js"></script> -->
    <script src="/resources/jq/jquery.js"></script>
    
    <link rel="stylesheet" href="/resources/css/membership.css">
    
    <style>
    	#email input{width: 80%;}
    	#email div{
	    	width: 15%;
	    	height: 40px;
	    	vertical-align: top;
	    	border: 0px;
	    	background-color: #66bb6a;
	    	border-radius: 4px;
	    	color: white;
	    	margin-left: 3%;
	    	font-size: 10px;
	    	display: inline-block;
	    	text-align: center;
	    	padding-top: 10px;
    	}
    	
    	#checkMsg{
    		background-color: transparent;
			height: 30px;
    	}
    	#checkMsg p{
    		color: #66bb6a;
    	}
    </style>
    
</head>
<body>

<script>


$().ready(() =>{
	/* var emailValue = $("#email").children().first().val(); */
	
	//아이디 중복확인
	$('#duplication').click(function(){
	var emailValue = $("#emailValue").val();
	console.log("중복확인");
	console.log(emailValue);
	$.ajax({
		url : "/membership/duplication",
		type : "post",
		data : {"id" : emailValue},
		dataType : "text",
		success : function(data){
			console.log(data)
			if(data==="true"){
				alert("이 아이디는 사용 가능합니다.");
				console.log("이 아이디는 사용가능합니다");
			}else{
				alert("이 아이디는 사용 불가능합니다");
				console.log("이 아이디는 사용불가능합니다");
			}
		},  //success 끝
		error : function(){
			alert("아이디 중복 확인 ajax 실행 실패");
			console.log("실패");
			console.log(emailValue);
		}
	})  //ajax 끝
})  //중복확인 끝
	
	
	
	
	//비밀번호 확인
	$('#pwcheck').change(function(){
		var password = $('#pw').val();
		var passwordCheck = $('#pwcheck').val();
		
		if(password == passwordCheck){
			$("#checkMsg").empty();
			$("#checkMsg").append($("<p>비밀번호 일치</p>"))
		}
		else{
			$("#checkMsg").empty();
			$("#checkMsg").append($("<p>비밀번호 불일치</p>"))
		}
	})  //비밀번호 확인
	
	//뒤로가기 버튼
	$(".historyBack").click(function(){
		window.history.back();
	})
	
	
	
})  //ready 끝


//submit하기전 검사
function check(){
	
	//아이디 공백 확인 
    if ($("#emailValue").val() == "") {
        alert("아이디를 입력하세요");
        $("#emailValue").focus(); 
        return false;
    }
	
	
	//아이디 중복확인
	if(!($("#emailValue").val() == "")){
		var emailValue = $("#emailValue").val();
		console.log("중복확인");
		console.log(emailValue);
		$.ajax({
			url : "/membership/duplication",
			type : "post",
			data : {"id" : emailValue},
			dataType : "text",
			success : function(data){
				console.log(data)
				if(data!=="true"){
					alert("이 아이디는 사용 불가능합니다");
					console.log("이 아이디는 사용불가능합니다");
					return false;
				}
			},  //success 끝
			error : function(){
				alert("아이디 중복 확인 ajax 실행 실패");
				console.log("실패");
				console.log(emailValue);
			}
		})  //ajax 끝
	}
	
	
	//닉네임 공백 검사 
    if ($("#nickValue").val() == "") {
        alert("닉네임을 입력하세요");
        $("#nickValue").focus();
        return false;
    }
	
	
    //비밀번호 공백 확인 
    if ($("#pw").val() == "") {
        alert("비밀번호를 입력하세요");
        $("#pw").focus();
        return false;
    }
    
    
    //비밀번호 확인란 공백 확인 
    if ($("#pwcheck").val() == "") {
        alert("비밀번호 확인을 입력하세요");
        $("#pwcheck").focus();
        return false;
    }
    
    
    //비밀번호 서로확인 
    if ($("#pw").val() != $("#pwcheck").val()) {
        alert("비밀번호가 상이합니다");
        $("pw").val("");
        $("#pwcheck").val("");
        $("#pw").focus();
        return false;
    }

    
    //생일 공백 확인 
    if ($("#birthValue").val() == "") {
        alert("생년월일을 입력하세요");
        $("birthValue").focus();
        return false;
    }
    
    
    //성별 공백 확인 
    if ($("#select").is(':checked') == false && $("#select2").is(':checked') == false) {
    	alert("성별을 선택하세요");
        return false;
    }

    
}  //submit 검사 끝

</script>



    <div id="header">
    	<svg class="historyBack" xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 0 24 24" width="24px" fill="#000000"><path d="M0 0h24v24H0V0z" fill="none"/><path d="M19 6.41L17.59 5 12 10.59 6.41 5 5 6.41 10.59 12 5 17.59 6.41 19 12 13.41 17.59 19 19 17.59 13.41 12 19 6.41z"/></svg>
        <p>회원가입</p>
    </div>



<form method="post" onsubmit="return check();">
<div id="align">
    <div id="email" class="info">
        <input placeholder="이메일" type="text" name="userId" id="emailValue"><!-- <p></p> --></input>
        <div value="duplication" id="duplication">중복확인</div>
        <!-- <p id="certification">계정이 인증되었습니다.</p> -->
    </div>
    <div id="nickName" class="info">
        <input placeholder="닉네임" type="text" name="userNick" id="nickValue">
            <!-- <p>example@gmail.com</p> -->
    </div>
    <div id="birth" class="info">
        <input placeholder="비밀번호(4자리)" type="password" maxlength="4" name="userPass" id="pw">
            <!-- <p id="explain">생년월일(8자리)</p> -->
    </div>
    <div id="birth" class="info">
        <input placeholder="비밀번호 확인" type="password" maxlength="4" id="pwcheck">
            <!-- <p id="explain">생년월일(8자리)</p> -->
            <div id="checkMsg"></div>
    </div>
    <div id="birth" class="info">
        <input placeholder="생년월일(8자리)" type="date" maxlength="8" name="userBirth" id="birthValue">
            <!-- <p id="explain">생년월일(8자리)</p> -->
    </div>
    <!-- <div id="gender" class="info">
        <p class="title">성별</p>
        <div id="female"><p>여성</p>
        </div><div id="male"><p>남성</p></div>
    </div> -->
    <div id="gender" class="info" class="tab_menu">
        
        <div class="select">
            <input type="radio" id="select" name="userGender" value="여"><label for="select">여성
            </label><input type="radio" id="select2" name="userGender" value="남"><label for="select2">남성</label>
       </div>
        
        
<!--         <ul class="list">
            <li class="is_on">
                <div id="female" class="btn"><p>여성</p></div>
            </li><li><div id="male" class="btn"><p>남성</p></div></li>
        </ul> -->
    </div>

    <div id="agreement" class="info">
        <p class="title">약관동의</p>
        <div id="agreeBox">
            <div><p class="terms" id="terms_1">이용약관 동의(필수)<a href="agreement/"><p class="fullText" id="fullText_1">전문보기</p></a></div>
            <div><p class="terms" id="terms_2">개인정보 수집 및 이용 동의(필수)<a href="agreement/"><p class="fullText" id="fullText_2">전문보기</p></a></div>
        </div>
    </div>
</div>
    <input id="submit" value="동의하고 완료" type="submit">
     <!--    <p>동의하고 완료</p> -->
</form>

</body>
</html>
