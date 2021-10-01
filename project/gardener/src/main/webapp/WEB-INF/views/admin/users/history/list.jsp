<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기록 관리</title>
</head>
<body>
	<div>
		<h3>기록 목록</h3>
		<div>
			<table>
				<thead>
					<tr>
						<th>기록 ID</th>
						<th>이메일</th>
						<th>제품코드</th>
						<th>기록 날짜</th>
						<th>기록 코멘트</th>
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
							<td>${item.historyId}</td>
							<td>${item.userId}</td>
							<td>${item.productId}</td>
							<td><fmt:formatDate value="${item.historyDateTime}"
									pattern="yyyyMMdd" /></td>
							<td>${item.historyComment}</td>
							<td><a href="delete/${item.historyId}">삭제</a><a
								href="update/${item.historyId}">변경</a></td>
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