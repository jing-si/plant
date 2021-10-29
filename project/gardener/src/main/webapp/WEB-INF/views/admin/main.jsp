<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>'가꿈' 관리자 페이지</title>
<jsp:include page="../include/head.jsp"></jsp:include>
<script type="text/javascript">
	$(function() {
		$("div[data-url='#']").trigger("click")
		
		
		<c:if test="${!empty msg}">
			alert("${msg}")
		</c:if>
		
		
	})//on load 끝
	
	
</script>

<style type="text/css">
#align {
	width: 550px;
	margin-left: 300px;
	position: relative;
	display: inline-block;
}

#mainContent #logo {
	/* width: 70px; */
	/* height: 115.1px; */
	height: 150px;
	/* margin: 148px auto 30.9px 0; */
	margin-top: 148px;
	display: inline-block;
	float: left;
}

#logo img {
	height: 150px;
}

#inputs {
	width: 266px;
	/* float: right; */
	display: inline-block;
	/* margin-top: 148px; */
	display: inline-block;
	margin: 150px 0px 0 40px;
}

#inputs p {
	font-weight: bold;
}

input {
	width: 266px;
	height: 45px;
	margin-bottom: 20px;
	position: relative;
	background-color: #f5f5f5;
	border-radius: 4px;
	border: 0px;
	padding: 12px;
	padding-right: 20px;
}

#login {
	/* margin-top: 148px; */
	width: 100px;
	height: 110px;
	text-align: center;
	background-color: #66bb6a;
	float: right;
	/* background-color: 4px; */
	/* position: relative; */
	/* vertical-align: top; */
	display: inline-block;
	margin-top: 190px;
	color: #fff;
}

#login p {
	text-decoration: none;
	color: #fff;
	font-size: 15px;
	position: absolute;
	left: 41%;
	top: 25%;
}

#mainContent {
	/* background-image: url("/resources/image/need/B2.jpg"); */
	background-repeat: no-repeat;
	background-size: cover;
	height: 900px;
}

.option {
	border-radius: 5px;
}
</style>
</head>
<body>
	<div class="container-fluid">
		<!--전체 div - 왼쪽 사이드와 메인을 나눠줌.-->
		<div class="row">
			<!--왼쪽 사이드 바 -->
			<div class="rightSide col-1  mx-0 px-0">
				<div>
					<jsp:include page="../include/left_side.jsp"></jsp:include>
				</div>
			</div>
			<!--왼쪽 사이드 바 끝 -->

			<!-- 오른쪽 컨텐츠 상자 - header, section, footer 3부분을 나뉘어 짐-->
			<div class="col container-custom p-0">
				<!--Header - 로고, 로그아웃, option-->
				<header class="header border-bot">
					<div class="row mx-0 px-0">
						<!--테이블 카테고리 선택상자  -->
						<div class="col-10 ms-3 pt-2 nav">
							<div class="option col-8 pt-2 pb-2" data-url="#">
								<h5 class="mx-4 my-auto">
									<i class="bi bi-droplet"></i> 일반 소비자를 위한 친환경 제품 정보제공 시스템 <span
										class="text-success">'가꿈'</span>
								</h5>
							</div>
						</div>
						<div class="col">
							<jsp:include page="../include/logout.jsp"></jsp:include>
						</div>

					</div>
				</header>
				<!--Header - end -->

				<!--메인 페이지 - mainContent, main-side, subContent sub-side-->
				<div class="m-2">
					<!-- mainContent 영역 -search, mainContent, main-side -->
					<div class="row me-0">
						<div class="col-12 ">
							<section class="">
								<div id="mainContent" class="col">
									<div class="row mx-0">
										<c:if test="${empty sessionScope.admin }">
											<div id="align">
												<div id="logo">
													<!-- 	<img src="/resources/images/login-logo.png"> -->
												</div>

												<form method="post">

													<div id="inputs">
														<fieldset>
															<legend>관리자 로그인</legend>
															<input id="email" placeholder="아이디" type="text"
																name="adminId"> <input id="passWord"
																placeholder="비밀번호" type="password" name="adminPass">
														</fieldset>
														
													</div>
													<input type="submit" id="login" class="border" value="로그인"></input>

												</form>

											</div>
										</c:if>
										<c:if test="${!empty sessionScope.admin }">
											<div id="align" class="mt-5 mx-3">
												<h2>${sessionScope.admin.adminName }님안녕하세요.</h2>
											</div>
											<div class="m-3 p-5">
												<h5>
													<span class="text-success">'가꿈'</span>의 관리자 시스템은 1920px에서
													브라우저 배율 90% 일때 가장 보기 편합니다.
												</h5>
												<p>해상도가 낮을 경우 배율을 낮추시면 좀더 보기 편합니다.</p>
											</div>
										</c:if>
									</div>
								</div>
							</section>
						</div>

					</div>
					<!--mainContent 영역 - end  -->



				</div>
				<!-- 메인 페이지 - end -->

				<!--footer include -->
				<jsp:include page="../include/footer.jsp"></jsp:include>
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