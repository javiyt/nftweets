package yt.javi.nfltweets

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.twitter.sdk.android.core.DefaultLogger
import com.twitter.sdk.android.core.Twitter
import com.twitter.sdk.android.core.TwitterAuthConfig
import com.twitter.sdk.android.core.TwitterConfig
import kotlinx.android.synthetic.main.activity_main.*
import yt.javi.nfltweets.view.adapters.TeamAdapter


class MainActivity : AppCompatActivity() {

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

        val recyclerView = teams_list

        val teamAdapter = TeamAdapter(onGoToTimelineClickListener())
        teamAdapter.setHasStableIds(true)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = teamAdapter
    }

    private fun onGoToTimelineClickListener(): (String) -> Unit {
        return fun(twitterAccount: String) {
            val intent = Intent(this, TwitterTimeLineActivity::class.java)
            intent.putExtra(TwitterTimeLineActivity.EXTRA_TWITTER_ACCOUNT, twitterAccount)
            startActivity(intent)
        }
    }
}