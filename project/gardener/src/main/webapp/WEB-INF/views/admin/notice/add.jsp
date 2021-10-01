<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 등록</title>
</head>
<body>
	<div>
		<h3>공지 추가</h3>
		<form method="post">
			<div>
				<label>공지ID: </label>
				<input type="number" name="noticeId">
			</div>
			<div>
				<label>제목: </label>
				<input type="text" name="noticeTitle">
			</div>
			<div>
				<label>내용: </label>
				<input type="text" name="noticeContent">
			</div>
			<div>
				<label>날짜: </label>
				<input type="date" name="noticeDate">
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