package yt.javi.nftweets.ui.news

import android.os.Bundle
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
import java.lang.Thread.sleep


class NewsFragment() : Fragment() {
    private lateinit var getLatestNewsService: GetLatestNewsService

    private lateinit var recyclerView: RecyclerView

    constructor(getLatestNewsService: GetLatestNewsService) : this() {
        this.getLatestNewsService = getLatestNewsService
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val viewGroup = inflater?.inflate(R.layout.news_list_fragment, container, false) as ViewGroup

        recyclerView = viewGroup.findViewById(R.id.news_list)

        return  viewGroup
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        doAsync {
            val news = getLatestNewsService.getLatestNews()
            uiThread {
                val articleAdapter = ArticleAdapter(news)
                articleAdapter.setHasStableIds(true)

                recyclerView.layoutManager = LinearLayoutManager(activity)
                recyclerView.adapter = articleAdapter

                sleep(500)
                news_progressbar.visibility = GONE
                recyclerView.visibility = VISIBLE
            }
        }
    }
}
