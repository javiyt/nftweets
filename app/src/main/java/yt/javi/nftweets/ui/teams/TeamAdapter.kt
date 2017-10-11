package yt.javi.nftweets.ui.teams

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.LayoutInflater
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import kotlinx.android.synthetic.main.teams_list_item.view.*
import yt.javi.nftweets.R
import yt.javi.nftweets.domain.model.Conference
import yt.javi.nftweets.domain.service.team.GetTeamsByConferenceService
import yt.javi.nftweets.ui.twitter.TwitterTimeLineActivity
import yt.javi.nftweets.ui.twitter.TwitterTimeLineActivity.TimelineType.SEARCH
import yt.javi.nftweets.ui.twitter.TwitterTimeLineActivity.TimelineType.USER


class TeamAdapter(private val getTeamsByConferenceService: GetTeamsByConferenceService, private val conference: Conference, private val onClick: (String, String, TwitterTimeLineActivity.TimelineType) -> Unit) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return TeamViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.teams_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val teams = getTeamsByConferenceService.getTeamsByConference(conference)
        holder.itemView.item_header.visibility =
                if (position == 0 || teams[position].division != teams[position - 1].division) VISIBLE else GONE

        (holder as TeamViewHolder).render(teams[position])
        holder.itemView.team_twitter.setOnClickListener {
            onClick.invoke(
                    teams[position].twitterAccount,
                    "${teams[position].city} ${teams[position].name}",
                    USER
            )
        }
        holder.itemView.team_hashtag.setOnClickListener {
            onClick.invoke(
                    teams[position].twitterHashTag,
                    "${teams[position].city} ${teams[position].name}",
                    SEARCH
            )
        }
    }

    override fun getItemCount(): Int = getTeamsByConferenceService.getTeamsByConference(conference).size

    override fun getItemId(position: Int): Long = position.toLong()
}