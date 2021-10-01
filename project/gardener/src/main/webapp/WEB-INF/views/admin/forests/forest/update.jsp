<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>숲 관리</title>
</head>
<body>		 
	<div>
		<h3>숲 변경</h3>
		<form method="post">
			<div>
				<label>숲 ID: </label> ${item.forestId}
			</div>
			<div>
				<label>숲이름: </label> 
				<input type="text" name="forestName" value="${item.forestName}">
			</div>
			<div>
				<label>숲이미지: </label> 
				<input type="file" name="forestImage" value="${item.forestImage}">
			</div>
			<div>
				<label>숲정보: </label> 
				<input type="text" name="forestInfo" value="${item.forestInfo}">
			</div>
			<div>
				<input type="submit" value="변경">
			</div>
		</form>
		<div>
			<a href="../">숲 목록으로</a>
		</div>
 	</div>
</body>
</html>