package yt.javi.nfltweets

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient

class TwitterTimeLineActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_twitter_time_line)

        val webview = findViewById(R.id.webview) as WebView
        webview.webChromeClient =  WebChromeClient()
        webview.webViewClient = WebViewClient()
        webview.settings.javaScriptEnabled = true
        webview.loadUrl("http://twitter.com/" + intent.getStringExtra(AppConstants.TWITTER_ACCOUNT))
    }
}
