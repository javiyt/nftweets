package yt.javi.nfltweets

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.twitter.sdk.android.core.DefaultLogger
import com.twitter.sdk.android.core.Twitter
import com.twitter.sdk.android.core.TwitterAuthConfig
import com.twitter.sdk.android.core.TwitterConfig
import kotlinx.android.synthetic.main.activity_main.*
import yt.javi.nfltweets.domain.infrastructure.repositories.inmemory.TeamInMemoryRepository
import yt.javi.nfltweets.domain.infrastructure.repositories.inmemory.TeamsDataBase
import yt.javi.nfltweets.domain.model.Conference
import yt.javi.nfltweets.domain.service.team.GetTeamsByConferenceService
import yt.javi.nfltweets.view.DivisonFragment
import yt.javi.nfltweets.view.adapters.TeamsPageAdapter


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

        val fragmentAdapter = TeamsPageAdapter(supportFragmentManager)
        val getTeamsByConferenceService = GetTeamsByConferenceService(
                TeamInMemoryRepository(
                        TeamsDataBase.teamsList
                )
        )
        fragmentAdapter.addFragment(DivisonFragment.newInstance(
                getTeamsByConferenceService,
                Conference.AFC
        ))
        fragmentAdapter.addFragment(DivisonFragment.newInstance(
                getTeamsByConferenceService,
                Conference.NFC
        ))

        this.pager.adapter = fragmentAdapter
    }
}