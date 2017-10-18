package yt.javi.nftweets.ui.news

import android.content.Intent
import android.os.Bundle
import android.os.SystemClock.sleep
import android.support.test.espresso.idling.CountingIdlingResource
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import kotlinx.android.synthetic.main.news_list_fragment.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import yt.javi.nftweets.R
import yt.javi.nftweets.domain.service.news.GetLatestNewsService
import yt.javi.nftweets.ui.article.ArticleActivity
import java.net.URL




class NewsFragment() : Fragment() {
    private lateinit var getLatestNewsService: GetLatestNewsService

    private lateinit var recyclerView: RecyclerView

    private lateinit var espressoTestIdlingResource: CountingIdlingResource

    constructor(getLatestNewsService: GetLatestNewsService, espressoTestIdlingResource: CountingIdlingResource) : this() {
        this.getLatestNewsService = getLatestNewsService
        this.espressoTestIdlingResource = espressoTestIdlingResource
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val viewGroup = inflater?.inflate(R.layout.news_list_fragment, container, false) as ViewGroup

        recyclerView = viewGroup.findViewById(R.id.news_list)

        return  viewGroup
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        espressoTestIdlingResource.increment()

        doAsync {
            val news = getLatestNewsService.getLatestNews()

            uiThread {
                val articleAdapter = ArticleAdapter(news, onClickArticleTitle())
                articleAdapter.setHasStableIds(true)

                recyclerView.layoutManager = LinearLayoutManager(activity)
                recyclerView.adapter = articleAdapter

                sleep(500)
                news_progressbar.visibility = GONE
                recyclerView.visibility = VISIBLE
                espressoTestIdlingResource.decrement()
            }
        }
    }

    private fun onClickArticleTitle(): (URL) -> Unit {
        return fun (url: URL) {
            val intent = Intent(activity, ArticleActivity::class.java)
            intent.putExtra(ArticleActivity.ARTICLE_URL, url.toString())

            startActivity(intent)
        }
    }
}
