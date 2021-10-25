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
    
    
        <style>
    	#email input{width: 100%;}
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
    	
    	.hide{
    		display: none;
    	}
    	
    	            #submit{
            width: 100%;
            height: 44px;
            background-color: #66bb6a;
            position: relative;
            border: 0px;
            color: white;
        }
        #submit p{
            position: absolute;
            left: 50%;
            transform: translate(-50%);
            top: 27%;
            font-size: 13px;
            color: #fff;
            font-weight: bold;
            /* margin: auto 0; */
            /* margin-top: 6.3px; */
        }
                #align{
            width: 328px;
            /* height: calc(100vh - 44px - 40.5px - 31.5px); */
            height: calc(100vh - 44px - 31.5px - 24px - 22px);
            margin: 0 auto;
            position: relative;
        }
    </style>
</head>
<body>

	<script>
	$(document).ready(function(){
		
		//뒤로가기 버튼
		$(".historyBack").click(function(){
			window.history.back();
		})
		
	//비밀번호 확인
	$('#pwcheck').keyup(function(){
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
	})  //비밀번호 확인 끝
	
	//비밀번호 확인
	$('#pw').keyup(function(){
		var password = $('#pw').val();
		var passwordCheck = $('#pwcheck').val();
		
		if(password == passwordCheck){
			$("#checkMsg").empty();
			$("#checkMsg").append($("<p>비밀번호가 일치합니다.</p>"))
		}
		else{
			$("#checkMsg").empty();
			$("#checkMsg").append($("<p>비밀번호가 일치하지 않습니다.</p>"))
		}
	})  //비밀번호 확인 끝

	})	//ready끝
	
	
	
//submit하기전 검사
function check(){
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
}  //submit 검사 끝
	</script>



        <div id="header">
        	<a href="../">
        	<svg class="historyBack" xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 0 24 24" width="24px" fill="#000000"><path d="M0 0h24v24H0V0z" fill="none"/><path d="M19 6.41L17.59 5 12 10.59 6.41 5 5 6.41 10.59 12 5 17.59 6.41 19 12 13.41 17.59 19 19 17.59 13.41 12 19 6.41z"/></svg>
        	</a>
            <p>비밀번호 재설정</p>
        </div>
        
     <form method="post" action="/pwdate2">   
    <div id="align">
    
   
    <input type="text" class="hide" value="${userId}" name="userId">
    <input type="text" class="hide" value="${userBirth}" name="userBirth">
    <div id="email" class="info">
    	<p class="title">새로운 비밀번호를 입력하세요</p>
        <input placeholder="비밀번호(4자리)" type="password" maxlength="4" name="userPass" id="pw">
            <!-- <p id="explain">생년월일(8자리)</p> -->
    </div>
    <div id="birth" class="info">
        <input placeholder="비밀번호 확인" type="password" maxlength="4" id="pwcheck">
            <!-- <p id="explain">생년월일(8자리)</p> -->
            <div id="checkMsg"></div>

    
    </div>

    </div>
            <input id="submit" value="확인" type="submit">
         <!--    <p>동의하고 완료</p> -->
    
    </form>
    
    </body>
</html>