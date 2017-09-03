package yt.javi.nfltweets.view.holders

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import yt.javi.nfltweets.R
import yt.javi.nfltweets.domain.model.Team


class TeamViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val teamName = view.findViewById<TextView>(R.id.team_name)

    private val teamCity = view.findViewById<TextView>(R.id.team_city)

    private val teamLogo = view.findViewById<ImageView>(R.id.team_logo)

    private val teamConference = view.findViewById<TextView>(R.id.team_conference)

    private val teamDivision = view.findViewById<TextView>(R.id.team_division)

    private val teamTwitterAccount = view.findViewById<TextView>(R.id.team_twitter)

    fun render(team: Team, onClick: (String) -> Unit) {
        teamName.text = team.name
        teamCity.text = team.city
        teamLogo.setImageResource(team.logo)
        teamConference.text = team.conference.name
        teamDivision.text = team.division.name
        teamTwitterAccount.text = team.twitterAccount

        itemView.setOnClickListener { onClick.invoke(team.twitterAccount) }
    }
}