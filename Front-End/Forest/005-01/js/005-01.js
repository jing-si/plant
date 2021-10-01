window.onload = function () {

    function onClick() {
        document.querySelector('.popup_wrap').style.display = 'block';
        document.querySelector('.popup').style.display = 'block';
    }
    function offClick() {
        document.querySelector('.popup_wrap').style.display = 'none';
        document.querySelector('.popup').style.display = 'none';
    }

    document.getElementById('botton_item').addEventListener('click', onClick);
    document.querySelector('.popup_close').addEventListener('click', offClick);

}

function newPage()  {
    window.location.href = 'http://127.0.0.1:5500/005-01/005-01-01.html'
    
}

function forest_change()  {
    window.location.href = 'http://127.0.0.1:5500/005-01/005-01-01.html'
}

