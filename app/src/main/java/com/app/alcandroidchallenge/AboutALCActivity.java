package com.app.alcandroidchallenge;

import android.net.http.SslError;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AboutALCActivity extends AppCompatActivity {

    WebView wvAbout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_alc);

        wvAbout = (WebView) findViewById(R.id.wvAbout);
        wvAbout.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error){
                handler.proceed();
            }
        });

        WebSettings webSettings = wvAbout.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        wvAbout.loadUrl("https://andela.com/alc");

    }

    @Override
    public void onBackPressed() {
        if(wvAbout.canGoBack())
        {
            wvAbout.goBack();
        }
        else {
            super.onBackPressed();
        }
    }

}
