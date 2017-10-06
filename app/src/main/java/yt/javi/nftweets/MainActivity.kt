package yt.javi.nftweets

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.twitter.sdk.android.core.DefaultLogger
import com.twitter.sdk.android.core.Twitter
import com.twitter.sdk.android.core.TwitterAuthConfig
import com.twitter.sdk.android.core.TwitterConfig
import kotlinx.android.synthetic.main.activity_main.*
import yt.javi.nftweets.domain.infrastructure.repositories.inmemory.TeamInMemoryRepository
import yt.javi.nftweets.domain.infrastructure.repositories.inmemory.TeamsDataBase
import yt.javi.nftweets.domain.model.Conference
import yt.javi.nftweets.domain.service.team.GetTeamsByConferenceService
import yt.javi.nftweets.view.DivisionFragment
import yt.javi.nftweets.view.adapters.TeamsPageAdapter


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
        fragmentAdapter.addFragment(
                DivisionFragment.newInstance(
                        getTeamsByConferenceService,
                        Conference.AFC
                ),
                Conference.AFC.name
        )
        fragmentAdapter.addFragment(
                DivisionFragment.newInstance(
                        getTeamsByConferenceService,
                        Conference.NFC
                ),
                Conference.NFC.name
        )

        this.pager.adapter = fragmentAdapter

        val tabLayout = findViewById(R.id.tabs) as TabLayout
        tabLayout.setupWithViewPager(this.pager)

        main_toolbar.setTitle(R.string.app_name)
    }
}