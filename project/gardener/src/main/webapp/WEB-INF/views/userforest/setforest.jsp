<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>숲꾸미기</title>
<link rel="stylesheet" href="/resources/css/005-01-01.css">
<link
	href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700;800&family=Noto+Sans+KR:wght@400;700;900&display=swap"
	rel="stylesheet">


<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">

<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<script src="/resources/jq/jquery.js"></script>
<script>

/* if(localStorage.getItem('img')){
	var lastData = localStorage.getItem('img');
	console.log(lastData);
	document.write("<img src=/resources/images/tree" + lastData + ">");
}
 */

    let arr = new Array();
    let item ;
	$().ready(()=>{
	 
		//세이
	$(".save_btn").click(()=>{
      let aaa = [{
         userId:"A"
         }, {
         userId:"B"
         }, {
         userId:"C"
         }];
      
      console.log("저장중")
      $.ajax({
         method: "post",
         url:"update",
         data: JSON.stringify(aaa),
         contentType: 'application/json',
         dataType: 'json',
         success:function(data){
            console.log(data)

         }

      })
   })
		
	$.ajax({
		url:"../userforest/setforest/init2",
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
				
				console.log("z인덱스 : " + value.locationOrder);
				div1.css("zindex",value.locationOrder);
				div1.css("zoom", value.locationSize);
			
				
				
				//item.locationX = currentlocation;
  
				$("#image-container").append(div1);
				div1.append(img);
				div1.css("left",value.locationX);
				div1.css("top",value.locationY);				
				
				console.log(arr);
				
				/* 아래와 같이 넣어주고자 함
				<div id="userPlant01" class="userPlant">
					<img src="/resources/images/tree_01.png"></div>
				</div> 
				*/
				
			})
		}
	})
	
	
	$("#image-container").on("click", ".userPlant",function(data){
		item = $(this);
		$('.userPlant').removeClass('imgBox');
		$(this).addClass('imgBox');	
		console.log(item);
	})
	
	$("#image-container").on("mouseover", ".userPlant",function(data){
		$(this).draggable();
		
	})
	
	$('#zoom-in').click(function() { 
		
		let imgInfo = arr[$(item).data("index")];	
		let imgZoom = imgInfo.locationSize;
		let userPlantId = 'userPlant'+imgInfo.plantId;
		let zoomLevel = 0.1;
				 
		imgZoom += zoomLevel;
		console.log(imgZoom);
		
		if( imgZoom > 0.5 && imgZoom < 1.5 ){
			$("#"+userPlantId).css( {'zoom' : imgZoom });
		} else {
			imgZoom = 1.4;
		}
		
		imgInfo.locationSize = imgZoom;
	})
	
	$('#zoom-out').click(function() { 
		
		let imgInfo = arr[$(item).data("index")];	
		let imgZoom = imgInfo.locationSize;
		let userPlantId = 'userPlant'+imgInfo.plantId;
		let zoomLevel = 0.1;
		
		imgZoom -= zoomLevel;
		console.log(imgZoom);
		
		if( imgZoom > 0.5 && imgZoom < 1.5 ){
			$("#"+userPlantId).css( {'zoom' : imgZoom });
		} else {
			imgZoom = 0.6;
		}
		
		imgInfo.locationSize = imgZoom;
	})
	
	
    
	$('#btn-front').click(function() { 
		
		let imgInfo = arr[$(item).data("index")];
		let imgZindex = Number(imgInfo.locationOrder);
		let userPlantId = 'userPlant'+imgInfo.plantId;
		
		/* console.log(imgInfo);
		console.log('arr.lengrh: ' + arr.length);
		console.log('imgZindex: ' + imgInfo.locationOrder);
		console.log(userPlantId); */
		
		for(let i=0; i<arr.length; i++) {	
			if(Number(arr[i].locationOrder) === (imgZindex+1)) {
				
				arrZindex = Number(arr[i].locationOrder);
				
				let temp = imgZindex;
				imgZindex = arrZindex;
				arrZindex = String(temp);
				
				$("#"+userPlantId).css("z-index", imgZindex);
				$("#userPlant"+arr[i].userPlantId).css("z-index", arr[i].locationOrder); 
				
				imgInfo.locationOrder = imgZindex;
				arr[i].locationOrder = arrZindex;
				
				
				console.log(imgInfo.locationOrder);
				console.log(arr[i].locationOrder);
				console.log(arr[i]);
				
			}
			else {
				continue;
			}
		}
		
		
		
	})
	
	
	$('#btn-back').click(function() { 
		
		let imgInfo = arr[$(item).data("index")];
		let imgZindex = imgInfo.locationOrder;
		let userPlantId = 'userPlant'+imgInfo.plantId;
		
		/* console.log(imgInfo);
		console.log('arr.lengrh: ' + arr.length);
		console.log('imgZindex: ' + imgInfo.locationOrder);
		console.log(userPlantId); */
		
		for(let i=0; i<arr.length; i++) {
			if(Number(arr[i].locationOrder) === (imgZindex - 1)) {
				
				arrZindex = Number(arr[i].locationOrder);
				
				let temp = imgZindex;
				imgZindex = arrZindex;
				arrZindex = temp;
				
				/* console.log(i);
				console.log('arr[i].locationOrder: ' + arr[i].locationOrder);
				console.log('imgZindex: ' + imgZindex); */
				
				$("#"+userPlantId).css("zindex", imgZindex);
				$("#"+userPlantId).css("zindex", arr[i].locationOrder); 
				
				imgInfo.locationOrder = imgZindex;
				arr[i].locationOrder = arrZindex;
				
				
				console.log(imgInfo.locationOrder);
				console.log(arr[i].locationOrder);
				console.log(arr[i]);
			}
			else {
				continue;
			}
		}
		
		imgInfo.locationOrder = imgZindex;
		
		
	})
	
	$('#btn-delete').click(function() { 
		$(item).remove();
	})
	
	
	/* $.ajax({
		type: 'GET',
		url: "",
		data: {"id", id},
		success: function (data) {
			if(data){
				console.log("성공");
			} else {
				console.log("실패");
			}
			
		}
	}) */
	
	
	});
	
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
			<a href="/login/userforest/"><p class="close_btn"><img src="/resources/images/icon_close.png" width="18" height="18"></p></a> 
			<p class="save_btn"><img src="/resources/images/icon_save.png" width="24" height="24"></p>
		</div>

		<div id="image-container"></div>
		
		<div class="footer">
			<div class="footer_btn"><img class="btn" id="btn-front"src="/resources/images/btn_front.png" width="45" height="45">
			</div><div class="footer_btn"><img class="btn" id="btn-back" src="/resources/images/btn_back.png" width="45" height="45">
			</div><div class="footer_btn"><img class="btn_delete" id="btn-delete" src="/resources/images/btn_delete.png" width="60" height="60">
			</div><div class="footer_btn"><img class="btn" id="zoom-in" src="/resources/images/btn_plus.png" width="45" height="45">
			</div><div class="footer_btn"><img class="btn" id="zoom-out" src="/resources/images/btn_minus.png" width="45" height="45"></div></div></div>

</body>
</html>