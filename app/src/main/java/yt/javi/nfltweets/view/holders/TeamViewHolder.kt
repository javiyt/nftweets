package yt.javi.nfltweets.view.holders

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.teams_list_item.view.*
import yt.javi.nfltweets.domain.model.Team


class TeamViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val teamName = view.team_name

    private val teamCity = view.team_city

    private val teamLogo = view.team_logo

    private val teamConference = view.team_conference

    private val teamDivision = view.team_division

    private val teamTwitterAccount = view.team_twitter

    fun render(team: Team) {
        teamName.text = team.name
        teamCity.text = team.city
        teamLogo.setImageResource(team.logo)
        teamConference.text = team.conference.name
        teamDivision.text = team.division.name
        teamTwitterAccount.text = team.twitterAccount
    }
}