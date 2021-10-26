<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col mt-3">
	<!-- 로고 -->
	<div id="logo" class="mt-4">
		<a href="/admin/"> <img class="logo" alt="logo"
			src="/resources/image/need/logo_3.png">
		</a>
	</div>
	<!-- 로그인 정보 -->
	<div>
		<div class="mx-2 mt-5 px-2 side-login-text">
			<hr class="mx-0 my-2 p-0 side-hr">
			<c:if test="${empty sessionScope.admin }">

				
				<h5 class=" mx-2 my-3">
					<i class="bi bi-exclamation-circle"></i> 로그인이 <br> 필요합니다.
				</h5>

			</c:if>
			<c:if test="${!empty sessionScope.admin }">
				<h5>
					<i class="bi bi-emoji-laughing"></i>
					<c:out value="${sessionScope.admin.adminName }"></c:out>
				</h5>
				<p>
					님 안녕하세요.
				</p>
			</c:if>
			<hr class="mx-0 my-2 p-0 side-hr">
		</div>

	</div>
	<!-- 네비 -->

	<div id="left-side" class="col">
		<nav>

			<c:if test="${sessionScope.admin.product eq 'Y' }">
				<!-- 그룹 박스 -->
				<div class="mt-3">
					<p class="my-0 mx-2 left-side-th">product control</p>
					<hr class="mx-0 my-0 p-0 side-hr">
					<!-- 링크 박스 -->
					<div id="nav-cert" class="row side-nav">
						<div class="px-0 mx-0 col">
							<div class="px-0 mx-0 activeable"></div>
						</div>
						<div class="col-10 mx-0 p-0">
							<div class="side-nav-text m-0 py-2 px-1 "
								onclick='location.href="/admin/cert/?nav=cert"'>
								<i class="bi bi-award"></i> 인증 관리
							</div>

						</div>
					</div>
					<!-- 링크 박스 끝-->

					<hr class="mx-0 my-0 p-0 side-hr">
					<!-- 링크 박스 -->
					<div id="nav-class" class="row side-nav">
						<div class="px-0 mx-0 col">
							<div class="px-0 mx-0 activeable"></div>
						</div>
						<div class="col-10 mx-0 p-0">
							<div class="side-nav-text m-0  py-2 px-1 "
								onclick='location.href="/admin/class/?nav=class"'>
								<i class="bi bi-tags"></i> 분류 관리
							</div>

						</div>
					</div>
					<!-- 링크 박스 끝-->

					<hr class="mx-0 my-0 p-0 side-hr">
					<!-- 링크 박스 -->
					<div id="nav-datamanager" class="row side-nav">
						<div class="px-0 mx-0 col">
							<div class="px-0 mx-0 activeable"></div>
						</div>
						<div class="col-10 mx-0 p-0">
							<div class="side-nav-text  m-0  py-2 px-1 "
								onclick='location.href="/admin/datamanager/?nav=datamanager"'>
								<i class="bi bi-pen"></i> Data 매니저
							</div>

						</div>
					</div>
					<!-- 링크 박스 끝-->


					<hr class="mx-0 my-0 p-0 side-hr">
					<!-- 링크 박스 -->
					<div id="nav-product" class="row side-nav">
						<div class="px-0 mx-0 col">
							<div class="px-0 mx-0 activeable"></div>
						</div>
						<div class="col-10 mx-0 p-0">
							<div class="side-nav-text  m-0  py-2 px-1 "
								onclick='location.href="/admin/product/?nav=product"'>
								<i class="bi bi-briefcase"></i> 제품 관리
							</div>

						</div>
					</div>
					<!-- 링크 박스 끝-->

					<hr class="mx-0 my-0 p-0 side-hr">
					<!-- 링크 박스 -->
					<div id="nav-company" class="row side-nav">
						<div class="px-0 mx-0 col">
							<div class="px-0 mx-0 activeable"></div>
						</div>
						<div class="col-10 mx-0 p-0">
							<div class="side-nav-text   m-0  py-2 px-1 "
								onclick='location.href="/admin/company/?nav=company"'>
								<i class="bi bi-building"></i> 회사 관리
							</div>

						</div>
					</div>
					<!-- 링크 박스 끝-->
					<hr class="mx-0 my-0 p-0 side-hr">
				</div>
				<!-- 그룹 박스 끝 -->
			</c:if>

			<c:if test="${sessionScope.admin.user eq 'Y' }">
				<!-- 그룹 박스 -->
				<div class="mt-5">
					<p class="my-0 mx-2 left-side-th">user control</p>
					<hr class="mx-0 my-0 p-0 side-hr">
					<!-- 링크 박스 -->
					<div id="nav-user" class="row side-nav">
						<div class="px-0 mx-0 col">
							<div class="px-0 mx-0 activeable"></div>
						</div>
						<div class="col-10 mx-0 p-0">
							<div class="side-nav-text   m-0  py-2 px-1 "
								onclick='location.href="/admin/user/?nav=user"'>
								<i class="bi bi-person"></i> 유저 관리
							</div>

						</div>
					</div>
					<!-- 링크 박스 끝-->

					<hr class="mx-0 my-0 p-0 side-hr">
					<!-- 링크 박스 -->
					<div id="nav-history" class="row side-nav">
						<div class="px-0 mx-0 col">
							<div class="px-0 mx-0 activeable"></div>
						</div>
						<div class="col-10 mx-0 p-0">
							<div class="side-nav-text   m-0  py-2 px-1 "
								onclick='location.href="/admin/history/?nav=history"'>
								<i class="bi bi-card-checklist"></i> 기록 관리
							</div>

						</div>
					</div>
					<!-- 링크 박스 끝-->

					<hr class="mx-0 my-0 p-0 side-hr">
					<!-- 링크 박스 -->
					<div id="nav-item" class="row side-nav">
						<div class="px-0 mx-0 col">
							<div class="px-0 mx-0 activeable"></div>
						</div>
						<div class="col-10 mx-0 p-0">
							<div class="side-nav-text   m-0  py-2 px-1 "
								onclick='location.href="/admin/item/?nav=item"'>
								<i class="bi bi-box-seam"></i> 아이템 관리
							</div>

						</div>
					</div>
					<!-- 링크 박스 끝-->
					<hr class="mx-0 my-0 p-0 side-hr">
				</div>
				<!-- 그룹 박스 끝 -->
			</c:if>

			<c:if test="${sessionScope.admin.forest eq 'Y' }">
				<!-- 그룹 박스 -->
				<div class="mt-5">
					<p class="my-0 mx-2 left-side-th">forest control</p>
					<hr class="mx-0 my-0 p-0 side-hr">
					<!-- 링크 박스 -->
					<div id="nav-forest" class="row side-nav">
						<div class="px-0 mx-0 col">
							<div class="px-0 mx-0 activeable"></div>
						</div>
						<div class="col-10 mx-0 p-0">
							<div class="side-nav-text   m-0  py-2 px-1 "
								onclick='location.href="/admin/forest/?nav=forest"'>
								<i class="bi bi-tree"></i> 숲 관리
							</div>

						</div>
					</div>
					<!-- 링크 박스 끝-->

					<hr class="mx-0 my-0 p-0 side-hr">
					<!-- 링크 박스 -->
					<div id="nav-plants" class="row side-nav">
						<div class="px-0 mx-0 col">
							<div class="px-0 mx-0 activeable"></div>
						</div>
						<div class="col-10 mx-0 p-0">
							<div class="side-nav-text  m-0  py-2 px-1 "
								onclick='location.href="/admin/plants/?nav=plants"'>
								<i class="bi bi-flower2"></i> 식물 관리
							</div>

						</div>
					</div>
					<!-- 링크 박스 끝-->

					<hr class="mx-0 my-0 p-0 side-hr">
				</div>
				<!-- 그룹 박스 끝 -->
			</c:if>

			<c:if test="${sessionScope.admin.other eq 'Y' }">
				<!-- 그룹 박스 -->
				<div class="mt-5">
					<p class="my-0 mx-2 left-side-th">other control</p>
					<hr class="mx-0 my-0 p-0 side-hr">
					<!-- 링크 박스 -->
					<div id="nav-state" class="row side-nav">
						<div class="px-0 mx-0 col">
							<div class="px-0 mx-0 activeable"></div>
						</div>
						<div class="col-10 mx-0 p-0">
							<div class="side-nav-text   m-0  py-2 px-1 "
								onclick='location.href="/admin/state/?nav=state"'>
								<i class="bi bi-chat-right-text"></i> 상태 관리
							</div>

						</div>
					</div>
					<!-- 링크 박스 끝-->

					<hr class="mx-0 my-0 p-0 side-hr">
					<!-- 링크 박스 -->
					<div id="nav-notice" class="row side-nav">
						<div class="px-0 mx-0 col">
							<div class="px-0 mx-0 activeable"></div>
						</div>
						<div class="col-10 mx-0 p-0">
							<div class="side-nav-text   m-0  py-2 px-1 "
								onclick='location.href="/admin/notice/?nav=notice"'>
								<i class="bi bi-megaphone"></i> 공지 관리
							</div>

						</div>
					</div>
					<!-- 링크 박스 끝-->

					<hr class="mx-0 my-0 p-0 side-hr">


				</div>
				<!-- 그룹 박스 끝 -->
			</c:if>

			<c:if test="${sessionScope.admin.authority eq 'Y' }">
				<!-- 그룹 박스 -->
				<div class="mt-5">
					<p class="my-0 mx-2 left-side-th">authority control</p>
					<hr class="mx-0 my-0 p-0 side-hr">
					<!-- 링크 박스 -->
					<div id="nav-authority" class="row side-nav">
						<div class="px-0 mx-0 col">
							<div class="px-0 mx-0 activeable"></div>
						</div>
						<div class="col-10 mx-0 p-0">
							<div class="side-nav-text   m-0  py-2 px-1 "
								onclick='location.href="/admin/authority/?nav=authority"'>
								<i class="bi bi-chat-right-text"></i> Admin 관리
							</div>

						</div>
					</div>
					<!-- 링크 박스 끝-->

					<hr class="mx-0 my-0 p-0 side-hr">

				</div>
				<!-- 그룹 박스 끝 -->
			</c:if>
		</nav>

	</div>

</div>