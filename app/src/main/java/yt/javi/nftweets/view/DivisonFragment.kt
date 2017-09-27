package yt.javi.nftweets.view

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import yt.javi.nftweets.R
import yt.javi.nftweets.TwitterTimeLineActivity
import yt.javi.nftweets.domain.model.Conference
import yt.javi.nftweets.domain.model.Conference.valueOf
import yt.javi.nftweets.domain.service.team.GetTeamsByConferenceService
import yt.javi.nftweets.view.adapters.TeamAdapter


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

    private fun onGoToTimelineClickListener(): (String, String) -> Unit {
        return fun(twitterAccount: String, teamName: String) {
            val intent = Intent(activity, TwitterTimeLineActivity::class.java)
            intent.putExtra(TwitterTimeLineActivity.EXTRA_TWITTER_ACCOUNT, twitterAccount)
            intent.putExtra(TwitterTimeLineActivity.EXTRA_TEAM_NAME, teamName)
            startActivity(intent)
        }
    }

}

