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
	    	height: calc(100vh - 59.5px - 44px - 20px);
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
    	
    	
 .modal_title{
    width : 80%;
    margin: 0 auto;
    text-align: center;
    font-family: NotoSansKR;
    font-size: 14px;
    color: #666;
    padding: 17px;
}
.check{
    font-family: NotoSansKR;
    font-size: 14px;
    text-align: center;
    color: #1377e7;
    width: 50%;
    display: inline-block;
    padding-top: 10px;
}
.cancel{
     font-family: NotoSansKR; 
     font-size: 14px; 
     text-align: center; 
     color: #66bb6a;
   /*  width: 50%; */
    display: inline-block;
    padding-top: 10px;
    cursor:pointer;
    position: absolute;
    top: 5px;
    right: 10px;
}



#popup01{
    display: none;
}
#popup02{
    display: none;
}
#popup01{
width: 90%;
height: 90%;
position: absolute;
top: 50%;
left: 50%;
transform: translate(-50%, -50%);
background-color: #fff;
z-index: 2;
border-radius: 10px;
    }
    #popup02{
width: 90%;
height: 106px;
position: absolute;
top: 80%;
left: 50%;
transform: translate(-50%, -50%);
background-color: #fff;
z-index: 2;
    }
.backon{
    content: "";
    width: 100%;
    height: 100%;
    background: #00000054;
    position: fixed;
    top: 0;
    left: 0;
    z-index: 1;
}
.close{
  position:absolute;
  top:-25px;
  right: 0;
  cursor:pointer;
}
.openPopup{
  cursor:pointer;
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
        alert("비밀번호가 일치하지않습니다.");
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
            <!-- <div><p class="terms" id="terms_1">개인정보 수집 및 이용약관 동의(필수)<a href="agreement/"><p class="fullText" id="fullText_1">전문보기</p></a></div> -->
        	<div><p class="terms" id="terms_1">개인정보 수집 및 이용약관 동의(필수)<p class="fullText" id="fullText_1">전문보기</p></div>
        </div>
    </div>
</div>
    <input id="submit" value="동의하고 완료" type="submit">
     <!--    <p>동의하고 완료</p> -->
</form>

	<div id="popup01">
    	
    	<div>
        	<div class="modal_title">개인정보 수집 및 이용약관 동의</div>
        	<div class="cancel">
        	닫기
<!--         		<svg xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 0 24 24" width="24px" fill="#000000"><path d="M0 0h24v24H0V0z" fill="none"/><path d="M19 6.41L17.59 5 12 10.59 6.41 5 5 6.41 10.59 12 5 17.59 6.41 19 12 13.41 17.59 19 19 17.59 13.41 12 19 6.41z"/></svg>
 -->			</div>
			
			</div>
<div class="scroll">
        <div id="align">
            	<p> <p class="ls2 lh6 bs5 ts4"><em class="emphasis">< 정원사 >('gakkum.info'이하 '가꿈')</em>은(는) 「개인정보 보호법」 제30조에 따라 정보주체의 개인정보를 보호하고 이와 관련한 고충을 신속하고 원활하게 처리할 수 있도록 하기 위하여 다음과 같이 개인정보 처리방침을 수립·공개합니다.</p><p class="ls2">○ 이 개인정보처리방침은 <em class="emphasis">2021</em>년 <em class="emphasis">10</em>월 <em class="emphasis">17</em>부터 적용됩니다.</p></br><p class='lh6 bs4'><strong>제1조(개인정보의 처리 목적)<br/><br/><em class="emphasis">< 정원사 >('gakkum.info'이하  '가꿈')</em>은(는) 다음의 목적을 위하여 개인정보를 처리합니다. 처리하고 있는 개인정보는 다음의 목적 이외의 용도로는 이용되지 않으며 이용 목적이 변경되는 경우에는 「개인정보 보호법」 제18조에 따라 별도의 동의를 받는 등 필요한 조치를 이행할 예정입니다.</strong></p><ul class="list_indent2 mgt10"><p class="ls2">1. 홈페이지 회원가입 및 관리</p><p class="ls2">회원 가입의사 확인, 회원제 서비스 제공에 따른 본인 식별·인증, 회원자격 유지·관리 목적으로 개인정보를 처리합니다.</p></br><p class="ls2">2. 재화 또는 서비스 제공</p><p class="ls2">서비스 제공, 콘텐츠 제공을 목적으로 개인정보를 처리합니다.</p></br><p class="ls2">3. 마케팅 및 광고에의 활용</p><p class="ls2">신규 서비스(제품) 개발 및 맞춤 서비스 제공, 인구통계학적 특성에 따른 서비스 제공 및 광고 게재  등을 목적으로 개인정보를 처리합니다.</p></br></ul></br></br><p class='lh6 bs4'><strong>제2조(개인정보의 처리 및 보유 기간)</strong></br></br>① <em class="emphasis">< 정원사 ></em>은(는) 법령에 따른 개인정보 보유·이용기간 또는 정보주체로부터 개인정보를 수집 시에 동의받은 개인정보 보유·이용기간 내에서 개인정보를 처리·보유합니다.</br></br>② 각각의 개인정보 처리 및 보유 기간은 다음과 같습니다.</p></br></br><p class='lh6 bs4'><strong>제3조(개인정보의 제3자 제공)</strong></br></br> ① <em class="emphasis">< 정원사 >은(는) 개인정보를 제1조(개인정보의 처리 목적)에서 명시한 범위 내에서만 처리하며, 정보주체의 동의, 법률의 특별한 규정 등 「개인정보 보호법」 제17조 및 제18조에 해당하는 경우에만 개인정보를 제3자에게 제공합니다.</p><p class="sub_p mgt10">②  <span class="colorLightBlue">< 정원사 ></span>은(는) 다음과 같이 개인정보를 제3자에게 제공하고 있습니다.</p><ul class="list_indent2 mgt10"><li class="tt">1. <  ></li><li>개인정보를 제공받는 자 : </li><li>제공받는 자의 개인정보 이용목적 : </li><li>제공받는 자의 보유.이용기간: </li></ul></br></br><p class='lh6 bs4'><strong>제4조(개인정보처리 위탁)</strong></br></br> ① <em class="emphasis">< 정원사 ></em>은(는) 원활한 개인정보 업무처리를 위하여 다음과 같이 개인정보 처리업무를 위탁하고 있습니다.</p><ul class='list_indent2 mgt10'><li class='tt'>1. <  ></li><li>위탁받는 자 (수탁자) : </li><li>위탁하는 업무의 내용 : </li><li>위탁기간 : </li></ul><p class='sub_p mgt10'>②  <span class='colorLightBlue'>< 정원사 ></span>은(는) 위탁계약 체결시 「개인정보 보호법」 제26조에 따라 위탁업무 수행목적 외 개인정보 처리금지, 기술적․관리적 보호조치, 재위탁 제한, 수탁자에 대한 관리․감독, 손해배상 등 책임에 관한 사항을 계약서 등 문서에 명시하고, 수탁자가 개인정보를 안전하게 처리하는지를 감독하고 있습니다.</p><p class='sub_p mgt10'>③ 위탁업무의 내용이나 수탁자가 변경될 경우에는 지체없이 본 개인정보 처리방침을 통하여 공개하도록 하겠습니다.</p><br/><br/><p class="lh6 bs4"><strong>제5조(정보주체와 법정대리인의 권리·의무 및 그 행사방법)</strong></p><p class="ls2"><br/><br/>① 정보주체는 정원사에 대해 언제든지 개인정보 열람·정정·삭제·처리정지 요구 등의 권리를 행사할 수 있습니다.</p><p class='sub_p'>② 제1항에 따른 권리 행사는정원사에 대해 「개인정보 보호법」 시행령 제41조제1항에 따라 서면, 전자우편, 모사전송(FAX) 등을 통하여 하실 수 있으며 정원사은(는) 이에 대해 지체 없이 조치하겠습니다.</p><p class='sub_p'>③ 제1항에 따른 권리 행사는 정보주체의 법정대리인이나 위임을 받은 자 등 대리인을 통하여 하실 수 있습니다.이 경우 “개인정보 처리 방법에 관한 고시(제2020-7호)” 별지 제11호 서식에 따른 위임장을 제출하셔야 합니다.</p><p class='sub_p'>④ 개인정보 열람 및 처리정지 요구는  「개인정보 보호법」  제35조 제4항, 제37조 제2항에 의하여 정보주체의 권리가 제한 될 수 있습니다.</p><p class='sub_p'>⑤ 개인정보의 정정 및 삭제 요구는 다른 법령에서 그 개인정보가 수집 대상으로 명시되어 있는 경우에는 그 삭제를 요구할 수 없습니다.</p><p class='sub_p'>⑥ 정원사은(는) 정보주체 권리에 따른 열람의 요구, 정정·삭제의 요구, 처리정지의 요구 시 열람 등 요구를 한 자가 본인이거나 정당한 대리인인지를 확인합니다.</p></br></br><p class='lh6 bs4'><strong>제6조(처리하는 개인정보의 항목 작성) </strong></br></br> ① <em class="emphasis">< 정원사 ></em>은(는) 다음의 개인정보 항목을 처리하고 있습니다.</p><ul class='list_indent2 mgt10'><li class='tt'>1< 홈페이지 회원가입 및 관리 ></li><li>필수항목 : 이메일, 비밀번호, 로그인ID, 성별, 생년월일</li><li>선택항목 : </li></ul></br></br><p class='lh6 bs4'><strong>제7조(개인정보의 파기)<em class="emphasis"></strong></p><p class='ls2'></br>① < 정원사 > 은(는) 개인정보 보유기간의 경과, 처리목적 달성 등 개인정보가 불필요하게 되었을 때에는 지체없이 해당 개인정보를 파기합니다.</br></br>② 정보주체로부터 동의받은 개인정보 보유기간이 경과하거나 처리목적이 달성되었음에도 불구하고 다른 법령에 따라 개인정보를 계속 보존하여야 하는 경우에는, 해당 개인정보를 별도의 데이터베이스(DB)로 옮기거나 보관장소를 달리하여 보존합니다.</br>1. 법령 근거 :</br>2. 보존하는 개인정보 항목 : 계좌정보, 거래날짜</br></br>③ 개인정보 파기의 절차 및 방법은 다음과 같습니다.</br>1. 파기절차</br> < 정원사 > 은(는) 파기 사유가 발생한 개인정보를 선정하고, < 정원사 > 의 개인정보 보호책임자의 승인을 받아 개인정보를 파기합니다.</br></p><p class='sub_p mgt10'>2. 파기방법</p><p class='sub_p'>전자적 파일 형태의 정보는 기록을 재생할 수 없는 기술적 방법을 사용합니다</p></br></br><p class='lh6 bs4'><strong>제8조(개인정보의 안전성 확보 조치)<em class="emphasis"></br></br>< 정원사 ></em>은(는) 개인정보의 안전성 확보를 위해 다음과 같은 조치를 취하고 있습니다.</strong></p><p class='sub_p mgt10'>1. 개인정보 취급 직원의 최소화 및 교육</br> 개인정보를 취급하는 직원을 지정하고 담당자에 한정시켜 최소화 하여 개인정보를 관리하는 대책을 시행하고 있습니다.</br></br>2. 개인정보의 암호화</br> 이용자의 개인정보는 비밀번호는 암호화 되어 저장 및 관리되고 있어, 본인만이 알 수 있으며 중요한 데이터는 파일 및 전송 데이터를 암호화 하거나 파일 잠금 기능을 사용하는 등의 별도 보안기능을 사용하고 있습니다.</br></br></p></br></br><p class="lh6 bs4"><strong>제9조(개인정보 자동 수집 장치의 설치•운영 및 거부에 관한 사항)</strong></p><p class="ls2"><br/><br/>① 정원사 은(는) 이용자에게 개별적인 맞춤서비스를 제공하기 위해 이용정보를 저장하고 수시로 불러오는 ‘쿠키(cookie)’를 사용합니다.</br>② 쿠키는 웹사이트를 운영하는데 이용되는 서버(http)가 이용자의 컴퓨터 브라우저에게 보내는 소량의 정보이며 이용자들의 PC 컴퓨터내의 하드디스크에 저장되기도 합니다.</br>가. 쿠키의 사용 목적 : 이용자가 방문한 각 서비스와 웹 사이트들에 대한 방문 및 이용형태, 인기 검색어, 보안접속 여부, 등을 파악하여 이용자에게 최적화된 정보 제공을 위해 사용됩니다.</br>나. 쿠키의 설치•운영 및 거부 : 웹브라우저 상단의 도구>인터넷 옵션>개인정보 메뉴의 옵션 설정을 통해 쿠키 저장을 거부 할 수 있습니다.</br>다. 쿠키 저장을 거부할 경우 맞춤형 서비스 이용에 어려움이 발생할 수 있습니다.<p class='sub_p mgt30'><strong>제10조 (개인정보 보호책임자) </strong></p><p class='sub_p mgt10'> ①  <span class='colorLightBlue'>정원사</span> 은(는) 개인정보 처리에 관한 업무를 총괄해서 책임지고, 개인정보 처리와 관련한 정보주체의 불만처리 및 피해구제 등을 위하여 아래와 같이 개인정보 보호책임자를 지정하고 있습니다.</p><ul class='list_indent2 mgt10'><li class='tt'>▶ 개인정보 보호책임자 </li><li>성명 :</li><li>직책 :</li><li>직급 :</li><li>연락처 :010</li></ul><p class='sub_p'>※ 개인정보 보호 담당부서로 연결됩니다.<p/> <ul class='list_indent2 mgt10'><li class='tt'>▶ 개인정보 보호 담당부서</li><li>부서명 :</li><li>담당자 :</li><li>연락처 :, , </li></ul><p class='sub_p'>② 정보주체께서는 정원사 의 서비스(또는 사업)을 이용하시면서 발생한 모든 개인정보 보호 관련 문의, 불만처리, 피해구제 등에 관한 사항을 개인정보 보호책임자 및 담당부서로 문의하실 수 있습니다. 정원사 은(는) 정보주체의 문의에 대해 지체 없이 답변 및 처리해드릴 것입니다.</p><p class='sub_p mgt30'><strong>제11조(개인정보 열람청구)</br> 정보주체는 ｢개인정보 보호법｣ 제35조에 따른 개인정보의 열람 청구를 아래의 부서에 할 수 있습니다.<br/>< 정원사 ></span>은(는) 정보주체의 개인정보 열람청구가 신속하게 처리되도록 노력하겠습니다. </strong></p><ul class='list_indent2 mgt10'><li class='tt'>▶ 개인정보 열람청구 접수·처리 부서 </li><li>부서명 : </li><li>담당자 : </li><li>연락처 : , , </li></ul></br></br><p class='lh6 bs4'><strong>제12조(권익침해 구제방법)<em class="emphasis"></em></strong></p><br/><br/>정보주체는 개인정보침해로 인한 구제를 받기 위하여 개인정보분쟁조정위원회, 한국인터넷진흥원 개인정보침해신고센터 등에 분쟁해결이나 상담 등을 신청할 수 있습니다. 이 밖에 기타 개인정보침해의 신고, 상담에 대하여는 아래의 기관에 문의하시기 바랍니다.<br/><br/>



  1. 개인정보분쟁조정위원회 : (국번없이) 1833-6972 (www.kopico.go.kr)<br/>

  2. 개인정보침해신고센터 : (국번없이) 118 (privacy.kisa.or.kr)<br/>

  3. 대검찰청 : (국번없이) 1301 (www.spo.go.kr)<br/>

  4. 경찰청 : (국번없이) 182 (ecrm.cyber.go.kr)<br/><br/>



「개인정보보호법」제35조(개인정보의 열람), 제36조(개인정보의 정정·삭제), 제37조(개인정보의 처리정지 등)의 규정에 의한 요구에 대 하여 공공기관의 장이 행한 처분 또는 부작위로 인하여 권리 또는 이익의 침해를 받은 자는 행정심판법이 정하는 바에 따라 행정심판을 청구할 수 있습니다.<br/><br/>



※ 행정심판에 대해 자세한 사항은 중앙행정심판위원회(www.simpan.go.kr) 홈페이지를 참고하시기 바랍니다.</br></br><p class='lh6 bs4'><strong>제13조(개인정보 처리방침 변경)<em class="emphasis"></em></strong></p><br/></p><p class='sub_p'>① 이 개인정보처리방침은 2021년 10월 17부터 적용됩니다.</p><p class='sub_p'></p><p class='sub_p'></p>

        </div>
</div>
			
    	</div>
	</div>


<script>
$(document).ready(function( $ ){     
    $(".fullText").on("click", function(event) { 
    $("#popup01").show();  
    $("body").append('<div class="backon"></div>');
    });
    
    $("body").on("click", function(event) { 
        if(event.target.className == 'cancel' || event.target.className == 'backon'){
            $("#popup01").hide();
      	  $(".backon").hide();
        }  
      });

  }); 
</script>
</body>
</html>
