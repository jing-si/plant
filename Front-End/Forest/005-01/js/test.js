
// 유저 디바이스 사이즈 데이터
// 유저 숲 데이터 받아서 화면에 보여줄 때, 각 디바이스에 따라 X, Y 값이 다르지 않을까..
// 스크린에서 사용가능한? 상단 디바이스 메뉴바?(시계랑 베터리 잔량 부분)로 인해 가려진 부분을 제외한 실제 서비스 화면의 크기가 필요할 경우
// screen.availWidth, screen.availHeight 사용 예정

$(document).ready(function () {
    // 유저 디바이스 가로 사이즈
    var width = screen.width
    // 유저 디바이스 세로 사이즈
    var height = screen.height

    // 유저 디바이스 가로/세로 사이즈를 배열로 저장
    var allData = { "width": width, "height":height };

    // 유저 디바이스 데이터를 잘 가져오는지 콘솔에서 확인
    console.log('width', 'height', width, height);
    console.log(allData);

    // ajax으로 Controller에 데이터 전송 예정
    $.ajax({
    type : "POST",
    url : "post.do", 
    data : allData,
    error : function(error) {
    	console.log("error");
    },
    success : function(data) {
	console.log("success");
    }
    });
});

