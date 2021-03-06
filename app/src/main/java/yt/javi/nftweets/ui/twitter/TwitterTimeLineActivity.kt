package yt.javi.nftweets.ui.twitter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.twitter.sdk.android.core.models.Tweet
import com.twitter.sdk.android.tweetui.SearchTimeline
import com.twitter.sdk.android.tweetui.Timeline
import com.twitter.sdk.android.tweetui.TweetTimelineRecyclerViewAdapter
import com.twitter.sdk.android.tweetui.UserTimeline
import kotlinx.android.synthetic.main.activity_twitter_time_line.*
import yt.javi.nftweets.R


class TwitterTimeLineActivity : AppCompatActivity() {
    companion object {
        val EXTRA_TWITTER_ACCOUNT = "twitter_account"
        val EXTRA_TEAM_NAME = "team_name"
        val EXTRA_TWITTER_TIMELINE_TYPE = "twitter_timeline_type"
    }

    enum class TimelineType {
        USER, SEARCH
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_twitter_time_line)

        val recyclerView = timeline_list

        recyclerView.layoutManager = LinearLayoutManager(this)

        val searchTimeline: Timeline<Tweet> = if (TimelineType.valueOf(intent.getStringExtra(EXTRA_TWITTER_TIMELINE_TYPE)) == TimelineType.USER)
            UserTimeline.Builder()
                    .screenName(intent.getStringExtra(EXTRA_TWITTER_ACCOUNT))
                    .build()
        else
            SearchTimeline.Builder()
                    .query("#" + intent.getStringExtra(EXTRA_TWITTER_ACCOUNT))
                    .build()

        recyclerView.adapter = TweetTimelineRecyclerViewAdapter.Builder(this)
                .setTimeline(searchTimeline)
                .setViewStyle(R.style.tw__TweetLightWithActionsStyle)
                .build()

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
