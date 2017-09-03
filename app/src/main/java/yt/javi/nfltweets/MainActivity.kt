package yt.javi.nfltweets

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import yt.javi.nfltweets.view.adapters.TeamAdapter


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById(R.id.teams_list) as RecyclerView
        val mLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = mLayoutManager
        recyclerView.adapter = TeamAdapter(fun (twitterAccount: String) {
            val intent = Intent(this, TwitterTimeLineActivity::class.java)
            intent.putExtra(AppConstants.TWITTER_ACCOUNT, twitterAccount)
            startActivity(intent)
        })
    }
}