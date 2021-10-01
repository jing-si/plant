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
		<h3>숲 추가</h3>
		<form method="post" enctype="multipart/form-data">
			<div>
				<label>숲 이름: </label> <input type="text" name="forestName">
			</div>
			<div>
				<label>숲 이미지: </label> <input type="file" name="uploadFile">
			</div>
			<div>
				<label>숲 정보: </label> <input type="text" name="forestInfo">
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