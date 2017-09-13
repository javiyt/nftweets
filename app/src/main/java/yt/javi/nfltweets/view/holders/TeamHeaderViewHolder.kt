package yt.javi.nfltweets.view.holders

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.teams_list_header.view.*
import yt.javi.nfltweets.domain.model.Team


class TeamHeaderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val teamConference = view.header_conference

    private val teamDivision = view.header_division

    fun render(team: Team) {
        teamConference.text = team.conference.name
        teamDivision.text = team.division.name
    }
}