package ren.test.realnews;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Administrator on 2017/05/14 0014
 */
public class DetailActivity extends AppCompatActivity {
    private  WebView webView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if (getIntent()==null)
            finish();
        String url=getIntent().getStringExtra("url");
        if (url==null||url.length()==0)
            finish();
        setContentView(R.layout.activity_detail);
        webView= (WebView) findViewById(R.id.web_view);
        WebSettings settings= webView.getSettings();
        if (settings != null) {
            settings.setAllowFileAccess(true);
            settings.setDisplayZoomControls(true);
            settings.setUseWideViewPort(true);
            settings.setBuiltInZoomControls(true);
            settings.setLoadsImagesAutomatically(true);
            settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
            settings.setLoadWithOverviewMode(true);
        }
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        webView=null;
        super.onDestroy();
    }
}
