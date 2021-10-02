<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../include/head.jsp"></jsp:include>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>admin</title>
<jsp:include page="../include/head.jsp"></jsp:include>

<script type="text/javascript">
	$(function() {
		$("div[data-url='department']").trigger("click")

	})//on load 끝
</script>
<style type="text/css">
</style>
</head>
<body>
	<div class="container-fluid">
		<!-- 풀스크린  -->
		<header class="header border-bot">
			<div class="row">
				<div class="col-1"></div>
				<div class="col-1 mt-3">
					<a href="../../"> <img class="logo" alt="logo"
						src="/resources/image/need/logo_1.png">
					</a>
				</div>
				<div class="col-8"></div>
				<div class="col-2 mt-5"></div>
				<!-- </div> -->
			</div>
		</header>
		<div class="row row-cols-3">
			<!--오른쪽 사이드 바 -->
			<div class="col-2">
				<div class="list-group mt-2">
					<div class="mainIndex list-group-item row">
						<!-- <div class="col-1"></div> -->
						<div class="col">
							<strong>제품</strong>
						</div>
						<div class="col-2"></div>
					</div>
					<ul style="margin: 0; padding: 0; text-align: center;">
						<li class="list-group-item"><a href="../admin/object/classify/"
							class="subIndex">분류</a></li>
						<li class="list-group-item"><a href="../admin/object/reason/"
							class="subIndex">인증사유</a></li>
						<li class="list-group-item"><a href="../admin/object/productcertreason"
							class="subIndex">제품 인증 사유</a></li>
                        <li class="list-group-item"><a href="../admin/object/cert/"
                            class="subIndex">인증 구분</a></li>
                        <li class="list-group-item"><a href="../admin/object/company/"
                            class="subIndex">기업</a></li>
                        <li class="list-group-item"><a href="../admin/object/product/"
                            class="subIndex">제품</a></li>
                        <li class="list-group-item"><a href="../admin/object/datamanager/"
                            class="subIndex">database 작성</a></li>
					</ul>
				</div>

				<div class="list-group mb-2">
					<div class="mainIndex list-group-item row">
						<!-- <div class="col-1"></div> -->
						<div class="col">
							<strong>유저</strong>
						</div>
						<div class="col-2"></div>
					</div>
					<ul style="margin: 0; padding: 0; text-align: center;">
						<li class="list-group-item"><a href="../admin/users/user/"
							class="subIndex">유저 관리</a></li>
						<li class="list-group-item"><a href="../admin/users/history/"
							class="subIndex">기록 관리</a></li>
						<li class="list-group-item"><a href="../admin/users/bookmark/"
							class="subIndex">즐겨찾기 관리</a></li>
						<li class="list-group-item"><a href="../admin/users/searchList/"
							class="subIndex">검색리스트 관리</a></li>
						<li class="list-group-item"><a href="../admin/users/inven/"
							class="subIndex">인벤토리 관리</a></li>
						<li class="list-group-item"><a href="../admin/users/location/"
							class="subIndex">배치 관리</a></li>
				</div>

                <div class="list-group mb-2">
					<div class="mainIndex list-group-item row">
						<!-- <div class="col-1"></div> -->
						<div class="col">
							<strong>메시지</strong>
						</div>
						<div class="col-2"></div>
					</div>
					<ul style="margin: 0; padding: 0; text-align: center;">
						<li class="list-group-item"><a href="../admin/messege/"
							class="subIndex">식단관리</a></li>
						<li class="list-group-item"><a href="../admin/menu/"
							class="subIndex">메뉴관리</a></li>
						<li class="list-group-item"><a href="../admin/customer/"
							class="subIndex">고객관리</a></li>
						<li class="list-group-item"><a href="../admin/orders/"
							class="subIndex">주문관리</a></li>
						<li class="list-group-item"><a href="../admin/payment/"
							class="subIndex">결제관리</a></li>
						<li class="list-group-item"><a href="../admin/delivery/"
							class="subIndex">배송관리</a></li>
						<li class="list-group-item"><a href="../admin/etc/"
							class="subIndex">기타관리</a></li>
					</ul>
				</div>

                <div class="list-group mb-2">
					<div class="mainIndex list-group-item row">
						<!-- <div class="col-1"></div> -->
						<div class="col">
							<strong>숲</strong>
						</div>
						<div class="col-2"></div>
					</div>
					<ul style="margin: 0; padding: 0; text-align: center;">
						<li class="list-group-item"><a href="../admin/forests/forest/"
							class="subIndex">숲 관리</a></li>
						<li class="list-group-item"><a href="../admin/forests/plants/"
							class="subIndex">식물 관리</a></li>
					</ul>
				</div>

                <div class="list-group mb-2">
					<div class="mainIndex list-group-item row">
						<!-- <div class="col-1"></div> -->
						<div class="col">
							<strong>공지사항</strong>
						</div>
						<div class="col-2"></div>
					</div>
					<ul style="margin: 0; padding: 0; text-align: center;">
						<li class="list-group-item"><a href="../admin/diet/"
							class="subIndex">공지사항 관리</a></li>
					</ul>
				</div>

			</div>
			<div class="col-8">
				<section class="mt-4 col">
					<!-- management index 시작 -->
					<div id="leftBox" class="col-2">
						<!-- 1단 2|8|2 -->
						<div class="list-group mb-2"></div>

						<div class="mt-3"></div>


					</div>
					<!-- management index 끝  -->
					<div id="mainContent" class="col-8 center">
						<!-- 2단 2|8|2 -->
						<div class="row mb-2">
							<!--테이블 카테고리 선택상자  -->

							<div class="col-3 option" data-url="authority">
								<h5 class="center">권한관리</h5>
								<div class="bot-bar mt-2"></div>
							</div>
							<div class="col-3 option" data-url="position">
								<h5 class="center">직급</h5>
								<div class="bot-bar mt-2"></div>
							</div>
							<div class="col-3 option" data-url="department">
								<h5 class="center">부서</h5>
								<div class="bot-bar mt-2"></div>
							</div>
							<div class="col-3 option" data-url="header">
								<h5 class="center">헤더</h5>
								<div class="bot-bar mt-2"></div>
							</div>

						</div>
						<table id="mainTable" class="table">


						</table>

						<div id="pagenation">
							<ul class="pagination justify-content-center" id="pager">
								<li class="page-item"><p class="page-link pager"
										id="page-first">처음</p></li>
								<li class="page-item"><p class="page-link pager"
										id="page-prev">이전</p></li>
								<li class="page-item"><p class="page-link pager"
										id="page-0">1</p></li>
								<li class="page-item"><p class="page-link pager"
										id="page-1">2</p></li>
								<li class="page-item"><p class="page-link pager"
										id="page-2">3</p></li>
								<li class="page-item"><p class="page-link pager"
										id="page-3">4</p></li>
								<li class="page-item"><p class="page-link pager"
										id="page-4">5</p></li>
								<li class="page-item"><p class="page-link pager"
										id="page-next">다음</p></li>
								<li class="page-item"><p class="page-link pager"
										id="page-last">마지막</p></li>
							</ul>
						</div>
					</div>

				</section>
				<section class="mt-4 row">
					<!-- view 부분 2|8|2 -->
					<div id="subContent" class="col-8 center"></div>
				</section>
			</div>
			
			<div id="rightBox" class="col-2">
						<!-- 3단 2|8|2 -->
						<div class="col">
							<h3 class="center">- 관리 메뉴 -</h3>
						</div>
						<div id="talkBox"></div>
						<div class="center">

							<div class="center button">
								<button id="add" class="commonAction btn btn-success center">
									<i class="bi bi-plus-square"></i> 등 록
								</button>
							</div>

							<div class="center button">
								<button id="delete" class="commonAction btn btn-success center">
									<i class="bi bi-trash"></i> 삭 제
								</button>
							</div>

							<div class="center button">
								<button id="update" class="commonAction btn btn-success center">
									<i class="bi bi-save"></i> 수 정
								</button>
							</div>
						</div>
					</div>
			
		</div>
		
			


		<jsp:include page="../include/footer.jsp"></jsp:include>
	</div>

	<!--모달-->
	<div class="modal fade" id="commonModal" tabindex="-1"
		aria-labelledby="commonModalLabel" aria-hidden="true">
		<div
			class="modal-dialog modal-dialog-centered modal-dialog-scrollable modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="commonModalLabel">확 인 요 망</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<table id="modal-table" class="table table-striped">

					</table>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Cancel</button>
					<button type="button" class="btn btn-primary commonModal">Submit</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>