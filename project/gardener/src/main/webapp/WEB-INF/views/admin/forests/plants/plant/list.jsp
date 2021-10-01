<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>식물 관리</title>
</head>
<body>
	<div>
		<h3>식물 목록</h3>
		<div>
			<table>
				<thead>
					<tr>
						<th>식물 ID</th>
						<th>식물이름</th>
						<th>구분</th>
						<th>설명</th>
						<th>식물실루엣</th>
						<th>관리</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${list.size() < 1}">
						<tr>
							<td colspan="6">등록된 기록이 없습니다.</td>
						</tr>
					</c:if>
					<c:forEach var="item" items="${list}">
						<tr>
							<td>${item.plantId}</td>
							<td>${item.plantName}</td>
							<td>${item.plantCategory}</td>
							<td>${item.plantInfo}</td>
							<td>${item.plantShadow}</td>
							<td><a href="delete/${item.plantId}">삭제</a><a href="update/${item.plantId}">변경</a>
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