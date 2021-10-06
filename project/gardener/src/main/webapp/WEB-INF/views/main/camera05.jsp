<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QR Code Scanner</title>
</head>
<style>
    #holder {
        width: 30%;
        margin: auto;
    }

    #holder .make {
        width: 99%;
        height: 30vh;
        margin-bottom: 15px;
        text-align: center;
    }

    video {
        width: 99%;
        margin: auto;
    }
</style>
<script type="module">
    import QrScanner from "camera05.js";
    QrScanner.WORKER_PATH = "camera05-worker.js";

    // Scanner Object
    const scanner = new QrScanner(
        document.getElementById("scan"),
        function (result) {
            document.getElementById("scanresult").value = result;
        }
    );

    document.getElementById("start").onclick = e => scanner.start();
    document.getElementById("stop").onclick = e => scanner.stop();

</script>
<body>
    <div id="holder">
        <h3>Scan QR Code from Camera</h3>
        <div class="make">
            <video id="scan"></video>
        </div>
        <div>
            <input type="text" id="scanresult"><br>
            <button id="start">Start</button>
            <button id="stop">Stop</button>
        </div>
    </div>
</body>
</html>