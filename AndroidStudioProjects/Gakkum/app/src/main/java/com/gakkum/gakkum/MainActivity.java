package com.gakkum.gakkum;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.util.Xml;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    // 변수 선언
    private WebView mWebView;   // 웹뷰
    private Button button;
    public Context mContext;

    // 자바스크립트에서 연결하여 사용할 네이티브 함수 정의 인터페이스
    public interface CustomJavaScriptCallback{
        void webViewToApp();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // xml 자바코드 연결
        mWebView = (WebView) findViewById(R.id.webView);

        mWebView.getSettings().setJavaScriptEnabled(true); // 웹뷰에서 자바스크립트 사용
        mWebView.loadUrl("https://www.gakkum.info");        // 연결할 웹뷰 url
        mWebView.setWebChromeClient(new WebChromeClient()); // 웹 크롬 클라이언트 설정
        mWebView.setWebViewClient(new WebViewClientClass());//새창열기 없이 웹뷰 내에서 다시 열기//페이지 이동 원활히 하기위해 사용

        // 웹뷰 설정 메소드 호출
        webViewInit(mWebView);

        mContext = this.getApplicationContext();

/*

        // 네이티브에서 자바스크립트 함수 호출
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mWebView.loadUrl("javascript:changeColor()");

                IntentIntegrator intentIntegrator = new IntentIntegrator(
                         MainActivity.this
                );
                intentIntegrator.setPrompt("바코드를 스캔하세요");   // 바코드 하단 문구설정
                intentIntegrator.setCameraId(0);
                intentIntegrator.setBeepEnabled(false);  // 바코드 스캔시 소리 on(true), off(false)
                intentIntegrator.setOrientationLocked(false);
                intentIntegrator.initiateScan();

            }
        });
*/
        // 자바스크립트에서 네이티브 바코드 스캐너 호출
        mWebView.addJavascriptInterface(new CustomJavaScriptCallback() {

            @JavascriptInterface
            @Override
            public void webViewToApp() {

                /*Intent intent = new Intent(mContext.getApplicationContext(), SubActivity.class);
                startActivity(intent);*/

                IntentIntegrator intentIntegrator = new IntentIntegrator(
                        MainActivity.this
                );
                intentIntegrator.setPrompt("바코드를 스캔하세요");   // 바코드 하단 문구설정
                intentIntegrator.setCameraId(0);
                intentIntegrator.setBeepEnabled(false);  // 바코드 스캔시 소리 on(true), off(false)
                intentIntegrator.setOrientationLocked(false);
                intentIntegrator.initiateScan();

            }
        }, "WebViewCallbackInterface");

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        IntentResult intentResult = IntentIntegrator.parseActivityResult(
                requestCode, resultCode, data
        );

        if (intentResult.getContents() != null) {

            AlertDialog.Builder builder = new AlertDialog.Builder(
                    MainActivity.this
            );

            /*builder.setTitle("Result");
            builder.setMessage(intentResult.getContents());
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });*/

            builder.show();

            String url = "https://www.gakkum.info/certify?";
            String barcode = intentResult.getContents();
            String barcodeUrl = url + barcode;
            // String postData = "barcode=" +barcode;
            // String msg = intentResult.getContents();

            // mWebView.loadUrl("javascript:setReceivedMessage('"+msg+"')");
            mWebView.loadUrl("https://www.gakkum.info/certify?"+ barcode);
            //  mWebView.postUrl(url, barcode.getBytes());
            //  mWebView.getUrl();

            // 현재 url 경로확인
            Toast.makeText(getApplicationContext(), mWebView.getUrl(), Toast.LENGTH_LONG).show();


        } /*else {
            Toast.makeText(getApplicationContext(), "Opps...", Toast.LENGTH_LONG).show();
        }*/


    }


    // 웹뷰에서 자바스크립트를 인식하기 위한 웹뷰 설정 함수
    public void webViewInit(WebView mWebView) {
        WebSettings settings = mWebView.getSettings();

        // Javascript 사용하기
        settings.setJavaScriptEnabled(true);

        // Text Encoding 이름 정의
        settings.setDefaultTextEncodingName("UTF-8");

    }

    //뒤로가기 버튼 이벤트
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //웹뷰에서 뒤로가기 버튼을 누르면 뒤로가짐
        if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {
            mWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    //페이지 이동
    private class WebViewClientClass extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Log.d("check URL",url);
            view.loadUrl(url);
            return true;
        }
    }

}