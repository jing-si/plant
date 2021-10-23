<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${!empty sessionScope.admin }">
	<div class="row">
		<!-- 
		<div class="col logout py-2 mt-1" >
			<a href="#" class="logout">[내 정보 보기]</a>
		</div>  
		-->
		<div class="col logout ms-3 mt-1 py-2">
			<h5>
				<a href="/admin/logout" class="logout"><i
					class="bi bi-person-square"></i> <strong>LOGOUT</strong></a>
			</h5>
		</div>
	</div>
</c:if>