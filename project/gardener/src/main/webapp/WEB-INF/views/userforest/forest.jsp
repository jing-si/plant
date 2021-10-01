<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
$.ajax({
	url:"../init",
	success:function(data){
		arr = data;
		console.log(data);
		
		arr.forEach((value,index)=>{
			let div1 = $("<div class='userPlant'>");				
			let img = $("<img class='userPlantImg'>");
			// img.data("index",index);
			
			div1.attr("id", 'userPlant'+value.plantId);
			div1.data("index",index);
			
			img.attr("id", value.PlantId);
			img.attr("src",value.plantImage);
							
			div1.css("z-index",value.locationOrder);
			div1.css("transform : scale", value.locationSize);
		
			
			
			//item.locationX = currentlocation;

			$("#image-container").append(div1);
			div1.append(img);
			div1.css("left",value.locationX);
			div1.css("top",value.locationY);				
			
			/* 아래와 같이 넣어주고자 함
			<div id="userPlant01" class="userPlant">
				<img src="/resources/images/tree_01.png"></div>
			</div> 
			*/
		})
	}
})
})
</script>

<style>
img{
	position: absolute;
}
#image-container{
	position: relative;
}
/* 유저가 저장한 나무 이미지 CSS 생성공간 */
</style>

</head>
<body>

	<div id="image-container">
		
	</div>

	<div class="main_container">
		<a href="/"><button type="button" id="button_close">
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
						</button><div class="item_all"><img src="/resources/images/item_all.png" width="45" height="30">
						</div><div class="item_tree"><img src="/resources/images/item_tree_disable.png" width="45" height="30">
						</div><div class="item_flower"><img src="/resources/images/item_flower_disable.png" width="45" height="30">
						</div>
					</div>
					<!-- 하단 빈공간 -->

					<!-- 아이템 인벤토리 영역 -->
					<div class="popup_body">
						<div class="scroll_container">
							<div class="scroll_wrap">

								<c:forEach var="list" items="${list}">
									<c:if test="${list.invenAmount < 1}"> <!-- 특정 나무의 보유 수량이 0이면, 백그라운드 카드 이미지 노출 -->
										<div class="item_card" id="plant_01">
											<img class="item_bg"
												src="/resources/images/treeBg${list.plantId}.png">
											<p class="text_left">보관중인 나무 :</p>
											<p class="text_right">그루</p>
											<p class="text_amount">${list.invenAmount}</p>
											<!-- <a href="../userforest/setforest/"> -->
												<p class="planting_btn"></p>
												<p class="planting_btn_text">나무 심기</p>
											<!-- </a> -->
										</div>
									</c:if>
									<c:if test="${list.invenAmount > 0}">
									<div class="item_card" id="plant_01"> <!-- 특정 나무의 보유 수량이 1개 이상 이면, 백그라운드 카드 이미지 노출 -->
										<img class="item_bg" src="/resources/images/treecd${list.plantId}.png">
										<p class="text_left">보관중인 나무 :</p>
										<p class="text_right">그루</p>
										<p class="text_amount">${list.invenAmount}</p>
										<a href="../userforest/setforest/">
											<p class="planting_btn">
											<p class="planting_btn_text">나무 심기</p>
											</p>
										</a>
									</div>
									</c:if>
								</c:forEach>

<!-- 
								<div class="item_card" id="plant_02">
									<img class="item_bg" src="/resources/images/tree01_bg.png">
									<p class="text_left">보관중인 나무 :</p>
									<p class="text_right">그루</p>
									<p class="text_amount">1</p>
									<a href="../userforest/setforest/">
										<p class="planting_btn"></p>
										<p class="planting_btn_text">나무 심기</p>
									</a>
								</div> -->

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
		
		
		document.getElementById("popup_close").onclick = function() {
			localStorage.setItem('img','list.plantId');
			console.log(img);
			window.location.href = "../userforest/setforest/"; 
		}
		

			

		
		// 유저 숲 저장 데이터 가져오기
		 



</script>
</body>
</html>