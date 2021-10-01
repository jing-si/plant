<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사업자 등록</title>

</head>
<body>
	<div>
		<div>
			<h2>사업자 등록</h2>
		</div>
		<div>
			<form method="POST">
				<div>
					<label>사업자 번호</label>
					<input type="NUMBER" name="companyId">
				</div>
				
				<div>
					<label>사업자 이름</label>
					<input type="text" name="companyName">
				</div>
				
				<div>
					<label>사업자 전화번호</label>
					<input type="text" name="companyTel">
				</div>
				<div>
					<label>사업자 주소</label>
					<input type="text" name="companyAddress">
				</div>
				<div>
					<label>사업자 홈페이지</label>
					<input type="text" name="compnayHomepage">
				</div>
				<div>
					<input type="submit">
				</div>
			</form>
		</div>
	</div>

</body>
</html>