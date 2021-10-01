<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인벤토리 관리</title>
</head>
<body>
	<div>
		<h3>인벤토리 추가</h3>
		<form method="post">
			<div>
				<label>인벤토리 ID: </label>
				<input type="number" name="invenId" value="${item.invenId}">
			</div>
			<div>
				<label>이메일: </label>
				<input type="text" name="userId" value="${item.userId}">
			</div>
			<div>
				<label>식물 ID: </label>
				<input type="number" name="plantId" value="${item.plantId}">
			</div>
			<div>
				<label>수량: </label>
				<input type="number" name="invenAmount" value="${item.invenAmount}">
			</div>
			<div>
				<input type="submit" value="추가">
			</div>
		</form>
		<div>
			<a href="list">목록</a>
		</div>
	</div>
</body>
</html>