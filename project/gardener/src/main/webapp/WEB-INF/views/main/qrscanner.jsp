<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700;800&family=Noto+Sans+KR:wght@400;700;900&display=swap" rel="stylesheet">
<title>Insert title here</title>
</head>
<script>

    function call_scan() {
        var param = {
            action: "call_scan"
        };
        webkit.messageHandlers.cordova_iab.postMessage(JSON.stringify(param));
    }

    function get_scan(val) {
        // alert(val);

        if(val.indexOf('http') != -1) {
            alert('제품 정보를 확인할 수 없습니다.\n바코드를 스캔해주세요.')
        } else {
            $('#qrcode_val')[0].innerHTML = val;
        }
    }

</script>
<body>

	<br><br>
	<!-- 읽은 코드 데이터를 나타낼 div  -->
    <div id="qrcode_val" style="background: #eee; padding: 3em; font-size: 1.3em;">

    </div>

    <br><br>
    <br><br>
    <br><br>

    <div style="padding: 1.2em; font-size: 1em; border: 1px solid #ccc; border-radius: 0.3em;"
    onclick="call_scan()">
        qr/바코드 스캐너 실행
    </div>
</body>
</html>