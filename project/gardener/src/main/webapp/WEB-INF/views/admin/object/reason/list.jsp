<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인증사유</title>
<jsp:include page="../include/header.jsp"></jsp:include>
<style>
img{
	max-height: 80px;
	max-width: 80px;
}
</style>
</head>
<body>
	<div class="container">
		<div>
			<h2>인증사유</h2>
		</div>
		<div>
			<table class="table">
				<thead>
					<tr>
						<th>인증사유 마크</th>
						<th>인증사유 ID</th>
						<th>인증사유 이름</th>
						<th>마크  경로</th>						
						<th>인증사유 정보</th>
						<th>인증사유 관리</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${list}">
						<tr>
							<td><img src="${item.certReasonImage}"> </td>
							<td>${item.certReasonId }</td>
							<td>${item.certReasonName }</td>
							<td>${item.certReasonImage }</td>							
							<td>${item.certReasonInfo }</td>
							<td>
							<a href="update/${item.certReasonId }">수정</a> 
							<a href="delete/${item.certReasonId }">삭제</a>
							</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
			<div>
				<a href="add">등록</a>
			</div>
		</div>
	</div>

</body>
</html>