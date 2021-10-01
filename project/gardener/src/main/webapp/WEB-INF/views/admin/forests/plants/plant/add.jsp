<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나무 관리</title>
</head>
<body>
	<div>
		<h3>나무 추가</h3>
		<form method="post" enctype="multipart/form-data">
			<div>
				<label>식물 ID: </label> <input type="number" name="plantId" value="${item.plantId}">
			</div>
			<div>
				<label>식물이름: </label> <input type="text" name="plantName" value="${item.plantName}">
			</div>
			<div>
				<label>구분: </label> <input type="text" name="plantCategory" value="${item.plantCategory}">
			</div>
			<div>
				<label>설명: </label> <input type="text" name="plantInfo" value="${item.plantInfo}">
			</div>
			<div>
				<label>식물 실루엣: </label> <input type="file" name="plantShadow" value="${item.plantShadow}">
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