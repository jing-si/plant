<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
<title>가꿈_회원가입</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700;800&family=Noto+Sans+KR:wght@400;700;900&display=swap" rel="stylesheet">
    <!-- <script src="/resources/js/test.js"></script> -->
    <script src="/resources/jq/jquery.js"></script>
    
    <link rel="stylesheet" href="/resources/css/membership.css">
    
    <!--date Picker-->
    <link href="/resources/dist/css/datepicker.min.css" rel="stylesheet" type="text/css" media="all">
    <script src="/resources/dist/js/datepicker.js"></script> 
    <script src="/resources/dist/js/datepicker.ko.js"></script> 
    
    <style>
    	#email input{width: 35%; display : inline-block;}
    	#email div{
	    	width: 18%;
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
    	
    	
    	.emailSelect{
    		height: 40px;
    		background-color: #f5f5f5;
    		border: 0px;
    		border-radius: 4px;
    	}
    		.scroll{
	    	overflow: auto;
	    	height: calc(100vh - 59.5px - 44px);
	    }
	    .info .sub{
	    	margin-bottom: 2px;
	    }
    	#checkMsg .red{
    		color:red;
    	}
    	#email .hide{
    		display: none;
    	}
    </style>
    
</head>
<body>

<script>
let checkId = false;
let checkPass = false;

$().ready(() =>{
	/* var emailValue = $("#email").children().first().val(); */
	
	//아이디 중복확인
	//아이디의 조건 : 한글불가, 숫자만 불가, 영어 대소문자 가능
	$('#duplication').click(function(){
	var email_rule =  /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	var emailValue = $("#emailValue").val();
	var emailSelect = $("#emailSelect").val();
	var email = emailValue + "@" + emailSelect;
	
	var koreanCheck =  RegExp(/^.*(?=^.$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/);
	var checkEnglish = emailValue.search(/[a-z]/ig);

	
	console.log("중복확인");
	console.log(email);
	
	
	if(emailValue == "" || emailSelect == "" || !email_rule.test(email)){
		console.log(emailValue)
		console.log(email_rule.test(email))
		alert("이메일을 형식에 맞게 입력해주세요");
		return false;
	}
	else if(checkEnglish < 0){
		console.log(emailValue)
		alert("이메일을 형식에 맞게 입력해주세요.")
	}
	else{
			$.ajax({
		url : "/membership/duplication",
		type : "post",
		data : {"id" : email},
		dataType : "text",
		success : function(data){
			console.log(data)
			if(data==="true"){
				alert("사용 가능한 이메일입니다.");				
				console.log("사용 가능한 이메일입니다.");
				checkId = true;
			}else{
				alert("이미 사용중인 이메일입니다.");
				console.log("이미 사용중인 이메일입니다.");
			}
		},  //success 끝
		error : function(){
			alert("아이디 중복 확인 ajax 실행 실패");
			console.log("실패");
			console.log(emailValue);
		}
	})  //ajax 끝
	}  //else 끝
	

})  //중복확인 끝
	
	//id변경시 중복체크 요구
	$(".changeId").on("change",function(){
		
		var emailValue = $("#emailValue").val();
		var emailSelect = $("#emailSelect").val();
		var email = emailValue + "@" + emailSelect;
		
		$("#userId").val(email)
		
		checkId = false;
	})
	
	
	
//비밀번호 확인
$('#pwcheck').keyup(function(){
	var password = $('#pw').val();
	var passwordCheck = $('#pwcheck').val();
	const password_rule = /(?=.*\d{1,50})(?=.*[~`!@#$%\^&*()-+=]{1,50})(?=.*[a-zA-Z]{2,50}).{8,50}$/;
	
	if(password.length < 8){
		$("#checkMsg").empty();
		$("#checkMsg").append($("<p class='red'>8자리 이상 필요</p>"))
		checkPass = false;
		return;
	}else{
		checkPass = true;
	}
	
	
	if(!password_rule.test(password)){
		$("#checkMsg").empty();
		$("#checkMsg").append($("<p class='red'>숫자와 영어, 특수문자 필요</p>"))
		checkPass = false;
		return;
	}else{
		checkPass = true;
	}
	
	
	if(password == passwordCheck){
		$("#checkMsg").empty();
		$("#checkMsg").append($("<p>비밀번호 일치</p>"))
	}
	else{
		$("#checkMsg").empty();
		$("#checkMsg").append($("<p class='red'>비밀번호 불일치</p>"))
	}
})  //비밀번호 확인 끝

//비밀번호 확인
$('#pw').keyup(function(){
	var password = $('#pw').val();
	var passwordCheck = $('#pwcheck').val();
	const password_rule = /(?=.*\d{1,50})(?=.*[~`!@#$%\^&*()-+=]{1,50})(?=.*[a-zA-Z]{2,50}).{8,50}$/;
	
	if(password.length < 8){
		$("#checkMsg").empty();
		$("#checkMsg").append($("<p class='red'>8자리 이상 필요</p>"))
		checkPass = false;
		return;
	}else{
		checkPass = true;
	}
	
	if(!password_rule.test(password)){
		$("#checkMsg").empty();
		$("#checkMsg").append($("<p class='red'>숫자와 영어, 특수문자 필요</p>"))
		checkPass = false;
		return;
	}else{
		checkPass = true;
	}
	
	
	if(password == passwordCheck){
		$("#checkMsg").empty();
		$("#checkMsg").append($("<p>비밀번호가 일치합니다.</p>"))
	}
	else{
		$("#checkMsg").empty();
		$("#checkMsg").append($("<p class='red'>비밀번호가 일치하지 않습니다.</p>"))
	}
})  //비밀번호 확인 끝
	
	//뒤로가기 버튼
	$(".historyBack").click(function(){
		window.history.back();
	})
	
	//날짜 형식 바꾸기
	$("#birthValue").datepicker({
		language: 'ko',
		maxDate:new Date(),
		autoClose:true
	});
	
	
	
})  //ready 끝


//submit하기전 검사
function check(){
	

	
	//아이디 공백 확인 
    if ($("#emailValue").val() == "") {
        alert("이메일을 입력하세요");
        $("#emailValue").focus(); 
        return false;
    }
	
	
	//아이디 중복확인
	if(!($("#emailValue").val() == "")){
		if(!checkId){
			alert("아이디 중복체크가 필요합니다.")
			return false;
		}
		
	}
	
	
	//닉네임 공백 검사 
	if ($("#nickValue").val() == "") {
        alert("닉네임을 입력하세요");
        $("#nickValue").focus();
        return false;
    }
	
	 //비밀번호 8자 이상 확인
	if(!checkPass){
		alert("비밀번호를 확인해주세요.")
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
    
  
    /* if(!password_rule.test($("#pw").val())){
    	alert("비밀번호는 8자 이상이어야 합니다");
    	$("#pw").val("");
    	$("#pwcheck").val("");
    	$("#pw").focus();
    	return false;
    } */

    
    //생일 공백 확인 
    if ($("#birthValue").val() === "") {
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
<div id="align" class="scroll">
    <div id="email" class="info">
    <input placeholder="이메일" type="text" name="userId" id="userId" maxlength="18" class="userId hide">
        <input placeholder="이메일" type="text" id="emailValue" maxlength="18" class="changeId">
        <p>@</p>
        <select class="select emailSelect changeId" title="이메일 도메인 주소 선택" id="emailSelect">
            <option value="">-선택-</option>
		    <option value="naver.com">naver.com</option>
		    <option value="gmail.com">gmail.com</option>
		    <option value="hanmail.net">hanmail.net</option>
		    <option value="hotmail.com">hotmail.com</option>
		    <option value="korea.com">korea.com</option>
		    <option value="nate.com">nate.com</option>
		    <option value="yahoo.com">yahoo.com</option>
		</select>
        <div value="duplication" id="duplication">중복확인</div>
        <p class="sub title">이메일은 영문, 영문+숫자 조합만 가능합니다</p>
        <!-- <p id="certification">계정이 인증되었습니다.</p> -->
    </div>
    <div id="nickName" class="info">
        <input placeholder="닉네임" type="text" name="userNick" id="nickValue" maxlength="10">
            <!-- <p>example@gmail.com</p> -->
    </div>
    <div id="birth" class="info">
        <input placeholder="비밀번호" type="password" name="userPass" id="pw" >
		 <p class="sub title">비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요</p>
            <!-- <p id="explain">생년월일(8자리)</p> -->
    </div>
    
    <div id="birth" class="info">
        <input placeholder="비밀번호 확인" type="password" id="pwcheck" >
            <!-- <p id="explain">생년월일(8자리)</p> -->
            <div id="checkMsg"></div>
    </div>
    <div id="birth" class="info">
        <p class="title">생년월일</p>
        <input placeholder="생년월일(8자리)" type="text" readonly maxlength="8" name="userBirth" id="birthValue">
            <!-- <p id="explain">생년월일(8자리)</p> -->
    </div>
    <!-- <div id="gender" class="info">
        <p class="title">성별</p>
        <div id="female"><p>여성</p>
        </div><div id="male"><p>남성</p></div>
    </div> -->
    <div id="gender" class="info" class="tab_menu">
        
        <p class="title">성별</p>
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
            <div><p class="terms" id="terms_1">개인정보 수집 및 이용약관 동의(필수)<a href="agreement/"><p class="fullText" id="fullText_1">전문보기</p></a></div>
        </div>
    </div>
</div>
    <input id="submit" value="동의하고 완료" type="submit">
     <!--    <p>동의하고 완료</p> -->
</form>

</body>
</html>
