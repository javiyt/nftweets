package yt.javi.nftweets.view.fragments

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.team_list_fragment.*
import kotlinx.android.synthetic.main.team_list_fragment.view.*
import yt.javi.nftweets.R
import yt.javi.nftweets.domain.infrastructure.repositories.inmemory.TeamInMemoryRepository
import yt.javi.nftweets.domain.infrastructure.repositories.inmemory.TeamsDataBase
import yt.javi.nftweets.domain.model.Conference
import yt.javi.nftweets.domain.service.team.GetTeamsByConferenceService
import yt.javi.nftweets.view.adapters.TeamsPageAdapter


class TeamListFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater?.inflate(R.layout.team_list_fragment, container, false) as ViewGroup

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val fragmentAdapter = TeamsPageAdapter(fragmentManager)

        val getTeamsByConferenceService = GetTeamsByConferenceService(
                TeamInMemoryRepository(
                        TeamsDataBase.teamsList
                )
        )
        fragmentAdapter.addFragment(
                DivisonFragment.newInstance(
                        getTeamsByConferenceService,
                        Conference.AFC
                ),
                Conference.AFC.name
        )
        fragmentAdapter.addFragment(
                DivisonFragment.newInstance(
                        getTeamsByConferenceService,
                        Conference.NFC
                ),
                Conference.NFC.name
        )

        this.pager.adapter = fragmentAdapter

        (view.tabs as TabLayout).setupWithViewPager(this.pager)
    }
}