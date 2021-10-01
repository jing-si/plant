<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품 관리</title>
<jsp:include page="../include/header.jsp"></jsp:include>
<script type="text/javascript">
	
</script>
</head>
<body>
	<div>
		<div>
			<h2>제품 관리</h2>
		</div>
		<div>
		<form id="autoUpdate" action="autoupdate" method="post">
			<table>
				<thead>
					<tr>
						<th><input type="checkBox"><th>
						<th>제품 이미지</th>
						<th>제품 ID</th>
						<th>제품 이름</th>
						<th>제품 규격</th>
						<th>이미지 경로</th>
						<th>인증 현황</th>
						<th>제품 인증 번호</th>
						<th>인증 시작일</th>
						<th>인증 만료일</th>
						<th>사업자 번호</th>
						<th>g2bId</th>
						<th>elId</th>
						<th>제품 관리</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${list}">
						<tr>
							<td><input type="checkBox" value="${item.productId }" name="ProductIds"><td>
							<td><img alt="" src="${item.productIamge }"></td>
							<td>${item.productId }</td>
							<td>${item.productName }</td>
							<td>${item.productSize }</td>
							<td>${item.productImage}</td>
							<td>${item.certId }</td>
							<td>${item.productCertId }</td>
							<td>${item.productStartDate }</td>
							<td>${item.productEndDate }</td>
							<td>${item.companyId }</td>
							<td>${item.g2bId }</td>
							<td>${item.elId }</td>							
							<td>
							<a href="update/${item.productId }">수정</a> 
							<a href="delete/${item.productId }">삭제</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="5">
							<div class="pagination justify-content-center" >
								<div class="page-item" ><a href="?page=1&${pager.query }" class="page-link">처음</a></div>
								<div class="page-item"><a href="?page=${pager.prev}&${pager.query }" class="page-link">이전</a></div>
								<c:forEach var="page" items="${pager.list}"> 
									<div class="page-item ${page==pager.page?'active':'' }"><a href="?page=${page}&${pager.query }" class="page-link">${page}</a></div>									
								</c:forEach>
								<div class="page-item"><a href="?page=${pager.next}&${pager.query }" class="page-link">다음</a></div>
								<div class="page-item"><a href="?page=${pager.last}&${pager.query }" class="page-link">마지막</a></div>
							</div>
						</td>
					</tr>
				</tfoot>
			</table>
			</form>
			<div>
				<a href="add">등록</a>
				<button type="submit" form="autoUpdate">자동 검색 등록</button>
			</div>
		</div>
	</div>

</body>
</html>