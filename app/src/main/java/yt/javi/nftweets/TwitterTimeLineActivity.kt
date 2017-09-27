package yt.javi.nftweets

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.twitter.sdk.android.tweetui.TweetTimelineRecyclerViewAdapter
import com.twitter.sdk.android.tweetui.UserTimeline
import kotlinx.android.synthetic.main.activity_twitter_time_line.*


class TwitterTimeLineActivity : AppCompatActivity() {
    companion object {
        val EXTRA_TWITTER_ACCOUNT = "twitter_account"
        val EXTRA_TEAM_NAME = "team_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_twitter_time_line)

        val recyclerView = timeline_list

        recyclerView.layoutManager = LinearLayoutManager(this)

        val searchTimeline = UserTimeline.Builder()
                .screenName(intent.getStringExtra(EXTRA_TWITTER_ACCOUNT))
                .build()

        val adapter = TweetTimelineRecyclerViewAdapter.Builder(this)
                .setTimeline(searchTimeline)
                .setViewStyle(R.style.tw__TweetLightWithActionsStyle)
                .build()

        recyclerView.adapter = adapter

        twitter_toolbar.title = intent.getStringExtra(EXTRA_TEAM_NAME)
        setSupportActionBar(twitter_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}