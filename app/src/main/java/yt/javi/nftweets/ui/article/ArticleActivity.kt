package yt.javi.nftweets.ui.article

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import yt.javi.nftweets.R

class ArticleActivity : AppCompatActivity() {
    companion object {
        val ARTICLE_URL = "article_url"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)

        val webview = findViewById<WebView>(R.id.article_webview)
        webview.webChromeClient = WebChromeClient()
        webview.webViewClient = WebViewClient()
        webview.settings.javaScriptEnabled = true
        webview.loadUrl(intent.getStringExtra(ARTICLE_URL))
    }
}
