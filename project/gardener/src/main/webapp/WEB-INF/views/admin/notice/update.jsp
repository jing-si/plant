<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 변경</title>
</head>
<body>
	<div>
		<h3>공지 변경</h3>
		<form method="post">
			<div>
				<label>공지ID: </label>
				<input type="number" name="noticeId" value="${item.noticeId}" readonly>
			</div>
			<div>
				<label>제목: </label>
				<input type="text" name="noticeTitle" value="${item.noticeTitle}">
			</div>
			<div>
				<label>내용: </label>
				<input type="text" name="noticeContent" value="${item.noticeContent}">
			</div>
			<div>
				<label>날짜: </label>
				<input type="date" name="noticeDate" value="<fmt:formatDate value="${item.noticeDate}" pattern="yyyyMMdd"/>">
			</div>
			<div>
				<input type="submit" value="변경">
			</div>
		</form>
		<div>
			<a href="../">공지 목록으로</a>
		</div>
	</div>
</body>
</html>