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
		console.log(qrNum);
		
		$.ajax({
			
			/* var qrNum = $("#barcode").val(); */
			
			url : "/login/search/qrajax",
			type : "post",
			data : {"barcode" : qrNum},
			success : function(data){
				if(data != "0"){
					console.log(qrNum)
					arr = data;
					console.log(arr.productId)
					location.href = "../category/product/"+arr.productId+"/"+arr.companyId
				}
				else{
					$("form").submit();
				}
				
			},
			error: function(){
				console.log(qrNum)
				console.log("전송실패")
			}
		})  //ajax 끝
		
		
	})  //submit 끝
});  //ready 끝

</script>



	<form action="../search" method="post">
		<input type="text" name="q" id="barcode">
	</form>
	
	<button id="submit">
</body>
</html>