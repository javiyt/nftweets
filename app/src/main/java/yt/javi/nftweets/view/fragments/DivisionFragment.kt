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


class DivisionFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView

    lateinit var getTeamsByConferenceService: GetTeamsByConferenceService

    companion object {
        private val CONFERENCES = "conferences"

        fun newInstance(getTeamsByConferenceService: GetTeamsByConferenceService, conference: Conference): DivisionFragment {
            val divisionFragment = DivisionFragment()

            divisionFragment.getTeamsByConferenceService = getTeamsByConferenceService

            val bundle = Bundle()
            bundle.putString(CONFERENCES, conference.name)
            divisionFragment.arguments =  bundle

            return divisionFragment
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

    private fun onGoToTimelineClickListener(): (String, String, TwitterTimeLineActivity.TimelineType) -> Unit {
        return fun(twitterAccount: String, teamName: String, timelineType: TwitterTimeLineActivity.TimelineType) {
            val intent = Intent(activity, TwitterTimeLineActivity::class.java)
            intent.putExtra(TwitterTimeLineActivity.EXTRA_TWITTER_ACCOUNT, twitterAccount)
            intent.putExtra(TwitterTimeLineActivity.EXTRA_TEAM_NAME, teamName)
            intent.putExtra(TwitterTimeLineActivity.EXTRA_TWITTER_TIMELINE_TYPE, timelineType.name)

            startActivity(intent)
        }
    }

}