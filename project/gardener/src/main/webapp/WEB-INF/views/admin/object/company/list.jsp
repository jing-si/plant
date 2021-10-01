<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>사업자 관리</title>
<jsp:include page="../include/header.jsp"></jsp:include>
<script type="text/javascript">
$(function(){
	$("thead .form-check-input").click(function(){
		if($(this).is(":checked"))
			$("tbody .form-check-input").prop("checked",true);
		else
			$("tbody .form-check-input").prop("checked",false);
	})
});
</script>
</head>
<body>
	<div>
		<div>
			<h2>사업자 관리</h2>
		</div>
		<div>
		<form id="autoUpdate" action="autoupdate" method="post">
			<table class="table">
				<thead>
					<tr>
						<th><input type="checkbox" class="form-check-input"><th>
						<th>사업자 ID</th>
						<th>사업자 이름</th>
						<th>사업자 전화번호</th>
						<th>사업자 주소</th>
						<th>사업자 홈페이지</th>
						<th>사업자 관리</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${list}">
						<tr>						
							<td><input type="checkBox" class="form-check-input" value="${item.companyId }" name="companyIds"><td>
							<td>${item.companyId }</td>
							<td>${item.companyName }</td>
							<td>${item.companyTel }</td>
							<td>${item.companyAddress }</td>
							<td>${item.companyHomepage }</td>							
							<td>
							<a href="update/${item.companyId }">수정</a> 
							<a href="delete/${item.companyId }">삭제</a>
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