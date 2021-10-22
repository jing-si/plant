<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=no">
<title>숲꾸미기</title>
<link rel="stylesheet" href="/resources/css/005-01-01.css">
<link
	href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700;800&family=Noto+Sans+KR:wght@400;700;900&display=swap"
	rel="stylesheet">

<!-- jquery 리소스 파일 사용 -->	
<script src="/resources/jq/jquery-ui.css"></script>
<script src="/resources/jq/jquery.js"></script>
<script src="/resources/jq/jquery-ui.js"></script>

<!-- <link rel="stylesheet" href="//code.jquery.com/ui/1.13.0/themes/base/jquery-ui.css">
<script src="/resources/jq/jquery.js"></script>
<script src="https://code.jquery.com/ui/1.13.0/jquery-ui.js"></script> -->

<!-- 모바일 draggable() 지원 -->
<script src="/resources/jq/jquery.ui.touch-punch.min.js"></script>



<script>

/* if(localStorage.getItem('img')){
	var lastData = localStorage.getItem('img');
	console.log(lastData);
	document.write("<img src=/resources/images/tree" + lastData + ">");
}
 */

    let arr = new Array();
    let item;
	$().ready(()=>{
	
	
		//세이브
	$(".save_btn").click(()=>{
      arr.map((value)=>{
    	  value.locationSize = value.div.attr("data-size");
		  value.locationX = value.div.css("left").replace("px","");
		  value.locationY = value.div.css("top").replace("px","");
		  value.locationOrder = value.div.css("z-index")		
		  value.div = "";
		  
      })
      
      console.log("저장중")
      $.ajax({
         method: "post",
         url:"/login/userforest/setforest/update",
         data: JSON.stringify({list:arr}),
         contentType: 'application/json',         
         success:function(data){
          	location.href="/login/userforest/"
         },
         error:function(data){
        	 alert("저장에 실패했습니다.")
         }

      })
      
   })
		
	$.ajax({
		url:"/login/userforest/setforest/init",
		success:function(data){
			arr = data;
			console.log(data);
			
			arr.forEach((value,index)=>{
				let div1 = $("<div class='userPlant'>");				
				let img = $("<img class='userPlantImg'>");
			
				
				div1.attr("id", 'userPlant'+value.plantId);
				div1.data("index",index);
				div1.attr("data-order",value.locationOrder);
				
				img.attr("id", value.PlantId);				
				img.attr("src",value.plantImage);
				
			
				div1.css("z-index",value.locationOrder);
				$("#image-container").append(div1);
				div1.append(img);
				div1.css("left",value.locationX);
				div1.css("top",value.locationY);
				div1.draggable();
				value.div = div1;
				div1.attr("data-size",value.locationSize);
				//크기 조절
				img.on("load",function(){changeSize(div1)});
				
				
				
			
				
			})
			
			<c:if test="${not empty sessionScope.newItem }">
				selectItem(arr[arr.length-1].div)		
			</c:if>
		}
	})
	
	
	
	
	$("#image-container").on("click", ".userPlant",function(data){
		selectItem(this)
	})

	$("#image-container").on("dragstart", ".userPlant",function(data){
		selectItem(this)
	})
	
	
	

	
	$('#zoom-in').click(function() { 
		
		if(item != undefined){
			const size = Number(item.attr("data-size"));
			if(size < 1.4){
				item.attr("data-size",(size + 0.1).toFixed(1))
				changeLocation(item,changeSize(item)*-1)
			}
		}
	})
	
	
	$('#zoom-out').click(function() { 
		if(item != undefined){
			const size = Number(item.attr("data-size"));
			if(size > 0.6){
				item.attr("data-size",(size - 0.1).toFixed(1))
				changeLocation(item,changeSize(item))
			}
		}
		
	})
	
	
    
	$('#btn-front').click(function() { 
		
		
		
		let imgZindex = Number(item.attr("data-order"));
		
		
		if(imgZindex < arr.length){
		let targetImgInfo = $(`[data-order=\${imgZindex+1}]`)
		
		item.attr("data-order",imgZindex + 1);
		targetImgInfo.attr("data-order",imgZindex);
		item.css("z-index", item.attr("data-order"));
		targetImgInfo.css("z-index", targetImgInfo.attr("data-order"));
		}
		
		
		
	})
	
	
	$('#btn-back').click(function() { 
		let imgZindex = Number(item.attr("data-order"));
		
		
		if(imgZindex > 0){
		let targetImgInfo = $(`[data-order=\${imgZindex-1}]`)
		
		item.attr("data-order",imgZindex - 1);
		targetImgInfo.attr("data-order",imgZindex);
		item.css("z-index", item.attr("data-order"));
		targetImgInfo.css("z-index", targetImgInfo.attr("data-order"));
		}
		
		
	})
	
	$('#btn-delete').click(function() { 
		let target = arr[item.data("index")];
		console.log(target.locationState)
		if(target.locationState == '1'){
			target.locationState = 4
		}else{
			target.locationState = 2
		}
		item.addClass("hide");
		
	})
	
	
	});
	
	function selectItem(selectedItem){
		item = $(selectedItem);
		$('.userPlant').removeClass('imgBox');
		$(selectedItem).addClass('imgBox');	
		
	}
	
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
		
	}
	
	function changeLocation(target,location){
		const top = Number(target.css("top").replace("px",""));
		target.css("top", top + location)
	}
	
</script>


<style>
.userPlant:hover {
	border: 1px solid grey;
}

.imgBox {
	border: 2px solid blue;
	padding: 0;
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
/* .userPlantImg {
	width: 200px;
	height: 230px;
} */
</style>

</head>
<body>
	<div class="wrapper">
		<div class="header">
			<p class="header_text">숲 꾸미기</p>
			<a href="/login/userforest/"><p class="close_btn">
					<img src="/resources/images/icon_close.png" width="18" height="18">
				</p></a>
			<p class="save_btn">
				<img src="/resources/images/icon_save.png" width="24" height="24">
			</p>
		</div>

		<div id="image-container"></div>

	
		<div class="footer">
			<div class="footer_btn">
				<img class="btn" id="btn-front"
					src="/resources/images/btn_front.png" width="45" height="45">
			</div><div class="footer_btn">
				<img class="btn" id="btn-back" src="/resources/images/btn_back.png"
					width="45" height="45">
			</div><div class="footer_btn">
				<img class="btn_delete" id="btn-delete"
					src="/resources/images/btn_delete.png" width="60" height="60">
			</div><div class="footer_btn">
				<img class="btn" id="zoom-in" src="/resources/images/btn_plus.png"
					width="45" height="45">
			</div><div class="footer_btn">
				<img class="btn" id="zoom-out" src="/resources/images/btn_minus.png"
					width="45" height="45">
			</div>
		</div>
	</div>

</body>
</html>