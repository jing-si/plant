<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700;800&family=Noto+Sans+KR:wght@400;700;900&display=swap" rel="stylesheet">

    <script src="/resources/js/test.js"></script>
    <%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/css/category.css"> --%>
    <!-- <link rel="stylesheet" href="/resources/css/category.css"> -->
    <script src="/resources/js/jquery.min.js"></script>
    <script src="/resources/js/indigo.min.js"></script>
    
    
    <style>
.hide{
	display:none;
}






*{margin:0; padding:0;}

#title{width: 72px;
    position: absolute;
    height: 28px;
    left: 50%;
    top: 10px;
    transform: translate(-50%);
    font-family: NotoSansKR;
  font-size: 18px;
  font-weight: bold;
  font-stretch: normal;
  font-style: normal;}
ul{list-style:none;}
a{text-decoration:none; color:#333;}
.wrap{padding:15px; letter-spacing:-0.5px; padding-top: 55px;}
.tab_menu{position:relative;}
.tab_menu .list{overflow:hidden;}
.tab_menu .list li{display: inline-block;
    height: 100%;
    width: 33%;}
/* .tab_menu .list li p{width: 100px;
    margin: 0 auto;
    padding-bottom: 8.5px;
    font-size: 15px;} */
.tab_menu .list li .btn-title{
    text-align: center;
    padding-bottom: 9px;
}
.tab_menu .list .btn{font-size:13px;}
.tab_menu .list .cont{display:none; position:absolute; left:0; width:100%;}
.tab_menu .list li.is_on .btn{font-weight:bold; color:green;}
.tab_menu .list li.is_on .cont{display:block;}
.tab_menu .list li.is_on span{
    display: block;
    margin: 5px 0 0 0;
    width: 100%;
    height: 5px;
    background: black;
}


*{
    padding: 0;
    margin: 0;
    list-style: none;
    box-sizing: border-box;
    font-family: 'Noto Sans KR', sans-serif;
}


#product-body{
    /* border: 1px solid red; */
    width: 330px;
    height: calc(100vh - 45px - 56px - 9px);
    /* 100 - 헤더 - 공통메뉴 - btn-title 밑마진 */
    margin: 0 auto;
    position: relative;
    /* position: absolute; */
    /* left: 50%; */
    /* transform: translate(-50%); */
}
#product-subtitle{
    width: 100%;
    height: 48px;
    position: relative;
    border-bottom: 1px solid #f5f5f5;
    margin-top: 10px;
}
#product-subtitle p{
    text-align: left;
    position: absolute;
    top: 15px;
    left: 30px;
    font-size: 14px;
}
#product-subtitle svg{
    position: absolute;
    top: 16px;
    right: 16px;
    opacity: 0.5;
}
.product-subtitle-sub-box{
    width: 100%;
}
.product-subtitle-sub{
    width: 100%;
    background-color: #f5f5f5;
    padding-top: 10px;
    padding-left: 28px;
    padding-bottom: 10px;
    font-size: 12px;
}



#brand-body{
    /* border: 1px solid red; */
    width: 330px;
    height: calc(100vh - 45px - 56px - 9px);
    /* 100 - 헤더 - 공통메뉴 - btn-title 밑마진 */
    margin: 0 auto;
    position: relative;
}
.brand-subtitle{
    width: 100%;
    height: 48px;
    position: relative;
    border-bottom: 1px solid #f5f5f5;
    margin-top: 10px;
}
.brand-subtitle p{
    text-align: left;
    position: absolute;
    top: 15px;
    left: 30px;
    font-size: 14px;
}
.brand-subtitle svg{
    position: absolute;
    top: 16px;
    right: 16px;
    opacity: 0.5;
}


#mark-body{
    width: 321px;
            height: calc(100vh - 83.5px - 56px);
            /* 100 - 헤더 - 공통메뉴바 */
            margin: 0 auto;
            position: relative;
}
/* 리스트 한상자 */
.mark{
    width: 62px;
    height: 88px;
    display: inline-block;
    margin: 22.5px;
}
.mark .mark-img{
    width: 62px;
    height: 62px;
    background-color: #afafaf;
    border-radius: 20px;
    
}
.mark .mark-name{
    margin: 2px;
    text-align: center;
    font-family: NotoSansKR;
    color: #afb3bc;
    font-size: 13px;
    font-weight: bold;
    font-stretch: normal;
    font-style: normal;
}





/* #product-body a{
	display : none;
} */





/* 공통메뉴바 */
.sticky{
    position: fixed;
    bottom: 0;
    width: 100%;
    height: 56px;
    background-color: #66bb6a;
}
.sticky div{
    display: inline-block;
    color: white;
    text-align: center;
    width: 20%;
    height: 100%;
    margin: 0;
    position: relative;
    font-size: 11px;
}
.sticky svg{
    /* position: absolute; */
    /* top: 6.3px; */
    /* left: 25px; */
    margin: auto 0;
    margin-top: 6.3px;
}
.sticky p{
    margin: auto 0;
    /* margin-top: 28.3px; */
    margin-top: 0px;
}
</style>
    
</head>
<body>
<script>

$().ready(()=>{
	$(".menu-toggle-btn").click(function(){
		$(".gnb").addClass("hide");
		$(".i"+$(this).data("index")).removeClass("hide")
	})
})
</script>

  <div id="title"><p>카테고리</p></div>
    <div class="wrap">
        <div class="tab_menu">
          <ul class="list">

            <li class="is_on">
              <a href="#tab1" class="btn"><p class="btn-title">품목</p><span id="bar"></a>
                <div id="tab3" class="cont">
                <div id="product-body">
                  
                  	<c:forEach var="list" items="${productCategoryList}">
                  	<div id="categoryBundle">
                  		<div id="product-subtitle" class="menu-toggle-btn" data-index="${list.productCategoryId}">
                  			<p>${list.productCategoryName}</p>
                  			<svg xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 0 24 24" width="24px" fill="#000000"><path d="M24 24H0V0h24v24z" fill="none" opacity=".87"/><path d="M16.59 8.59L12 13.17 7.41 8.59 6 10l6 6 6-6-1.41-1.41z"/></svg>
                  		</div>
                  		<c:forEach var="item" items="${list.midList}">
							<a href="/login/category/${item.primaryId}"><div id="product-subtitle-sub-box" class="gnb hide i${list.productCategoryId }">                      		<div class="product-subtitle-sub">${item.name}</div>
                  			</div></a>
                  		</c:forEach>
                  	</c:forEach>
               		</div>
                  </div>
              </div>
           


            </li><li>
              <a href="#tab2" class="btn"><p class="btn-title">브랜드</p><span id="bar"></a>
                <div id="tab3" class="cont">
                <div id="brand-body">
                	<c:forEach var="list" items="${brandList}">
                		<a href="brand/${list.companyId}/"><div class="brand-subtitle">
                      		<p>${list.companyName}</p>
                      		<svg xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 0 24 24" width="24px" fill="#000000"><path d="M0 0h24v24H0V0z" fill="none"/><path d="M10 6L8.59 7.41 13.17 12l-4.58 4.59L10 18l6-6-6-6z"/></svg>        
                  		</div></a>
                	</c:forEach>
                	
                	
<!-- 완성시 이부분 지우기 -->
                  <a href="brand"><div class="brand-subtitle">
                      <p>Brand 1</p>
                      <svg xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 0 24 24" width="24px" fill="#000000"><path d="M0 0h24v24H0V0z" fill="none"/><path d="M10 6L8.59 7.41 13.17 12l-4.58 4.59L10 18l6-6-6-6z"/></svg>        
                  </div></a>
<!-- 여기까지 -->
              </div>
              </div>
            


            </li><li>
              <a href="#tab3" class="btn"><p class="btn-title">인증마크</p><span id="bar"></a>
              <div id="tab3" class="cont">
                <div id="mark-body">
                	<c:forEach var="list" items="${markList}">
                		<a href="mark/${list.markId}/"><div class="mark">
                      		<div class="mark-img">${list.markImg}</div>
                      		<div class="mark-name">${list.markName}</div>
                  		</div></a>
                	</c:forEach>
                	
<!-- 완성시 이부분 지우기 -->
                  <a href="mark"><div class="mark">
                      <div class="mark-img"></div>
                      <div class="mark-name">mark 1</div>
                  </div></a><a href="mark"><div class="mark">
                      <div class="mark-img"></div>
                      <div class="mark-name">mark 1</div>
                  </div></a><a href="mark"><div class="mark">
                      <div class="mark-img"></div>
                      <div class="mark-name">mark 1</div>
                  </div></a><a href="mark"><div class="mark">
                      <div class="mark-img"></div>
                      <div class="mark-name">mark 1</div>
                  </div></a>
<!-- 여기까지 -->

          </div>
              </div>
            </li>


          </ul>
        </div>
      </div>

    <nav class="sticky">
        <a href="/login/"><div><svg xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 0 24 24" width="24px" fill="#FFFFFF"><path d="M0 0h24v24H0V0z" fill="none"/><path d="M12 5.69l5 4.5V18h-2v-6H9v6H7v-7.81l5-4.5M12 3L2 12h3v8h6v-6h2v6h6v-8h3L12 3z"/></svg><p id="home">홈</p>
        </div></a><a href="/login/category/"><div><svg xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 0 24 24" width="24px" fill="#FFFFFF"><path d="M0 0h24v24H0V0z" fill="none"/><path d="M4 10.5c-.83 0-1.5.67-1.5 1.5s.67 1.5 1.5 1.5 1.5-.67 1.5-1.5-.67-1.5-1.5-1.5zm0-6c-.83 0-1.5.67-1.5 1.5S3.17 7.5 4 7.5 5.5 6.83 5.5 6 4.83 4.5 4 4.5zm0 12c-.83 0-1.5.68-1.5 1.5s.68 1.5 1.5 1.5 1.5-.68 1.5-1.5-.67-1.5-1.5-1.5zM7 19h14v-2H7v2zm0-6h14v-2H7v2zm0-8v2h14V5H7z"/></svg><p>카테고리</p>
        </div></a><a href="/login/search/"><div><svg xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 0 24 24" width="24px" fill="#FFFFFF"><path d="M0 0h24v24H0V0z" fill="none"/><path d="M15.5 14h-.79l-.28-.27C15.41 12.59 16 11.11 16 9.5 16 5.91 13.09 3 9.5 3S3 5.91 3 9.5 5.91 16 9.5 16c1.61 0 3.09-.59 4.23-1.57l.27.28v.79l5 4.99L20.49 19l-4.99-5zm-6 0C7.01 14 5 11.99 5 9.5S7.01 5 9.5 5 14 7.01 14 9.5 11.99 14 9.5 14z"/></svg><p>검색</p>
        </div></a><a href="/login/favorite/"><div><svg xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 0 24 24" width="24px" fill="#FFFFFF"><path d="M0 0h24v24H0V0z" fill="none"/><path d="M12 21.35l-1.45-1.32C5.4 15.36 2 12.28 2 8.5 2 5.42 4.42 3 7.5 3c1.74 0 3.41.81 4.5 2.09C13.09 3.81 14.76 3 16.5 3 19.58 3 22 5.42 22 8.5c0 3.78-3.4 6.86-8.55 11.54L12 21.35z"/></svg><p>즐겨찾기</p>
        </div></a><a href="/login/setting/"><div><svg xmlns="http://www.w3.org/2000/svg" enable-background="new 0 0 24 24" height="24px" viewBox="0 0 24 24" width="24px" fill="#FFFFFF"><g><path d="M0,0h24v24H0V0z" fill="none"/><path d="M19.14,12.94c0.04-0.3,0.06-0.61,0.06-0.94c0-0.32-0.02-0.64-0.07-0.94l2.03-1.58c0.18-0.14,0.23-0.41,0.12-0.61 l-1.92-3.32c-0.12-0.22-0.37-0.29-0.59-0.22l-2.39,0.96c-0.5-0.38-1.03-0.7-1.62-0.94L14.4,2.81c-0.04-0.24-0.24-0.41-0.48-0.41 h-3.84c-0.24,0-0.43,0.17-0.47,0.41L9.25,5.35C8.66,5.59,8.12,5.92,7.63,6.29L5.24,5.33c-0.22-0.08-0.47,0-0.59,0.22L2.74,8.87 C2.62,9.08,2.66,9.34,2.86,9.48l2.03,1.58C4.84,11.36,4.8,11.69,4.8,12s0.02,0.64,0.07,0.94l-2.03,1.58 c-0.18,0.14-0.23,0.41-0.12,0.61l1.92,3.32c0.12,0.22,0.37,0.29,0.59,0.22l2.39-0.96c0.5,0.38,1.03,0.7,1.62,0.94l0.36,2.54 c0.05,0.24,0.24,0.41,0.48,0.41h3.84c0.24,0,0.44-0.17,0.47-0.41l0.36-2.54c0.59-0.24,1.13-0.56,1.62-0.94l2.39,0.96 c0.22,0.08,0.47,0,0.59-0.22l1.92-3.32c0.12-0.22,0.07-0.47-0.12-0.61L19.14,12.94z M12,15.6c-1.98,0-3.6-1.62-3.6-3.6 s1.62-3.6,3.6-3.6s3.6,1.62,3.6,3.6S13.98,15.6,12,15.6z"/></g></svg><p>설정</p></div></a>
    </nav>
</html>
