<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 등록</title>
</head>
<body>
	<div>
		<h3>즐겨찾기 추가</h3>
		<form method="post">
			<div>
				<label>즐겨찾기 ID: </label>
				<input type="number" name="bookmarkId" value="${item.bookmarkId}">
			</div>
			<div>
				<label>이메일: </label>
				<input type="text" name="userId" value="${item.userId}">
			</div>
			<div>
				<label>날짜: </label>
				<input type="date" name="bookmarkDatetime" value="${item.bookmarkDatetime}">
			</div>
			<div>
				<label>제품코드: </label>
				<input type="number" name="productId" value="${item.productId}">
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