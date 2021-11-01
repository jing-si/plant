package com.gakkum.gakkum;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {

    // 변수 선언
    private WebView mWebView;   // 웹뷰
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
        mWebView.setWebChromeClient(new WebChromeClient()); // 웹 크롬 클라이언트
        mWebView.setWebViewClient(new WebViewClientClass());//새창열기 없이 웹뷰 내에서 다시 열기//페이지 이동 원활히 하기위해 사용

        // 웹뷰 설정 메소드 호출
        webViewInit(mWebView);


        // WebView alert() 사용
        mWebView.setWebChromeClient(new WebChromeClient() {

            // alert창 url 제거
            public boolean onJsAlert(WebView mWebView, String url, String message, final android.webkit.JsResult result) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("")
                        .setMessage(message)
                        .setPositiveButton(android.R.string.ok, new AlertDialog.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                result.confirm();
                            }
                        })
                        .setCancelable(false)
                        .create()
                        .show();

                return true;
            };

            @Override
            public boolean onJsConfirm(WebView view, String url, String message, final android.webkit.JsResult result){
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("")
                        .setMessage(message)
                        .setPositiveButton(android.R.string.ok,
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        result.confirm();
                                    }
                                })
                        .setNegativeButton(android.R.string.cancel,
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        result.cancel();
                                    }
                                })
                        .create()
                        .show();

                return true;
            };

/*
            //웹뷰에 Confirm창에 url을 제거한다.
            @Override
            public boolean onJsConfirm(WebView mWebView, String url, String message, final android.webkit.JsResult result) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("")
                        .setMessage(message)
                        .setPositiveButton(android.R.string.ok, new AlertDialog.OnClickListener() {

                            public void onClick(DialogInterface dialog, int which) {
                                result.confirm();
                            }
                        })
                        .setNegativeButton(android.R.string.cancel, new AlertDialog.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        result.cancel();
                                    }
                                })
                        .create()
                        .show();

                return true;
            } */
        });


        mContext = this.getApplicationContext();

        // 자바스크립트에서 네이티브 바코드 스캐너 호출
        mWebView.addJavascriptInterface(new CustomJavaScriptCallback() {

            @JavascriptInterface
            @Override
            public void webViewToApp() {

                IntentIntegrator intentIntegrator = new IntentIntegrator(
                        MainActivity.this
                );

                intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.EAN_13); // 숫자바코드만 인식할 수 있도록 설정
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

            String getUrl = mWebView.getUrl();
            String loginUrl = "https://www.gakkum.info/login/";
            String searchUrl = "https://www.gakkum.info/login/search/qr";

            if(getUrl.equals(loginUrl)) {

                String certify = "https://www.gakkum.info/login/certify?";
                String barcode = intentResult.getContents();    // 바코드 번호
                String certifyUrl = certify + "barcode=" + barcode;              // 현재 url + 바코드번호

                mWebView.loadUrl(certifyUrl);

            } else if(getUrl.equals(searchUrl)) {

                String qr = "https://www.gakkum.info/login/search/qr?";
                String barcode = intentResult.getContents();    // 바코드 번호
                String qrUrl = qr + "barcode=" + barcode;              // 현재 url + 바코드번호

                mWebView.loadUrl(qrUrl);

            }

            // Toast.makeText(getApplicationContext(), mWebView.getUrl(), Toast.LENGTH_LONG).show();

        } /*else {

            AlertDialog.Builder builder = new AlertDialog.Builder(
                    MainActivity.this
            );

            builder.setTitle("인식 실패");
            builder.setMessage("바코드를 다시 인식해주세요.");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });

            builder.show();

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