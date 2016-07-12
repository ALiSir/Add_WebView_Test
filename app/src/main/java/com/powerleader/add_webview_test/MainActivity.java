package com.powerleader.add_webview_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.powerleader.add_webview_test.view.MyActivity;
import com.powerleader.add_webview_test.view.MyWebView;

public class MainActivity extends MyActivity {
    private MyWebView mvb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mvb = (MyWebView) findViewById(R.id.webView);

        WebSettings ws = mvb.getSettings();
        ws.setJavaScriptEnabled(true);


        mvb.setWebViewClient(new WebViewClient(){
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                Toast.makeText(MainActivity.this,error.toString(),Toast.LENGTH_LONG).show();
            }
        });

        String htmlData = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<meta charset=\"UTF-8\">\n" +
                "<title>这是一个HTML5页面！</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<p>Hello HTML5</p>\n" +
                "    <input />\n" +
                "</body>\n" +
                "</html>";

        mvb.loadData(htmlData,"text/html",null);

    }
}
