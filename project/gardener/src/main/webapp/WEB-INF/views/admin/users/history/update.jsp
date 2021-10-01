<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h3>기록 변경</h3>
		<form method="post">
			<div>
				<label>기록ID: </label> ${item.historyId}
			</div>
			<div>
				<label>이메일: </label> ${item.userId}
			</div>
			<div>
				<label>제품코드: </label>
				<input type="text" name="productId" value="${item.productId}">
			</div>
			<div>
				<label>기록날짜: </label>
				<input type="date" name="historyDateTime" value="<fmt:formatDate value="${item.historyDateTime}" pattern="yyyyMMdd"/>">
			</div>
			<div>
				<label>코멘트: </label>
				<input type="text" name="historyComment" value="${item.historyComment}">
			</div>
			<div>
				<input type="submit" value="변경">
			</div>
		</form>
		<div>
			<a href="../">기록 목록으로</a>
		</div>
	</div>
</body>
</html>