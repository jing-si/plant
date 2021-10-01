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
		<h3>즐겨찾기 변경</h3>
		<form method="post">
			<div>
				<label>즐겨찾기 ID: </label> ${item.bookmarkId}
			</div>
			<div>
				<label>이메일: </label>
				<input type="text" name="userId" value="${item.userId}">
			</div>
			<div>
				<label>날짜: </label>
				<input type="date" name="bookmarkDatetime" value="<fmt:formatDate value="${item.bookmarkDatetime}" pattern="yyyyMMdd HH:mm:ss"/>">
			</div>
			<div>
				<label>제품코드: </label>
				<input type="number" name="productId" value="${item.productId}">
			</div>
			<div>
				<input type="submit" value="변경">
			</div>
		</form>
		<div>
			<a href="../">즐겨찾기 목록으로</a>
		</div>
	</div>
</body>
</html>