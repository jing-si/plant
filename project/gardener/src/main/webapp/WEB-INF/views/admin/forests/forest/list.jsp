<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>숲 관리</title>
</head>
<body>
	<div>
		<h3>숲 목록</h3>
		<div>
			<table>
				<thead>
					<tr>
						<th>숲 ID</th>
						<th>숲 이름</th>
						<th>숲 이미지</th>
						<th>숲 정보</th>
						<th>관리</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${list.size() < 1}">
						<tr>
							<td colspan="5">등록된 숲이 없습니다.</td>
						</tr>
					</c:if>
					<c:forEach var="item" items="${list}">
						<tr>
							<td>${item.forestId}</td>
							<td>${item.forestName}</td>
							<td>${item.forestImage}</td>
							<td>${item.forestInfo}</td>
							<td><a href="delete/${item.forestId}">삭제</a><a href="update/${item.forestId}">변경</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div>
			<a href="add">등록</a>
		</div>
		<div>
			<a href="..">이전으로</a>
		</div>
	</div>
</body>
</html>