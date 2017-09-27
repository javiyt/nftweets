package yt.javi.nftweets.view.adapters

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.teams_list_item.view.*
import yt.javi.nftweets.R
import yt.javi.nftweets.domain.model.Conference
import yt.javi.nftweets.domain.service.team.GetTeamsByConferenceService
import yt.javi.nftweets.view.holders.TeamViewHolder


class TeamAdapter(private val getTeamsByConferenceService: GetTeamsByConferenceService, private val conference: Conference, private val onClick: (String, String) -> Unit) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return TeamViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.teams_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val teams = getTeamsByConferenceService.getTeamsByConference(conference)
        holder.itemView.item_header.visibility =
                if (position == 0 || teams[position].division != teams[position - 1].division) View.VISIBLE else View.GONE

        (holder as TeamViewHolder).render(teams[position])
        holder.itemView.setOnClickListener { onClick.invoke(
                teams[position].twitterAccount,
                "${teams[position].city} ${teams[position].name}"
        ) }
    }

    override fun getItemCount(): Int = getTeamsByConferenceService.getTeamsByConference(conference).size

    override fun getItemId(position: Int): Long = position.toLong()
}