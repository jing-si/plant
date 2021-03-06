<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
<title>가꿈</title>
    <!-- <link rel="stylesheet" href="/resources/css/home.css"> -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&family=Noto+Sans+KR&display=swap" rel="stylesheet">
    <script src="/resources/jq/jquery.js"></script>
    
    <script>
   	function webViewToApp() {
   		WebViewCallbackInterface.webViewToApp();
   	}
    </script>
    
    <script>
    
    let arr = new Array();    
    
    $().ready(()=>{
    	
    	console.log("${user}");
    	

        
    	//친환경 소비 인증 버튼
    	$(".go-certify").click(function(){
    		//소비 인증
    		if($(".go-certify").text() == "친환경 소비 인증하기"){
    			
    			webViewToApp();
    			// location.href = "certify";
    			
    		}
    		
    		//숲에 심기
    		if($(".go-certify").text() == "숲에 심어보세요"){
    			$.ajax({
    				url : "/login/plant",
    				type : "post",
    				data : {"plantId" : ${user.plantId}},
    				success : function(){
    					location.href = "userforest/?inven=on";
    				}  //success 끝
    			})  //ajax 끝
    		}
    		
    	})  //친환경 소비 인증 버튼 끝
    	
    	//처음 페이지 로딩시
    	if(${user.stateId} == 0){
    		$(".go-certify").text("씨앗을 심어보세요")
    	}
    	

    	//버튼 클릭 이벤트
			$('#plantButton').click(function(){
				console.log("plantButton 클릭 이벤트 실행")
				$.ajax({
					url : "/login/init",
					success : function(data){
						arr = data;
						console.log(data);
						arr.forEach((value,index)=>{								
							let img = $("<img class='card'>");        	                
							img.attr("id",value.plantId);
							img.attr("src",value.plantImage);							
							$("#cards").append(img);							
						})
						$("#plantButton").addClass("hide");
						$("#cards").removeClass("hide");
					}
				})
				
                $(".go-certify").text("식물을 선택해 주세요.")
			})
			

		//카드 클릭 이벤트 	
		$('#cards').on("click",".card",function(data){  		
		    
            if($("#cards").hasClass("cardsback")){
                /* $(".card").fadeOut(); */
                $(".card").hide();
                $(this).addClass("selectedCard")
                $('#cards').removeClass("cardsback")
                $(this).fadeIn();
                $(".go-certify").data("select",$(this).attr("id"))
                $(".go-certify").text("선택한 씨앗을 심습니다.")
            } else{            
            $(".card").fadeIn();
            $(".card").removeClass("selectedCard")
            $('#cards').addClass("cardsback")
            $(".go-certify").data("select",0)
            $(".go-certify").text("식물을 선택해 주세요.")
            }

            
		    
			
		
		})

        //씨앗심을땐 확인버튼, 식물 키울땐 인증 버튼 행동을 위한 상태 값
        $(".go-certify").data("select",0);
        //씨앗심을땐 확인버튼, 식물 키울땐 인증 버튼
        $(".go-certify").click(function(){
            if($(this).data("select") > 0){
                $.ajax({
                    url:"/login/update?plantId="+$(this).data("select")+"&stateId="+1,
                    success : function(data){
                        location.replace("/login/")
        
                    },		
                    error: function(data){
                        console.log(data);
                    }
                    
                })         
            }
            if($(this).data("select") === 0){}
            if($(this).data("select") < -1){
            	
            	
            	
            }
        })


    	//상태값이 0일때 행동
		if(${user.stateId} === 0){
			
			$('#plantButton').removeClass("hide");
			
			            
			        
		}
        
        //상태 0보다 큼		
        if(${user.stateId} > 0){
        	$(".go-certify").data("select",-1)
        	let img = $("<img class='plantImg'>")
        		img.attr("src","${user.plant}");
        		
        		$("#plnat").empty();
        		$("#plant").append(img);
            	$("#plant").removeClass("hide");
            	
                //나무가 1단계일떄
                if(${user.stateId}===1){
                	$("#gauge").css('width','0px');
                	$("#heart").css('display','block');
                	$("#heart").css('left','9px');
                }
              	//나무가 2단계일떄
              	else if(${user.stateId}===2){
                	$("#gauge").css('width','50px');
                	$("#heart").css('display','block');
                	$("#heart").css('left','59px');
                }
              	//나무가 3단계일떄
              	else if(${user.stateId}===3){
                	$("#gauge").css('width','100px');
                	$("#heart").css('display','block');
                	$("#heart").css('left','109px');
                }
              	//나무가 4단계일떄
              	else if(${user.stateId}===4){
                	$("#gauge").css('width','150px');
                	$("#heart").css('display','block');
                	$("#heart").css('left','159px');
                }
              	//나무가 5단계일떄
              	else if(${user.stateId}===5){
                	$("#gauge").css('width','200px');
                	$("#heart").css('display','block');
                	$("#heart").css('left','209px');
                	$(".go-certify").text("숲에 심어보세요")
                }
		}


		
	})//onreday 끝
    
    	
   

    </script>
    
    <style>
    	*{
    padding: 0;
    margin: 0;
    list-style: none;
    box-sizing: border-box;
    font-family: 'Noto Sans KR', sans-serif;
}
a{
    text-decoration: none;
    color: black;
}
.selectedCard{
    /* scale: 2; */
    margin-left: 50%;
    height: auto;
    position: absolute;
    top: 40%;
    left: 45%;
    transform : translate(-50%, -50%);
   /*  max-width: 100%; */
    width: 130px !important;
    margin-top : 0px !important;

}
#align{
    width: 328px;
    height: calc(100vh - 56px - 35px);
    /* 100 - 하단메뉴바 - 타이틀 상단 마진*/
    /* margin: 0 auto; */
    position: absolute;
    top: 50%;
    left: 50%;
    transform : translate(-50%, -50%);
}


.title{
    width: 100%;
    height: 51px;
    margin-top: 35px;
    margin-bottom: 44px;
    /* border: 1px solid red; */
}
.title p{
    font-family: NotoSansKR;
    font-size: 16px;
    font-weight: normal;
    font-stretch: normal;
    font-style: normal;
    letter-spacing: 0.53px;
}



.home-screen .screen-bg{
    width: 100%;
    height: 292.44px;
    /* border: 1px solid red; */
    position: relative;
}
.home-screen .screen-bg img{
    width: 100%;
}
.home-screen #seed{
    width: 127px;
    height: 127px;
 
    position: absolute;
    /* top: 100px; */
    top : 60px;
    left: 145px;
    transform: translate(-50%);
    /* border : 1px solid blue; */
}
.home-screen .process{
    position: absolute;
    top: 255px;
    left: 50%;
    transform: translate(-50%);
    width: 232.9px;
    height: 28.1px;
    
}

.home-button{
    width: 193px;
    height: 82px;
    margin: 0 auto;
    margin-top: 16.6px;
}
.home-button .go-certify{
    width: 100%;
    height: 38px;
    padding: 9px;
    text-align: center;
    background-color: #94d3ac;
    border-radius: 20px;
    font-family: NotoSansKR;
    font-size: 15px;
    font-weight: bold;
    font-stretch: normal;
    font-style: normal;
    color: #fff;
}
.home-button .go-forest{
    width: 100%;
    height: 38px;
    padding: 9px;
    margin-top: 15px;
    text-align: center;
    background-color: #085955;
    border-radius: 20px;
    font-family: NotoSansKR;
    font-size: 15px;
    font-weight: bold;
    font-stretch: normal;
    font-style: normal;
    color: #fff;
}


/* 공통메뉴바 */
.sticky{
    position: fixed;
    left: 0;
    bottom: 0;
    width: 100%;
    height: 56px;
    background-color: #66bb6a;
}
.sticky div{
    display: inline-block;
    color: white;
    text-align: center;
    width: 20%;
    height: 100%;
    margin: 0;
    position: relative;
    font-size: 11px;
}
.sticky svg{
    margin: auto 0;
    margin-top: 6.3px;
}
.sticky p{
    margin: auto 0;
    margin-top: 0px;
}



        #cards .card{
     
            width: 60px;
            margin: 11px;
        }
 
        
          #gauge{
            width: 0px;
            height : 11px;
            background-color: #66bb6a;
            position: absolute;
            top: 8px;
            left: 16px;
        }
                #heart{
            width: 25px;
            height: 25px;
            position: absolute;
            top: 1px;
            left: 0px;
            display : none;
        }
    	
    	
    	
    	
    	
		.screen-img{
		   
		    position: relative;
		    top: 53%;
		    left: 50%;
		    transform: translate(-50%,-50%);
		    width: 90%;
		    height: 200px;
		}
    	
    	#cards{
            width: 80%;
            height: 130px;
           
            top : 60%;
            left : 50%;
            transform : translate(-50%, -50%);
            position: absolute; 
            
            background-size : contain; 
            background-repeat : no-repeat;       
        }
        .cardsback{
            background-image: url('/resources/images/cards-bg2.png');  
        }
		
        #cards .card{
         
            width: 50px;
            margin: 13.7px;
    		margin-top: 25px; 

        }
    



        
        #plant img{
            height: 180px;
            /* width: 180px; */
            width : auto;
            /* border: 1px solid blue; */
            position: absolute;
            /* top: 30px; */
            bottom : 0;
            left: 50%;
            transform: translate(-50%);
            max-width: 180px;
            object-fit: contain;
        }
        .screen-bg{
        background-image: url("/resources/images/home-screen-bg.png");
        background-repeat: no-repeat;
        background-size: cover;
        
        }
        .screen-img{
        	position: relative;
        }
        
/*         #cards,#plantButtion,#plant{
            margin: auto auto;
        } */

		#plantButton{
			position: absolute;
			top: 0;
		}
		.hide{
			display:none;
		}
		
		
		
#popup01{
    display: none;
}
#popup02{
    display: none;
}
#popup01{
width: 90%;
height: 106px;
position: absolute;
top: 80%;
left: 50%;
transform: translate(-50%, -50%);
background-color: #fff;
z-index: 2;
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
.popup-title{
    width : 80%;
    margin: 0 auto;
    text-align: center;
    font-family: NotoSansKR;
    font-size: 14px;
    color: #666;
    padding: 17px;
}
/* .text-area{
	width: 70%;
	float: left;
} */
.popup-logo{
	position: absolute;
	width: 40px;
	top: 20px;
	left: 30px;
}
.check{
    font-family: NotoSansKR;
    font-size: 14px;
    text-align: center;
    color: #1377e7;
    width: 100%;
    display: inline-block;
    padding-top: 10px;
}
.cancel{
    font-family: NotoSansKR;
    font-size: 14px;
    text-align: center;
    width: 50%;
    display: inline-block;
    padding-top: 10px;
    cursor:pointer;
}
    </style>

</head>
<body>
    <div id="align">
        <div class="title">
            <p>${sessionScope.user.userNick} 님, 반가워요!</p>
            <p style="font-weight: bold;" id="hi">${msg}</p>
            <!-- <a href="/"><p style="font-size: 2em;">로그인 확인</p></a> -->
        </div>

        <div class="home-screen">
                <div class="screen-bg">
                   <!--  <img src="/resources/images/home-screen-bg.png" id="screen-bg-img"> -->
                            <div class="screen-img">
                            
                            	<div id="cards" class="cardsback hide">
                            
                        		</div>

                        		<div id="plantButton" class="hide">
                            		<img src="/resources/images/씨앗심기 버튼.png" id="seed">
                        		</div>

                        		<div id="plant" class="hide">
                            		
                        		</div>
                        	
                        	</div>
                    <div class="process">
                    <img src="/resources/images/home-screen-process.png">
                    <div id="gauge"></div>
                    <img src="/resources/images/heart.png" id="heart">
                    </div>
                </div>
        </div>

        <div class="home-button">
            <!-- <a href="certify"></a> --><div class="go-certify">친환경 소비 인증하기</div>
            <a href="userforest/"><div class="go-forest">숲으로 가기</div></a>
        	
        </div>
    </div>
    
    <!-- 팝업창 -->
    	<div id="popup01">
    	<div class="text-area">
    		<img class="popup-logo" src="/resources/images/login-logo.png">
        	<div class="popup-title">인증성공</div>
        	<a href="./"><div class="check">확인</div></a>
    	</div>
	</div>
	
	<div id="popup02" class="popup02">
    	<div class="text-area">
    		<img class="popup-logo" src="/resources/images/login-logo.png">
        	<div class="popup-title">인증실패</div>
        	<a href="./"><div class="check">확인</div></a>
    	</div>
	</div>


    <nav class="sticky">
        <a href="/login/"><div><svg xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 0 24 24" width="24px" fill="#FFFFFF"><path d="M0 0h24v24H0V0z" fill="none"/><path d="M12 5.69l5 4.5V18h-2v-6H9v6H7v-7.81l5-4.5M12 3L2 12h3v8h6v-6h2v6h6v-8h3L12 3z"/></svg><p id="home">홈</p>
        </div></a><a href="/login/category/"><div><svg xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 0 24 24" width="24px" fill="#FFFFFF"><path d="M0 0h24v24H0V0z" fill="none"/><path d="M4 10.5c-.83 0-1.5.67-1.5 1.5s.67 1.5 1.5 1.5 1.5-.67 1.5-1.5-.67-1.5-1.5-1.5zm0-6c-.83 0-1.5.67-1.5 1.5S3.17 7.5 4 7.5 5.5 6.83 5.5 6 4.83 4.5 4 4.5zm0 12c-.83 0-1.5.68-1.5 1.5s.68 1.5 1.5 1.5 1.5-.68 1.5-1.5-.67-1.5-1.5-1.5zM7 19h14v-2H7v2zm0-6h14v-2H7v2zm0-8v2h14V5H7z"/></svg><p>카테고리</p>
        </div></a><a href="/login/search/"><div><svg xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 0 24 24" width="24px" fill="#FFFFFF"><path d="M0 0h24v24H0V0z" fill="none"/><path d="M15.5 14h-.79l-.28-.27C15.41 12.59 16 11.11 16 9.5 16 5.91 13.09 3 9.5 3S3 5.91 3 9.5 5.91 16 9.5 16c1.61 0 3.09-.59 4.23-1.57l.27.28v.79l5 4.99L20.49 19l-4.99-5zm-6 0C7.01 14 5 11.99 5 9.5S7.01 5 9.5 5 14 7.01 14 9.5 11.99 14 9.5 14z"/></svg><p>검색</p>
        </div></a><a href="/login/favorite/"><div><svg xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 0 24 24" width="24px" fill="#FFFFFF"><path d="M0 0h24v24H0V0z" fill="none"/><path d="M12 21.35l-1.45-1.32C5.4 15.36 2 12.28 2 8.5 2 5.42 4.42 3 7.5 3c1.74 0 3.41.81 4.5 2.09C13.09 3.81 14.76 3 16.5 3 19.58 3 22 5.42 22 8.5c0 3.78-3.4 6.86-8.55 11.54L12 21.35z"/></svg><p>즐겨찾기</p>
        </div></a><a href="/login/setting/"><div><svg xmlns="http://www.w3.org/2000/svg" enable-background="new 0 0 24 24" height="24px" viewBox="0 0 24 24" width="24px" fill="#FFFFFF"><g><path d="M0,0h24v24H0V0z" fill="none"/><path d="M19.14,12.94c0.04-0.3,0.06-0.61,0.06-0.94c0-0.32-0.02-0.64-0.07-0.94l2.03-1.58c0.18-0.14,0.23-0.41,0.12-0.61 l-1.92-3.32c-0.12-0.22-0.37-0.29-0.59-0.22l-2.39,0.96c-0.5-0.38-1.03-0.7-1.62-0.94L14.4,2.81c-0.04-0.24-0.24-0.41-0.48-0.41 h-3.84c-0.24,0-0.43,0.17-0.47,0.41L9.25,5.35C8.66,5.59,8.12,5.92,7.63,6.29L5.24,5.33c-0.22-0.08-0.47,0-0.59,0.22L2.74,8.87 C2.62,9.08,2.66,9.34,2.86,9.48l2.03,1.58C4.84,11.36,4.8,11.69,4.8,12s0.02,0.64,0.07,0.94l-2.03,1.58 c-0.18,0.14-0.23,0.41-0.12,0.61l1.92,3.32c0.12,0.22,0.37,0.29,0.59,0.22l2.39-0.96c0.5,0.38,1.03,0.7,1.62,0.94l0.36,2.54 c0.05,0.24,0.24,0.41,0.48,0.41h3.84c0.24,0,0.44-0.17,0.47-0.41l0.36-2.54c0.59-0.24,1.13-0.56,1.62-0.94l2.39,0.96 c0.22,0.08,0.47,0,0.59-0.22l1.92-3.32c0.12-0.22,0.07-0.47-0.12-0.61L19.14,12.94z M12,15.6c-1.98,0-3.6-1.62-3.6-3.6 s1.62-3.6,3.6-3.6s3.6,1.62,3.6,3.6S13.98,15.6,12,15.6z"/></g></svg><p>설정</p></div></a>
    </nav>
    
    
    
    

</body>
    <script>
	//친환경 소비 인증 끝나고
/* 	if("${result}" == "인증성공"){
		setTimeout(function(){
			alert("인증성공");	
		}, 1000);
		
	}
	else if("${result}" == "인증실패"){
		setTimeout(function(){
			alert("인증실패");
		}, 1000);
		
	} */
    </script>
    
    
    
    
    
    <script>
    
  //친환경 소비 인증 끝나고
 $(document).ready(function( $ ){ 
	if("${result}" == 1){
    $("img").on("load", function(event) { 
    $("#popup01").show();  
    $("body").append('<div class="backon"></div>');
    });
	 }
    
      
   else if("${result}" == 2){
    $("img").on("load", function(event) { 
        $("#popup02").show();  
        $("body").append('<div class="backon"></div>');
        });
      }

  });

	
</script>
    

</html>
