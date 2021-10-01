<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기록 등록</title>
</head>
<body>
	<div>
		<h3>기록 추가</h3>
		<form method="post">
			<div>
				<label>기록ID: </label>
				<input type="number" name="historyId" value="${item.historyId}">
			</div>
			<div>
				<label>이메일: </label>
				<input type="text" name="userId" value="${item.userId}">
			</div>
			<div>
				<label>제품코드: </label>
				<input type="number" name="productId" value="${item.productId}">
			</div>
			<div>
				<label>기록날짜: </label>
				<input type="date" name="historyDateTime" value="${item.historyDateTime}">
			</div>
			<div>
				<label>코멘트: </label>
				<input type="text" name="historyComment" value="${item.historyComment}">
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