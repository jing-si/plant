<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 관리</title>
</head>
<body>
	<div>
		<h3>공지사항 목록</h3>
		<div>
			<table>
				<thead>
					<tr>
						<th>공지ID</th>
						<th>제목</th>
						<th>내용</th>
						<th>날짜</th>
						<th>관리</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${list.size() < 1}">
						<tr>
							<td colspan="5">등록된 공지가 없습니다.</td>
						</tr>
					</c:if>
					<c:forEach var="item" items="${list}">
						<tr>
							<td>${item.noticeId}</td>
							<td>${item.noticeTitle}</td>
							<td>${item.noticeContent}</td>
							<td><fmt:formatDate value="${item.noticeDate}" pattern="yyyyMMdd"/> </td>
							<td><a href="delete/${item.noticeId}">삭제</a><a href="update/${item.noticeId}">변경</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div>
			<a href="add">등록</a>
		</div>
		<div>
			<a href="..">관리자 페이지로</a>
		</div>
	</div>
</body>
</html>