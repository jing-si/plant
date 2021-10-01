<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색리스트 관리</title>
</head>
<body>
	<div>
		<h3>검색리스트 추가</h3>
		<form method="post">
			<div>
				<label>이메일: </label>
				<input type="text" name="userId" value="${item.userId}">
			</div>
			<div>
				<label>검색 ID: </label>
				<input type="number" name="searchId" value="${item.searchId}">
			</div>
			<div>
				<label>검색어: </label>
				<input type="text" name="searchWord" value="${item.searchWord}">
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