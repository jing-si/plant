<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유저 등록</title>
</head>
<body>
	<div>
		<h3>유저정보 추가</h3>
		<form method="post">
			<div>
				<label>이메일: </label>
				<input type="text" name="userId">
			</div>
			<div>
				<label>닉네임: </label>
				<input type="text" name="userNick">
			</div>
			<div>
				<label>비밀번호: </label>
				<input type="text" name="userPass">
			</div>
			<div>
				<label>생년월일: </label>
				<input type="date" name="userBirth">
			</div>
			<div>
				<label>성별: </label>
				<input type="text" name="userGender">
			</div>
			<div>
				<label>상태ID: </label>
				<input type="number" name="stateId">
			</div>
			<div>
				<label>숲ID: </label>
				<input type="number" name="forestId">
			</div>
			<div>
				<label>식물ID: </label>
				<input type="number" name="plantId">
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