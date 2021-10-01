<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>배치 관리</title>
</head>
<body>
	<div>
		<h3>배치 목록</h3>
		<div>
			<table>
				<thead>
					<tr>
						<th>이메일</th>
						<th>배치 ID</th>
						<th>식물 ID</th>
						<th>사이즈</th>
						<th>X 좌표</th>
						<th>Y 좌표</th>
						<th>순서</th>
						<th>관리</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${list.size() < 1}">
						<tr>
							<td colspan="8">등록된 기록이 없습니다.</td>
						</tr>
					</c:if>
					<c:forEach var="item" items="${list}">
						<tr>
							<td>${item.userId}</td>
							<td>${item.plantId}</td>
							<td>${item.locationSize}</td>
							<td>${item.locationX}</td>
							<td>${item.locationY}</td>
							<td>${item.locationOrder}</td>
							<td><a href="delete/${item.userId}">삭제</a><a href="update/${item.userId}">변경</a>
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