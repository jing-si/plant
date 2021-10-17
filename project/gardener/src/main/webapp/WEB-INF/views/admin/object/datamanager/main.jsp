<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>'가꿈' 관리자 페이지</title>
<jsp:include page="../../../include/head.jsp"></jsp:include>
<style type="text/css">
#tab {
	height: 200px;
	overflow: auto;
}

#company_nav ul {
	margin: 0px;
}

#company_nav ul li {
	display: inline-block;
	font-size: 20px;
	text-align: center;
	padding: 0px 10px;
}

.nav_icon:hover {
	background-color: #ccc;
	cursor: pointer;
}

.api {
	border: 1px solid #ccc;
	height: 500px;
	overflow: auto;
}

.company_span {
	height: 3px;
	width: 80%;
	margin: 5px auto;
}

.hide {
	display: none;
}

.black {
	background-color: black;
}

input[type="number"]::-webkit-outer-spin-button, input[type="number"]::-webkit-inner-spin-button
	{
	-webkit-appearance: none;
	margin: 0;
}

header h2 {
	display: block;
	padding: 15px 20px;
}

.company_but {
	width: 20%;
}

label {
	margin: 5px;
}

.inlineBlock {
	display: inline-block;
}

#product {
	float: right;
}

.company {
	float: left;
}

.full {
	width: 100%;
}

#mid {
	height: 500px;
}

.vertical {
	margin-top: auto;
	margin-bottom: auto;
}

.textcenter {
	text-align: center;
}

.overflow {
	overflow: auto;
}

.overflow_hidden {
	overflow: hidden;
}

.tabTH {
	border-bottom: 1px solid #ccc;
}

.colorbbb {
	background-color: #bbb;
}

#function_btn {
	clear: both;
	width: 100%;
	height: 80px;
	border: 1px solid black;
	box-sizing: content-box;
}

.detail {
	min-height: 700px;
	margin: auto;
}

.detail h2 {
	padding: 10px 20px;
	border-bottom: 1px solid #ccc;
	margin-bottom: 20px;
}

#product_ditail {
	float: right;
	position: relative;
}

.productImage{
	border: 1px solid #ccc;
	max-height: 252px;
	max-width: 252px;
		
}

#product_ditail>div:first-of-type {
	position: absolute;
	bottom: 0;
	left: 0;
	height: 89%;
}

#product_ditail>div:last-child {
	position: absolute;
	bottom: 0;
	right: 0;
	height: 89%;
}

#product_ditail>div div {
	margin: 15px;
	position: relative;
	width: auto;
}

#company_ditail div div {
	margin-left: 30px;
	
}


</style>
<script>
		let companyArr = new Array();
		let productArr = new Array();
		
		$().ready(() => {
			//api, db 버튼의 행동
			$("div[data-url='#']").trigger("click")
			
			$(".nav_icon").click(function () {
				event.preventDefault
				$(this).parent().children().children().removeClass("black");
				$(this).children().addClass("black");

				$("." + $(this).data("sub") + "Form").addClass("hide");
				$("#" + $(this).data("sub") + $(this).data("kind") + "Form").removeClass("hide");
			})

			//회사 api 날짜 기준 검색
			$("#company_api_but").click(() => {
				const start = $("#company_start_day").val();
				const end = $("#company_end_day").val();
				let url = "/admin/datamanager/list";
				url += "/" + start;
				url += "/" + end;

				$("#company_api_tbody").empty()
				let tr = $('<tr class="selectRow">');
				let th1 = $('<th scope="row" class="full textcenter overflow">')
					.text("제품 검색을 시작합니다.")
				tr.append(th1);
				$("#company_api_tbody").append(tr)

				$.ajax({
					url: url,
					success: function (data) {
						companyArr = data;
						makeCompanyList("api");
					}
				});

			});
			
			//db검색 버튼
			$("#company_db_but").click(()=>{
				$.ajax({
					url: "/admin/datamanager/companylist/db",
					success:function(data){
						companyArr = data;
						makeCompanyList("db");
					}
				})
				
			})
			
			

			//product api 날짜 기준 검색
			$("#product_api_but").click(() => {
				const start = $("#product_start_day").val();
				const end = $("#product_end_day").val();
				let url = "/admin/datamanager/productlist";
				url += "/" + start;
				url += "/" + end;
				
				$("#product_api_tbody").empty()
				let tr = $('<tr class="selectRow">');
				let th1 = $('<th scope="row" class="full textcenter overflow">')
					.text("제품 검색을 시작합니다.")
				tr.append(th1);
				
				$("#product_api_tbody").append(tr)
				$.ajax({
					url: url,
					success: function (data) {
						productArr = data;
						makeProductList();

					},
					error: function (data) {
						console.log(data);
						productArr = new Array();
						makeProductList();
					}
				});

			});




			//회사 선택시 행동
			$(".company_tbody").on("click", ".selectRow", function () {
				$(".selectRow").removeClass("colorbbb");
				$(this).addClass('colorbbb');
				let company = companyArr[$(this).data("index")]
				$("#companyId").val(company.companyId);
				$("#companyName").val(company.companyName);
				$("#companyHomepage").val(company.companyHomepage);
				$("#companyAddress").val(company.companyAddress);
				$("#companyTel").val(company.companyTel);

			})
		
			//제품 선택시 행동
			$("#product_api_tbody").on("click", ".selectRow", function () {
				$(".selectRow").removeClass("colorbbb");
				$(this).addClass('colorbbb');
				let product = productArr[$(this).data("index")]
				makeProductDetail(product)

			})

			//중간 녹색 화살표
			$("#arrow").click(function () {
				let companyId = $("#companyId").val()
				
				$("#product_api_tbody").empty()
				let tr = $('<tr class="selectRow">');
				let th1 = $('<th scope="row" class="full textcenter overflow">')
					.text("제품 검색을 시작합니다.")
				tr.append(th1);
				
				$.ajax({
					url: "/admin/datamanager/productlist/" + companyId,
					success: function (data) {
						productArr = data;
						console.log(data)
						makeProductList();
					},
					error: function (data) {				
						productArr = new Array();
						makeProductList();
					}
				})

			})

			//제품 대량 등록
			$("#bulk_product_update").click(()=>{
				let company = {
						companyId : $("#companyId").val(),
						companyName : $("#companyName").val(),
						companyTel : $("#companyTel").val(),
						companyAddress : $("#companyAddress").val(),
						companyHomepage : $("#companyHomepage").val()
				}
				
				$.ajax("/admin/company/existCompany",{					
					data:JSON.stringify(company),					
					contentType: 'application/json',					
					method:"POST",					
					success: function(data){
						uploadProduct();
					}
				})
				
				
			})


		}); //window on ready 끝
		//제품 대량 등록
		function uploadProduct() {
			$.ajax("/admin/datamanager/add/apiproduct",{					
				data:JSON.stringify({list:productArr}),					
				contentType: 'application/json',
				type:"POST",					
				success: function(data){
					$("#product_api_tbody").empty()
					let tr = $('<tr class="selectRow">');
					let th1 = $('<th scope="row" class="full textcenter overflow">')
							.text("등록이 완료 되었습니다.")
					tr.append(th1);
					$("#product_api_tbody").append(tr)
				}
			})
		}
		
		//회사 등록
		
		
		//회사 행을 뿌려주는 함수
		function makeCompanyList(point){	
			
			$("#company_"+point+"_tbody").empty()
			companyArr.forEach((value, index) => {
				let tr = $('<tr class="selectRow">').data("index", index);
				let th1 = $(
						'<th scope="row" class="col-1 textcenter overflow">')
					.text(index + 1)
				let td2 = $('<td class="col-4 textcenter overflow">').text(
					value.companyId)
				let td3 = $('<td class="col-5 textcenter overflow">').text(
					value.companyName)
				let td4 = $('<td class="col-2 textcenter overflow">')
				tr.append(th1).append(td2).append(td3).append(td4)
				$("#company_"+point+"_tbody").append(tr)

			});
			
		}
		//제품의 행을 뿌려주는 함수
		function makeProductList() {
			$("#product_api_tbody").empty()
			if (productArr.length === 0) {
				let tr = $('<tr class="selectRow">');
				let th1 = $('<th scope="row" class="full textcenter overflow">')
					.text("검색 되는 제품이 하나도 없습니다.")
				tr.append(th1);
				$("#product_api_tbody").append(tr)
			}
			productArr.forEach((value, index) => {
				let tr = $('<tr class="selectRow">').data("index", index);
				let th1 = $('<th scope="row" class="col-1 textcenter overflow">')
					.text(index + 1)
				let td2 = $('<td class="col-3 textcenter overflow">')
					.text(value.productId)
				let td3 = $('<td class="col-4 textcenter overflow">')
					.text(value.productName)
				let td4 = $('<td class="col-3 textcenter overflow">')
					.text(value.certId)
				let td5 = $('<td class="col-1 textcenter overflow">')
				tr.append(th1).append(td2).append(td3).append(td4).append(td5);
				$("#product_api_tbody").append(tr)

			});
		}

		//제품 상세정보 뿌려주는 함수
		function makeProductDetail(product){
				console.log(product);
				let url;
				if(product.productId != "")
				url = "http://data.greenproduct.go.kr/openProductImage.do?prodProd="+product.productId +"&prod_img_size=250"
				$("#productName").val(product.productName);
				$("#productSize").val(product.productSize);
				$("#certName").val(product.certName);
				$("#prodInrs").val(product.prodInrs);
				$("#elId").val(product.elId);
				$("#productInfo").val(product.productInfo);
				if(product.provimg != null)
				$("#productImage").attr("src",product.productImage);

				$("#productId").val(product.productId);
				$("#productCompanyId").val(product.companyId);
				$("#productStartDate").val(product.productStartDate);
				$("#productEndDate").val(product.productEndDate);
				$("#productImage").val(product.productImage);
				$("#productImageWeb").attr("src",url);
				
		}

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
					<div class="row row-cols-2 mx-0 px-0">
						<!--테이블 카테고리 선택상자  -->
						<div class="col-10  hstack mx-3 pt-2 nav">
							<div class="option col-3 pt-2 pb-3" data-url="#">
								<h5 class="center"><i class="bi"></i> Database 관리자</h5>
							</div>


						</div>
						<div class="col-1 ">
							<a href="#">log out</a>
						</div>

					</div>
				</header>
				<!--Header - end -->

				<!--메인 페이지 - mainContent, main-side, subContent sub-side-->
				<div class="m-2">
					<!-- mainContent 영역 -search, mainContent, main-side -->
					<div class="row me-0">
						<div class="col-11 pe-2">

							<section class="">
								<div id="mainContent" class="col">
									<div class="row row-cols-3 mx-0 my-2 p-0">
										<!--회사-->
										<div class="col-5">
											<!-- 상단 선택바 -->
											<div id="company" class="col-12 company">
												<div id="company_nav">
													<ul class="row">
														<li class="col-5"><span class=".bg-info">Company</span>
															<div class="company_span "></div></li>
														<li class="col-3 nav_icon" data-sub="company"
															data-kind="Api">API
															<div class="company_span black"></div>
														</li>
														<li class="col-3 nav_icon" data-sub="company"
															data-kind="Db">DB
															<div class="company_span "></div>
														</li>

													</ul>
												</div>

												<!-- 회사 api -->
												<div id="companyApiForm" class="col companyForm">
													<div id="company_api" class="mx-2 api p-0">
														<table class="table tabTH" border="1">
															<thead>
																<tr>
																	<th scope="col" class="col-1 textcenter">#</th>
																	<th scope="col" class="col-4 textcenter">사업자 번호</th>
																	<th scope="col" class="col-5 textcenter">상호</th>
																	<th scope="col" class="col-2 textcenter">상태</th>
																</tr>
															</thead>
														</table>
														<div id="api_data" class="overflow">
															<table class="table" border="1">
																<tbody id="company_api_tbody" class="company_tbody">

																</tbody>
															</table>
														</div>
													</div>
													<form class="col-10 center" id="company_api_form">
														<label class="col-4">조회 시작일<input type="number"
															id="company_start_day" placeholder="YYYYMMDD"
															class="input-group-text full"></label> <label
															class="col-4">조회 종료일<input type="number"
															id="company_end_day" placeholder="YYYYMMDD"
															class="input-group-text full"></label>
														<button id="company_api_but" data-sub="company"
															type="button" class="btn btn-info col-2 company_but">검색</button>
													</form>
												</div>

												<!-- 회사 db -->
												<div id="companyDbForm" class="col companyForm hide">
													<div id="company_db" class="mx-2 p-0 api">
														<table class="table tabTH" border="1">
															<thead>
																<tr>
																	<th scope="col" class="col-1 textcenter">#</th>
																	<th scope="col" class="col-4 textcenter">사업자 번호</th>
																	<th scope="col" class="col-5 textcenter">상호</th>
																	<th scope="col" class="col-2 textcenter">상태</th>
																</tr>
															</thead>
														</table>
														<div id="db_data" class="overflow">
															<table class="table" border="1">
																<tbody id="company_db_tbody" class="company_tbody">

																</tbody>
															</table>
														</div>
													</div>
													<form class="col-10 center" method="get">
														<button id="company_db_but" data-sub="company"
															type="button" class="btn btn-info col-2 company_but">검색</button>

													</form>
												</div>
											</div>

										</div>
										<!--화살표-->
										<div class="col-1">
											<div id="mid" class="col-12 d-flex align-items-center">
												<button id="arrow" class="center btn btn-success">
													<h1>→</h1>
												</button>
											</div>
										</div>
										<!--제품-->
										<div class="col-6">
											<div id="product" class="col-12">
												<div id="company_nav">
													<ul class="full">
														<li class="col-5"><span class=".bg-info">Product</span>
															<div class="company_span "></div></li>
														<li class="col-3 nav_icon" data-sub="product"
															data-kind="Api">API
															<div class="company_span black"></div>
														</li>
														
													</ul>
												</div>

												<!-- 제품 API -->
												<div id="productApiForm" class="col productForm">

													<div id="product_api" class="p-0 mx-2 api">
														<table class="table tabTH" border="1">
															<thead>
																<tr>
																	<th scope="col" class="col-1 textcenter">#</th>
																	<th scope="col" class="col-3 textcenter">제품번호</th>
																	<th scope="col" class="col-4 textcenter">제품명</th>
																	<th scope="col" class="col-3 textcenter">인증정보</th>
																	<th scope="col" class="col-1 textcenter">상태</th>
																</tr>
															</thead>
														</table>
														<div id="product_api_data" class="overflow">
															<table class="table" border="1">
																<tbody id="product_api_tbody">

																</tbody>
															</table>
														</div>
													</div>

													<form class="col-10 center">
														<label class="col-4 vertical">조회 시작일<input
															type="number" id="product_start_day"
															placeholder="YYYYMMDD" class="input-group-text full"></label>
														<label class="col-4 vertical">조회 종료일<input
															type="number" id="product_end_day" placeholder="YYYYMMDD"
															class="input-group-text full"></label>
														<button id="product_api_but" data-sub="product"
															type="button" class="btn btn-info col-2 vertical">검색</button>
													</form>
												</div>

												<!-- 제품 DB -->
												<div id="productDbForm" class="productForm hide">
													<div id="product_api" class="full api"></div>
													<form class="col-10 center" method="get"></form>
												</div>

											</div>

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
								<div id="bulk_update" class=" center button  py-2 ">
									<i class="bi bi-plus-square"></i> 기업 등록
								</div>
								<hr class="mx-2 my-0 p-0">
								<div id="bulk_product_update" class=" center button  py-2">
									<i class="bi bi-trash"></i> 제품 등록
								</div>
								<hr class="mx-2 my-0 p-0">
								<div id="update" class=" center button  py-2">
									<i class="bi bi-save"></i> 수 정
								</div>
								<hr class="mx-2 my-0 p-0">
							</div>
						</div>
						<!--main-rightBox end  -->

					</div>
					<!--mainContent 영역 - end  -->

					<!--subContent 영역-->
					<div class="row my-2">

						<!--subContent-->
						<section class="col-12">

							<div id="subContent" class="col-12">
								<div class="row row-cols-2">
									<div class="col-4">
										<!-- 회사 상세 페이지-->
										<div id="company_ditail" class="detail col-12">
											<h2>기업 상세 정보</h2>

											<div class="col-10">
												<div class="input-group mb-4">
													<span class="input-group-text col-4">사업자 번호</span> <input
														type="text" class="form-control" id="companyId">
												</div>
												<div class="input-group mb-4">
													<span class="input-group-text col-4 textcenter">상 호</span>
													<input type="text" class="form-control" id="companyName">
												</div>
												<div class="input-group mb-4">
													<span class="input-group-text col-4 textcenter">전화번호</span>
													<input type="text" class="form-control" id="companyTel">
												</div>
												<div class="input-group mb-4">
													<span class="input-group-text col-4 textcenter overflow">주
														소</span> <input type="text" class="form-control"
														id="companyAddress">
												</div>
												<div class="input-group mb-4">
													<span class="input-group-text col-4 textcenter">홈페이지</span>
													<input type="text" class="form-control"
														id="companyHomepage">
												</div>
											</div>
										</div>

									</div>
										<!-- 공백-->
										<div class="col-1">
										
										</div>									
									<div class="col-7">
										<!-- 제품 상세 페이지-->
										<div id="product_ditail" class="detail col-12">
											<h2>제품 상세 정보</h2>
											<div class="col-6">
												<div class="input-group mb-4">
													<span class="input-group-text col-4">제품명</span> <input
														type="text" class="form-control" id="productName">
												</div>
												<div class="input-group mb-4">
													<span class="input-group-text col-4 textcenter">규격</span> <input
														type="text" class="form-control" id="productsize">
												</div>
												<div class="input-group mb-4">
													<span class="input-group-text col-4 textcenter">인증현황</span>
													<input type="text" class="form-control" id="certName">
												</div>
												<div class="input-group mb-4">
													<span class="input-group-text col-4 textcenter">인증사유</span>
													<input type="text" class="form-control" id="prodInrs">
												</div>
												<div class="input-group mb-4">
													<span class="input-group-text col-4 textcenter">EL번호</span>
													<input type="text" class="form-control" id="elId">
												</div>
												<div class="input-group mb-4">
													<span class="input-group-text col-4 textcenter">제품 정보</span>
													<input type="text" class="form-control" id="productInfo">
												</div>
												<div class="input-group mb-4">
													<img alt="" src="" id="productImage" class="productImage">
												</div>
											</div>
											<div class="col-6">
												<div class="input-group mb-4">
													<span class="input-group-text col-4">제품 번호</span> <input
														type="text" class="form-control" id="productId">
												</div>
												<div class="input-group mb-4">
													<span class="input-group-text col-4 textcenter">사업자
														번호</span> <input type="text" class="form-control"
														id="productCompanyId">
												</div>
												<div class="input-group mb-4">
													<span class="input-group-text col-4 textcenter">인증시작일</span>
													<input type="text" class="form-control"
														id="productStartDate">
												</div>
												<div class="input-group mb-4">
													<span class="input-group-text col-4 textcenter">인증만료일</span>
													<input type="text" class="form-control" id="productEndDate">
												</div>
												<div class="input-group mb-4">
													<span class="input-group-text col-4 textcenter">제품
														이미지</span> <input type="text" class="form-control"
														id="productImage">
												</div>
												<div class="input-group mb-4">
													<img alt="" src="" id="productImageWeb" class="productImage">
												</div>
											</div>
										</div>

									</div>
								</div>
							</div>
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