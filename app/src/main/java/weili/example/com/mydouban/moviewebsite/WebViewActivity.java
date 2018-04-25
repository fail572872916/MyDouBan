package weili.example.com.mydouban.moviewebsite;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import weili.example.com.mydouban.HomeActivity;
import weili.example.com.mydouban.R;

public class WebViewActivity extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_movie_web_view);

        Intent intent = getIntent();
        final String url = intent.getStringExtra("website");
        Log.e(HomeActivity.TAG, "===> website = " + url);

        WebView webView = (WebView) findViewById(R.id.douban_webview);
        if (webView != null) {
            webView.getSettings().setJavaScriptEnabled(true);
            webView.loadUrl(url);
            webView.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return true;
                }
            });
        }
    }
}
