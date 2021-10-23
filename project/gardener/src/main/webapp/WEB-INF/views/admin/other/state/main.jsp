<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>'가꿈' 관리자 페이지</title>
<jsp:include page="../../../include/head.jsp"></jsp:include>
<script type="text/javascript">
	$(function() {
		$("div[data-url='state']").trigger("click")

	})//on load 끝
</script>
<style type="text/css">
</style>
</head>
<body>
	<div class="container-fluid">
		<!--전체 div - 왼쪽 사이드와 메인을 나눠줌.-->
		<div class="row">
			<!--왼쪽 사이드 바 -->
			<div class="rightSide col-1  mx-0 px-0">
				<div>
				<jsp:include page="../../../include/left_side.jsp"></jsp:include>
				</div>
			</div>
			<!--왼쪽 사이드 바 끝 -->

			<!-- 오른쪽 컨텐츠 상자 - header, section, footer 3부분을 나뉘어 짐-->
			<div class="col container-custom p-0">
				<!--Header - 로고, 로그아웃, option-->
				<header class="header border-bot">
					<div class="row mx-0 px-0">
						<!--테이블 카테고리 선택상자  -->
						<div class="col-10  ms-3 pt-2 nav">
							<div class="option col-2 pt-2 pb-3" data-url="state">
								<h5 class="center"><i class="bi"></i> 상태 관리</h5>
							</div>
							<div class="option col-2 pt-2 pb-3" data-url="randomMessage">
								<h5 class="center"><i class="bi"></i> 랜덤 메시지 관리</h5>
							</div>
							
						</div>
						<div class="col">
							<jsp:include page="../../../include/logout.jsp"></jsp:include>
						</div>

					</div>
				</header>
				<!--Header - end -->

				<!--메인 페이지 - mainContent, main-side, subContent sub-side-->
				<div class="m-2">
					<!-- mainContent 영역 -search, mainContent, main-side -->
					<div class="row me-0">
						<div class="col-11 pe-2">

							<!--검색, 엑셀 행 -->
							<div class="row row-cols-2 mb-2 mx-0 p-0 g-0">
								<!--검색 -->
								<div class="col-10">
									<div class="input-group">
										<button id="searchCode"
											class="border-ccc btn btn-outline-secondary dropdown-toggle"
											type="button" data-bs-toggle="dropdown" aria-expanded="false">전 체</button>
										<ul id="searchCode-list" class="dropdown-menu">
											<li><button class="dropdown-item searchCode-btn" data-name="total">전 체</button></li>
											<li><hr class="dropdown-divider"></li>
											
										</ul>
										<div id="searchStart"></div>
										<input id="q" type="text" class="form-control" placeholder="Search"
											aria-label="Username">
										<div id="init-search" class="py-1 px-2 m-0 hide"><i class="bi bi-x-lg"></i></div>
										<span class="input-group-text" id="search"><i
											class="bi bi-search"></i></span>
									</div>
								</div>
								<!--검색 끝 -->
								<!--엑셀 다운로드  -->
								<div class="col-2 row mx-0 px-0">
									<button
										class="col ms-2 btn btn-light bg-white border border-ccc">
										<i class="bi bi-file-earmark-arrow-down"></i> 엑셀 다운로드
									</button>
								</div>
								<!--엑셀 다운로드 끝-->
							</div>
							<!--검색 엑셀 -end  -->
							<section class="">
								<div id="mainContent" class="col">

									<div class="row mx-0">

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
								</div>
							</section>
						</div>
						<!--main-rightBox start-->
						<div id="main-side" class="col-1 content-side p-0 m-0">
							<!-- 3단 2|8|2 -->
							<div class="col side-th">
								<h5 class="center py-2">
									<i class="bi bi-wrench"></i> 관리 메뉴
								</h5>
							</div>
							<div id="talkBox"></div>
							<div class="center">
								<hr class="mx-2 my-0 p-0">
								<div id="add" class="center button commonAction py-2 ">
									<i class="bi bi-plus-square"></i> 등 록
								</div>
								<hr class="mx-2 my-0 p-0">
								<div id="delete" class="commonAction center button  py-2">
									<i class="bi bi-trash"></i> 삭 제
								</div>
								<hr class="mx-2 my-0 p-0">
								<div id="update" class="commonAction center button  py-2">
									<i class="bi bi-save"></i> 수 정
								</div>
								<hr class="mx-2 my-0 p-0">
							</div>
						</div>
						<!--main-rightBox end  -->

					</div>
					<!--mainContent 영역 - end  -->

					<!--subContent 영역-->
					<div class="row my-2 ms-0 row-cols-2">
						<!--sub-side 바 -->
						<div id="sub-side" class="col-1 content-side">
							
							
						</div>
						<!--subside end-->

						<!--subContent-->
						<section class="col-11 ps-2">

							<div id="subContent" class="col"></div>
						</section>
						<!--subContent - end-->

					</div>
					<!--subContent - end -->

				</div>
				<!-- 메인 페이지 - end -->

				<!--footer include -->
				<jsp:include page="../../../include/footer.jsp"></jsp:include>
			</div>
			<!--오른쪽 컨텐츠 상자 - end -->
		</div>
		<!-- 전체 div - end -->
	</div>
	<!--container - end  -->

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