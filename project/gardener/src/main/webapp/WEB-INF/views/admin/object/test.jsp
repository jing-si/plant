<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
img{
	width: 30%;
	height: 30%;
}
</style>
</head>
<body>

<c:forEach var="item" items="${list }"> 
	<img alt="" src="${item }">
</c:forEach>
<div>
	
</div>
</body>
</html>