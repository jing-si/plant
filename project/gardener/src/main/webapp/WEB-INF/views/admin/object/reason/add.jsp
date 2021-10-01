<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인증사유</title>
<jsp:include page="../include/header.jsp"></jsp:include>
</head>
<body>
	<div class="container">
		<div>
			<h2>인증 사유 등록</h2>
		</div>
		<div>
			<form method="POST" enctype="multipart/form-data">
				<div>
					<label>인증사유 이름</label>
					<input type="text" name="certReasonName">
				</div>
				
				<div>
					<label>인증사유 정보</label>
					<input type="text" name="certReasonInfo">
				</div>
				
				<div>
					<label>인증사유 이미지</label>
					<input type="file" name="uploadFile">
				</div>
				<div>
					<input type="submit">
				</div>
			</form>
		</div>
	</div>

</body>
</html>