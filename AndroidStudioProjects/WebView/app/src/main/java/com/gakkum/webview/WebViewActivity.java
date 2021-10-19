package com.gakkum.webview;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends Activity {

    private String TAG = WebViewActivity.class.getSimpleName();

    private WebView webView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView) findViewById(R.id.webview);

        webView.setWebViewClient(new WebViewClient());  // 새 창 띄우기 않기
        webView.setWebChromeClient(new WebChromeClient());

        webView.getSettings().setLoadWithOverviewMode(true);  // WebView 화면크기에 맞추도록 설정 - setUseWideViewPort 와 같이 써야함
        webView.getSettings().setUseWideViewPort(true);  // wide viewport 설정 - setLoadWithOverviewMode 와 같이 써야함

        webView.getSettings().setSupportZoom(false);  // 줌 설정 여부
        webView.getSettings().setBuiltInZoomControls(false);  // 줌 확대/축소 버튼 여부

        webView.getSettings().setJavaScriptEnabled(true); // 자바스크립트 사용여부
//        webview.addJavascriptInterface(new AndroidBridge(), "android");
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true); // javascript가 window.open()을 사용할 수 있도록 설정
        webView.getSettings().setSupportMultipleWindows(true); // 멀티 윈도우 사용 여부

        webView.getSettings().setDomStorageEnabled(true);  // 로컬 스토리지 (localStorage) 사용여부


        //웹페이지 호출
        // webView.loadUrl("http://www.naver.com");
        webView.loadUrl("https://www.gakkum.info");

    }

}

/*

        웹뷰 설정에 필요한 것만 추가
        //WebView 화면크기에 맞추도록 설정 - setUseWideViewPort 와 같이 써야함
        webView.getSettings().setLoadWithOverviewMode(true);

        //wide viewport 설정 - setLoadWithOverviewMode 와 같이 써야함
        webView.getSettings().setUseWideViewPort(true);

        //줌 설정 여부
        webView.getSettings().setSupportZoom(false);

        //줌 확대/축소 버튼 여부
        webView.getSettings().setBuiltInZoomControls(true);

        //자바스크립트 사용 여부
        webView.getSettings().setJavaScriptEnabled(true);

        //자바스크립트가 window.open()을 사용할 수 있도록 설정
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);

        //멀티윈도우 사용 여부
        webView.getSettings().setSupportMultipleWindows(true);

        //캐시 사용 여부
        webView.getSettings().setAppCacheEnabled(false);

        //캐시 설정
        webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);

        // -- LOAD_CACHE_ELSE_NETWORK : 캐시 기간만료 시 네트워크 접속
        // -- LOAD_CACHE_ONLY : 캐시만 불러옴 (네트워크 사용 X)
        // -- LOAD_DEFAULT : 기본 모드, 캐시 사용, 기간 만료 시 네트워크 사용
        // -- LOAD_NO_CACHE : 캐시모드 사용안함
        // -- LOAD_NORMAL : 기본모드 캐시 사용 @Deprecated


        //로컬 스토리지 (localStorage) 사용여부
        webView.getSettings().setDomStorageEnabled(true);

        //폼에 입력된 데이터 저장 여부
        webView.getSettings().setSaveFormData(true);

        //파일 액세스 허용 여부
        webView.getSettings().setAllowFileAccess(true);

        //디버그 모드 사용 여부
        // -- true 인 경우 크롬에서 "chrome://inspect" 를 통해 웹뷰 확인 가능
        webView.setWebContentsDebuggingEnabled(false);

        //사용자 문자열 설정
        webView.getSettings().setUserAgentString("app");

        //인코딩 설정
        webView.getSettings().setDefaultTextEncodingName("UTF-8");

        //네트워크를 통해 이미지리소스 받을지 여부
        webView.getSettings().setBlockNetworkImage(false);

        //database storage API 사용 여부
        webView.getSettings().setDatabaseEnabled(false);

        //웹뷰를 통해 Content URL 에 접근 사용 여부
        webView.getSettings().setAllowContentAccess(true);

*/




