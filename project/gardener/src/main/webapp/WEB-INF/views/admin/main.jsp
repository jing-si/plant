<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>admin</title>
<jsp:include page="../include/head.jsp"></jsp:include>
<script type="text/javascript">
	$(function() {
		$("div[data-url='authority']").trigger("click")

	})//on load 끝
</script>
<style type="text/css">
	#align{
	    width: 550px;
	    margin: 0 auto;
	    position: relative;
	    display: inline-block;
	}
	#mainContent #logo{
	    /* width: 70px; */
	    /* height: 115.1px; */
	    height: 150px;
	    /* margin: 148px auto 30.9px 0; */
	    margin-top: 148px;
	    display: inline-block;
	    float: left;
	}
	#logo img{
		height: 150px;
	}
	#inputs{
		width: 266px;
		/* float: right; */
		display: inline-block;
		/* margin-top: 148px; */
		display: inline-block;
		margin: 150px 0px 0 40px;
	}
	#inputs p{
		font-weight: bold;
	}
	input{
		
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
	#login{
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
	#login p{
	    text-decoration: none;
	    color: #fff;
	    font-size: 15px;
	    position: absolute;
	    left: 41%;
	    top: 25%;
	
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
					<div class="row row-cols-2 ">
						<!--테이블 카테고리 선택상자  -->
						<div class="col-10  hstack mx-3 pt-2 nav">
							<div class="option col-10 py-2" data-url="authority">
								<h5 class="mx-4 my-auto">일반 소비자를 위한 친환경 제품 정보제공 시스템 <span class="text-success">'가꿈'</span></h5>
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
						<div class="col-12 ">
							<section class="">
								<div id="mainContent" class="col">
									<div class="row mx-0">
										<div id="align">
											<div id="logo">
												<img src="/resources/images/login-logo.png">
											</div>
											
											<form method="post">
												<div id="inputs">
													<p>관리자 로그인</p>
													<input id="email" placeholder="아이디" type="text" name="userId">
													<input id="passWord" placeholder="비밀번호" type="password" name="userPass">
												</div>
													<input type="submit" id="login" class="border" value="로그인"></input>
											</form>
											
										</div>

									</div>
								</div>
							</section>
						</div>
						
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