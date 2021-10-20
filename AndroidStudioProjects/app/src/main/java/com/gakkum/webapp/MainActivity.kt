package com.gakkum.webapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        private var webView : WebView? = null //웹뷰
        private var webSetting : WebSettings? = null    //웹뷰세팅

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )

            webView = findViewById(R.id.webView) as WebView
            webView?.setWebViewClient(WebViewClient()) // 클릭시 새창 안뜨게 막아준다

            webSetting = webView?.getSettings()
            webSetting?.setJavaScriptEnabled(true) // 자바스크립트 사용을 허용한다

            webView?.loadUrl("https://www.gakkum.info") // 연결할 웹뷰 url

        }

        companion object {
            //private const val url = "http://localhost:8000"
            private const val url = "https://www.gakkum.info" //porting 할 URL
        }

        // 뒤로 가기 버튼 설정
        override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
            if (keyCode == KeyEvent.KEYCODE_BACK && webView!!.canGoBack()) {
                webView?.goBack()
                return true
            }
            return super.onKeyDown(keyCode, event)
        }
    }
}