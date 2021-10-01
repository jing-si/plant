<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>식물단계 관리</title>
</head>
<body>
	<div>
		<h3>식물단계 추가</h3>
		<form method="post" enctype="multipart/form-data">
			<div>
				<label>식물단계 ID: </label> <input type="number" name="plantLevelId" value="${item.plantLevelId}">
			</div>
			<div>
				<label>식물 ID: </label> <input type="number" name="plantId" value="${item.plantId}">
			</div>
			<div>
				<label>식물이미지: </label> <input type="file" name="uploadFile" value="${item.plantImage}">
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