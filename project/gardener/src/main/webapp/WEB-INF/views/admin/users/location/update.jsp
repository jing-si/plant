<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>식물 관리</title>
</head>
<body>
	<div>
<h3>배치 변경</h3>
		<form method="post">
			<div>
				<label>이메일: </label> ${item.userId}
				<input type="text" name="userId" value="${item.userId}" readonly>
			</div>
			<div>
				<label>배치 ID: </label> ${item.locationId}
				<input type="number" name="locationId" value="${item.locationId}" readonly>
			</div>
			<div>
				<label>식물 ID: </label> 
				<input type="number" name="plantId" value="${item.plantId}">
			</div>
			<div>
				<label>사이즈: </label> 
				<input type="number" name="locationSize" value="${item.locationSize}">
			</div>
			<div>
				<label>X 좌표: </label> 
				<input type="number" name="locationX" value="${item.locationX}">
			</div>
			<div>
				<label>Y 좌표: </label> 
				<input type="number" name="locationY" value="${item.locationY}">
			</div>
			<div>
				<label>순서: </label> 
				<input type="number" name="locationOrder" value="${item.locationOrder}">
			</div>

			<div>
				<input type="submit" value="변경">
			</div>
		</form>
		<div>
			<a href="../">검색리스트 목록으로</a>
		</div>
 	</div>
</body>
</html>