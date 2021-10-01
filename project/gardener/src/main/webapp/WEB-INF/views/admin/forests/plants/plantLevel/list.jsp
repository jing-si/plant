<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>식물단계 관리</title>
<Style>
img{
max-height: 80px;
max-width: 80px;
}
</Style>
</head>
<body>
	<div>
		<h3>식물단계 목록</h3>
		<div>
			<table>
				<thead>
					<tr>
						<th>식물단계 이미지</th>
						<th>식물단계 ID</th>
						<th>식물 ID</th>
						<th>식물이미지</th>
						<th>관리</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${list.size() < 1}">
						<tr>
							<td colspan="4">등록된 기록이 없습니다.</td>
						</tr>
					</c:if>
					<c:forEach var="item" items="${list}">
						<tr>
							<td><img alt="" src="${item.plantImage }"></td>
							<td>${item.plantLevelId}</td>
							<td>${item.plantId}</td>
							<td>${item.plantImage}</td>
							<td><a href="delete/${item.plantLevelId}">삭제</a><a href="update/${item.plantLevelId}">변경</a>
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