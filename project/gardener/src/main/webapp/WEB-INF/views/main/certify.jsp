<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
	
	// 네이티브에서 값 전달
	function setReceivedMessage(msg) {
		document.getElementById('msg').innerHTML=msg;
		
	}
	
</script>
<body>
<form method="post">
	<input type="number" name="barcode" id="msg">
	<input type="submit">
</form>	
</body>
</html>