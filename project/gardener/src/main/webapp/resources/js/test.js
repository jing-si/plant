window.onload = function () {
    const tabList = document.querySelectorAll('.list li');

    for (var i = 0; i < tabList.length; i++) {
        tabList[i].querySelector('.btn').addEventListener('click', function (e) {
            e.preventDefault();
            for (var j = 0; j < tabList.length; j++) {
                tabList[j].classList.remove('is_on');
            }
            this.parentNode.classList.add('is_on');
        });
    }
}

// 탭 ul class="list
// 탭 버튼(li안에 있는 div로) div class="btn"
// 기본값 버튼 li에 class="is_on"

// 예시
// #gender ul{
//     display: inline-block;
//     width: 100%;
//     background-color: #f5f5f5;
//     height: 40px;
//     border-radius: 4px;
// }
// #gender ul li{
//     display: inline-block;
//     /* width */
//     height: 40px;
// }
// .list li.is_on .btn{
//     color: #66bb6a;
//     background-color: #fff;
//     border: 1px solid #66bb6a;
// }