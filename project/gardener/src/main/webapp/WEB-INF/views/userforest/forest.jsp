<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
<title>사용자 숲</title>
<link rel="stylesheet" href="/resources/css/005-01.css">
<link
	href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700;800&family=Noto+Sans+KR:wght@400;700;900&display=swap"
	rel="stylesheet">
<script type="text/javascript" src="/resources/js/005-01.js"></script>
<script src="/resources/jq/jquery.js"></script>
<script>



let arr = new Array();
let item ;
$().ready(()=>{
	//식물 배치 ajax
	$.ajax({
		url:"/login/userforest/setforest/init",
		success:function(data){
			arr = data;
			console.log(data);
			
			arr.forEach((value,index)=>{
				let div1 = $("<div class='userPlant'>");				
				let img = $("<img class='userPlantImg'>");
				// img.data("index",index);
				
				div1.attr("id", 'userPlant'+value.plantId);
				div1.data("index",index);
				div1.attr("data-order",value.locationOrder);
				
				img.attr("id", value.PlantId);				
				img.attr("src",value.plantImage);
				
			
				div1.css("z-index",value.locationOrder);
				//div1.css("zoom", value.locationSize);
				
				
				
				//item.locationX = currentlocation;
  
				$("#image-container").append(div1);
				div1.append(img);
				div1.css("left",value.locationX);
				div1.css("top",value.locationY);
				div1.attr("data-size",value.locationSize);
				//크기 조절
				img.on("load",function(){changeSize(div1)});
				
				
				
				
				
				// pc, mobile 모두 움직이게 jquery.ui.touch-punch.min.js 추가
				
				//div1.draggable({Array:[-10,-30,$(window).width()+10,$(window).height()+30]});
				
				/* 아래와 같이 넣어주고자 함
				<div id="userPlant01" class="userPlant">
					<img src="/resources/images/tree_01.png"></div>
				</div> 
				*/
				
			})
		}
	}) //ajax 끝
	
	//나무를 심을때 inven을 열고 시작
	inven();
	    
    //인벤 분류 icon 클릭시 이벤트
	$("#item_all").on("click",function(){
		$(".item_card").removeClass("hide");
		
		$('#tab_all').attr('src','/resources/images/tab_01_on.png');
		$('#tab_tree').attr('src','/resources/images/tab_02_off.png');
		$('#tab_flower').attr('src','/resources/images/tab_03_off.png');
		
	})
	
	$("#item_tree").on("click",function(){
		$(".tree").removeClass("hide");
		$(".flower").addClass("hide");
		
		$('#tab_all').attr('src','/resources/images/tab_01_off.png');
		$('#tab_tree').attr('src','/resources/images/tab_02_on.png');
		$('#tab_flower').attr('src','/resources/images/tab_03_off.png');	
	})
	
	$("#item_flower").on("click",function(){
		$(".tree").addClass("hide");
		$(".flower").removeClass("hide");
		
		
		$('#tab_all').attr('src','/resources/images/tab_01_off.png');
		$('#tab_tree').attr('src','/resources/images/tab_02_off.png');
		$('#tab_flower').attr('src','/resources/images/tab_03_on.png');
	})
	
	$("#popup_close").on("click",function(){
		$(".item_card").removeClass("hide");
		
		$('#tab_all').attr('src','/resources/images/tab_01_on.png');
		$('#tab_tree').attr('src','/resources/images/tab_02_off.png');
		$('#tab_flower').attr('src','/resources/images/tab_03_off.png');
	})
	
	      
	
	/* //인벤 분류 icon 클릭시 이벤트
   	$("#item_all").on("click",function(){
    	$(".item_card").removeClass("hide");
   	})
   
   	$("#item_tree").on("click",function(){
      	$(".tree").removeClass("hide");
      	$(".flower").addClass("hide");
   	})
   
   	$("#item_flower").on("click",function(){
      	$(".tree").addClass("hide");
      	$(".flower").removeClass("hide");
   	}) */
   
})
	
	
	

function changeSize(target){
		const img = $(target).children("img");
		const originW = Number(img.get(0).naturalWidth);
		const originH = Number(img.get(0).naturalHeight);
		const size = Number(target.attr("data-size"));
		
		console.log(size)
		console.log(originH * size)
		target.css("height", originH * size)
		target.css("width", originW * size)
		
		return originH * 0.1
		//item.css("height",h)
		//item.css("width",w)
		
	}
	
function inven() {
	const url = new URLSearchParams(window.location.search)
	if(url.has("inven")){
	if(url.get("inven") == 'on')
		$("#button_item").trigger("click");
	}
}
</script>

<style>
img{
	position: absolute;
}
#image-container {
	width: 100%;
	height: 100%;
	position: relative;
}

.userPlant {
	position: absolute;
}

.userPlantImg {
	object-fit: contain;
	height: 100%;
}
.hide{
	display:none;
}
/* 유저가 저장한 나무 이미지 CSS 생성공간 */
</style>

</head>
<body>
	<!-- 상단 투명 영역(사용자 숲 꾸미기와 나무 이미지 같은 영역에 위치하도록) -->
	<!-- <div class="header"></div> -->

	<div id="image-container">
		
	</div>

	<div class="main_container">
		<a href="/login/"><button type="button" id="button_close">
				<img src="/resources/images/btn_close.png" width="50" height="50">
			</button></a> <a href="/login/userforest/setforest/"><button type="button"
				id="button_setting">
				<img src="/resources/images/button_setting_2.png" width="50"
					height="50">
			</button></a>
		<button type="button" id="button_item">
			<img src="/resources/images/button_item.png" width="50" height="50">
		</button>
	</div>

	<!-- 컨테이너 -->
	<div class="container">
		<!-- 모달을 감쌀 박스 -->
		<div class="popup_wrap" id="popup">
			<div class="align">
				<!-- 실질적 모달 팝업 -->
				<div class="popup">
					<!-- 상단 버튼 영역 -->
					<div class="popup_head">
						<button type="button" id="popup_close"><img src="/resources/images/icon_close.png" width="18" height="18">
						</button>
					
						<div id="item_all"><img src="/resources/images/tab_01_on.png" class="item" id="tab_all" width="40" height="25">
						</div><div id="item_tree"><img src="/resources/images/tab_02_off.png" class="item" id="tab_tree" width="40" height="25">
						</div><div id="item_flower"><img src="/resources/images/tab_03_off.png" class="item" id="tab_flower" width="40" height="25">
						</div>
					</div>
					<!-- 하단 빈공간 -->

					<!-- 아이템 인벤토리 영역 -->
					<div class="popup_body">
						<div class="scroll_container">
							<div class="scroll_wrap">

								<c:forEach var="list" items="${list}">									
									<c:if test="${list.invenAmount > 0}">
									<div class="item_card ${list.plantCategory }" id="plant_01 "> <!-- 특정 나무의 보유 수량이 1개 이상 이면, 백그라운드 카드 이미지 노출 -->
										<img class="item_bg" src="${list.plantThumbnail }">
										<p class="text_left">보관중인 나무 :</p>
										<p class="text_right">그루</p>
										<p class="text_amount">${list.invenAmount}</p>
										<a href="../userforest/${list.plantId }/plant">
											<p class="planting_btn">
											<p class="planting_btn_text">나무 심기</p>
											</p>
										</a>
									</div>
									</c:if>
								</c:forEach>
							</div>
						</div>
					</div>
					<div class="popup_footer"></div>
				</div>
			</div>
		</div>
	</div>


	<script type="text/javascript">
		// 모달창 클릭 이벤트
		document.getElementById("button_item").onclick = function() {
			document.getElementById("popup").style.display="block";
		}

		document.getElementById("popup_close").onclick = function() {
			document.getElementById("popup").style.display="none";
		}
		
		/* 
		document.getElementById("popup_close").onclick = function() {
			localStorage.setItem('img','list.plantId');
			console.log(img);
			window.location.href = "../userforest/setforest/"; 
		}
		
 */
			

		
		// 유저 숲 저장 데이터 가져오기
		 



</script>
</body>
</html>