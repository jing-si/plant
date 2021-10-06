<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QR Code Scanner</title>
</head>
<link rel="stylesheet" href="/resources/css/camera04.css" />
<script src="https://rawgit.com/sitepoint-editors/jsqrcode/master/src/qr_packed.js"></script>
<body>
	<div id="container">
	
		<h1>QR Code Scanner</h1>

        <a id="btn-scan-qr">
        	<img src="https://dab1nmslvvntp.cloudfront.net/wp-content/uploads/2017/07/1499401426qr_icon.svg">
        </a>

        <canvas hidden="" id="qr-canvas"></canvas>

        <div id="qr-result" hidden="">
            <b>Data:</b> <span id="outputData"></span>
        </div>
  	</div>

	<script src="/resources/js/qsCodeScanner.js"></script>
</body>
</html>