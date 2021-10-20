package com.example.webviewproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val TAG: String = "로그"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val myWebView: WebView = findViewById(R.id.webview)

        myWebView.settings.javaScriptEnabled = true
        myWebView.webViewClient = WebViewClient()
        myWebView.loadUrl("http://www.naver.com")

        // 바텀 네비게이션 뷰를 가져온다.
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.naver -> {
                    Log.d(TAG, "네이버 클릭")
                    myWebView.loadUrl("https://www.naver.com")
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.daum -> {
                    Log.d(TAG, "다음  클릭")
                    myWebView.loadUrl("https://www.daum.net/")
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.google -> {
                    Log.d(TAG, "구글 클릭")
                    myWebView.loadUrl("https://www.google.com/")
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false
        }

    }

}
