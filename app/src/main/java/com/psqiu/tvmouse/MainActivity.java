package com.psqiu.tvmouse;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

//更多TV项目资源(如桌面，直播点播，教育，应用市场，文件管理器，设置，酒店应用等)，添加微信：qiupansi
//If you want more TV project resources,such as TvLauncher,TvLive,TvAppStore,TvSettings,TvFileManager,TvEducation,TvHotel,TvMusic,TvRemote and so on，Add me wechat：qiupansi
public class MainActivity extends AppCompatActivity {

    private CustomWebView webView;
    private MouseView mouseView;
    private String expmpleUrl = "https://www.baidu.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = (CustomWebView) findViewById(R.id.web_view);
        webView.getSettings().setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewClient(){
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.getUrl().toString());
                return true;
            }
        });
        webView.loadUrl(expmpleUrl);
        mouseView = (MouseView) findViewById(R.id.mouse_view);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (mouseView.moveMouse(webView,event)) {
            finish();
        }
        return super.dispatchKeyEvent(event);
    }
}
