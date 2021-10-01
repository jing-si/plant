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
		<h3>검색리스트 변경</h3>
		<form method="post">
			<div>
				<label>이메일: </label> 
				<input type="text" name="userId" value="${item.userId}" readonly>
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
				<input type="submit" value="변경">
			</div>
		</form>
		<div>
			<a href="../">검색리스트 목록으로</a>
		</div>
	</div>
</body>
</html>