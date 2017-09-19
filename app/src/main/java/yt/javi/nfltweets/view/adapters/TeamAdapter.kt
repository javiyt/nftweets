package yt.javi.nfltweets.view.adapters

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.teams_list_item.view.*
import yt.javi.nfltweets.R
import yt.javi.nfltweets.domain.Teams
import yt.javi.nfltweets.view.holders.TeamViewHolder


class TeamAdapter(private val conference: String, private val onClick: (String) -> Unit) : RecyclerView.Adapter<ViewHolder>() {
    private val teams = Teams().teamsList.filter { it.conference.name == conference }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return TeamViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.teams_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.item_header.visibility =
                if (position == 0 || teams[position].division != teams[position - 1].division) View.VISIBLE else View.GONE

        (holder as TeamViewHolder).render(teams[position])
        holder.itemView.setOnClickListener { onClick.invoke(teams[position].twitterAccount) }
    }

    override fun getItemCount(): Int = teams.size

    override fun getItemId(position: Int): Long = position.toLong()
}