package yt.javi.nfltweets.view.holders

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.teams_list_item.view.*
import yt.javi.nfltweets.domain.model.team.Team


class TeamViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val headerConference = view.header_conference

    private val teamName = view.team_name

    private val teamCity = view.team_city

    private val teamLogo = view.team_logo

    private val teamTwitterAccount = view.team_twitter

    private val teamtTwitterHashtag = view.team_hashtag

    fun render(team: Team) {
        headerConference.text = "${team.conference.name} ${team.division.name}"
        teamName.text = team.name
        teamCity.text = team.city
        teamLogo.setImageResource(team.logo)
        teamTwitterAccount.text = team.twitterAccount
        teamtTwitterHashtag.text = team.twitterHashTag
    }
}