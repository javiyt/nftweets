package yt.javi.nfltweets.view.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import yt.javi.nfltweets.R
import yt.javi.nfltweets.domain.Teams
import yt.javi.nfltweets.view.holders.TeamViewHolder


class TeamAdapter(private val onClick: (String) -> Unit) : RecyclerView.Adapter<TeamViewHolder>() {
    private val teams = Teams().teamsList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        return TeamViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.teams_list_item, parent, false)
        )
    }

    override fun getItemCount(): Int = teams.size

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.render(teams[position], onClick)
    }
}