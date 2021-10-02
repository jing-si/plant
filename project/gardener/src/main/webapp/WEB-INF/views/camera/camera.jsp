<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ler barcode</title>
</head>
<script src="quagga.min.js"></script>
<body>
	<div id="camera"></div>
	
	<script>
        Quagga.init({
            inputStream : {
            name : "Live",
            type : "LiveStream",
            target: document.querySelector('#camera')    // Or '#yourElement' (optional)
            },
            decoder : {
            readers : ["code_128_reader"]
            }
        }, function(err) {
            if (err) {
                console.log(err);
                return
            }
            console.log("Initialization finished. Ready to start");
            Quagga.start();
        });

        Quagga.onDetected(function (data) {
            console.log(data);
        });

    </script>
</body>
</html>