package yt.javi.nftweets.ui.main

import android.os.Bundle
import android.support.test.espresso.idling.CountingIdlingResource
import android.support.v4.app.Fragment
import android.support.v4.util.LruCache
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.beust.klaxon.Parser
import com.twitter.sdk.android.core.DefaultLogger
import com.twitter.sdk.android.core.Twitter
import com.twitter.sdk.android.core.TwitterAuthConfig
import com.twitter.sdk.android.core.TwitterConfig
import kotlinx.android.synthetic.main.activity_main.*
import yt.javi.nftweets.BuildConfig
import yt.javi.nftweets.R
import yt.javi.nftweets.domain.service.news.GetLatestNewsService
import yt.javi.nftweets.infrastructure.repositories.http.ArticleHttpRepository
import yt.javi.nftweets.infrastructure.repositories.http.HttpReader
import yt.javi.nftweets.ui.fragments.TeamListFragment
import yt.javi.nftweets.ui.news.NewsFragment
import java.net.URL


class MainActivity : AppCompatActivity() {
    private val espressoTestIdlingResource = CountingIdlingResource("Network_Call")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        Twitter.initialize(
                TwitterConfig.Builder(this)
                        .logger(DefaultLogger(Log.DEBUG))
                        .twitterAuthConfig(
                                TwitterAuthConfig(
                                        BuildConfig.TWITTER_CONSUMER_KEY,
                                        BuildConfig.TWITTER_CONSUMER_SECRET
                                )
                        )
                        .debug(true)
                        .build()
        )


        navigation.setOnNavigationItemSelectedListener { item ->
            var selectedFragment: Fragment? = null
            when (item.itemId) {
                R.id.action_show_teams -> selectedFragment = TeamListFragment()
                R.id.action_show_news -> selectedFragment = NewsFragment(
                        GetLatestNewsService(
                                ArticleHttpRepository(
                                        Parser(),
                                        HttpReader(LruCache(100))
                                ),
                                URL(BuildConfig.NEWS_API_URL)
                        ),
                        espressoTestIdlingResource
                )

            }
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.main_view, selectedFragment)
            transaction.commit()
            true
        }

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.main_view, TeamListFragment())
        transaction.commit()
        navigation.menu.getItem(1).isChecked = true

        main_toolbar.setTitle(R.string.app_name)
    }

    fun getEspressoIdlingResource(): CountingIdlingResource = espressoTestIdlingResource
}