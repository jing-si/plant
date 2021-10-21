package com.gakkum.application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {


    
    // WebView 변수 선언
    private WebView mWeb = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // findViewById로 WebView 불러오기
        mWeb = (WebView) findViewById(R.id.WebView1);

        WebSettings set = mWeb.getSettings();
        set.setJavaScriptEnabled(true);
        set.setJavaScriptCanOpenWindowsAutomatically(true); // 자바스크립트 허용
        set.setCacheMode(WebSettings.LOAD_DEFAULT); // 브라우저 캐시 허용

        mWeb.loadUrl("https://www.gakkum.info"); //웹뷰 시작시 이동할 페이지 설정
        mWeb.setWebChromeClient(new WebChromeClient());
        mWeb.setWebViewClient(new WebViewClient());  //새창 열기 없이 웹뷰내에서 다시 열기
    }
}