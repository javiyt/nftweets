package yt.javi.nfltweets.view

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import yt.javi.nfltweets.R
import yt.javi.nfltweets.TwitterTimeLineActivity
import yt.javi.nfltweets.domain.model.Conference
import yt.javi.nfltweets.domain.model.Conference.valueOf
import yt.javi.nfltweets.domain.service.team.GetTeamsByConferenceService
import yt.javi.nfltweets.view.adapters.TeamAdapter


class DivisonFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView

    lateinit var getTeamsByConferenceService: GetTeamsByConferenceService

    companion object {
        private val CONFERENCES = "conferences"

        fun newInstance(getTeamsByConferenceService: GetTeamsByConferenceService, conference: Conference): DivisonFragment {
            val divisonFragment = DivisonFragment()

            divisonFragment.getTeamsByConferenceService = getTeamsByConferenceService

            val bundle = Bundle()
            bundle.putString(CONFERENCES, conference.name)
            divisonFragment.arguments =  bundle

            return divisonFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val viewGroup = inflater?.inflate(R.layout.division_fragment, container, false) as ViewGroup

        recyclerView = viewGroup.findViewById(R.id.teams_list)

        return  viewGroup
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val teamAdapter = TeamAdapter(
                getTeamsByConferenceService,
                valueOf(arguments.getString(CONFERENCES)),
                onGoToTimelineClickListener()
        )
        teamAdapter.setHasStableIds(true)

        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = teamAdapter
    }

    private fun onGoToTimelineClickListener(): (String) -> Unit {
        return fun(twitterAccount: String) {
            val intent = Intent(activity, TwitterTimeLineActivity::class.java)
            intent.putExtra(TwitterTimeLineActivity.EXTRA_TWITTER_ACCOUNT, twitterAccount)
            startActivity(intent)
        }
    }

}

