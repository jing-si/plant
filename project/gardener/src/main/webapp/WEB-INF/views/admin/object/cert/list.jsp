<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사업자 관리</title>
<jsp:include page="../include/header.jsp"></jsp:include>
<script type="text/javascript">

	
</script>
<style type="text/css">
	img{
		max-width: 80px;
		max-height: 80px;
	}
</style>
</head>
<body>
	<div>
		<div>
			<h2>사업자 관리</h2>
		</div>
		<div>
		<form id="autoUpdate" action="autoupdate" method="post">
			<table>
				<thead>
					<tr>						
						<th>인증 마크</th>
						<th>인증 ID</th>
						<th>인증 이름</th>
						<th>마크 주소</th>
						<th>인증 정보</th>						
						<th>인증 관리</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${list}">
						<tr>
							<td><img alt="" src=" ${item.certImage }"></td>							
							<td>${item.certId }</td>
							<td>${item.certName }</td>
							<td>${item.certImage }</td>
							<td>${item.certInfo }</td>													
							<td>
							<a href="update/${item.certId }">수정</a> 
							<a href="delete/${item.certId }">삭제</a>
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