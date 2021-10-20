<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/resources/jq/jquery.js"></script>
<style>
button{
	width: 100px;
	height: 100px;
}
</style>
</head>
<body>
<script>
$().ready(()=>{ 
	
	
	$("#submit").click(function(){
		var qrNum = $("#barcode").val();
		
		$.ajax({
			
			/* var qrNum = $("#barcode").val(); */
			
			url : "/search/qrajax",
			type : "post",
			data : {"barcode" : qrNum},
			success : function(data){
				if(data != null){
					arr = data;
					location.href = "./category/product/"+${arr.productId}+"/"+${arr.companyId}"
				}
				
			},
			error: function(){
				console.log("전송실패")
			}
		})  //ajax 끝
		
		
	})  //submit 끝
});  //ready 끝

</script>




	<input type="number" name="barcode" id="barcode">
	<button id="submit">
</body>
</html>