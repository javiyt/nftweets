package yt.javi.nfltweets.domain

import yt.javi.nfltweets.R.drawable.*
import yt.javi.nfltweets.domain.model.Conferences.AFC
import yt.javi.nfltweets.domain.model.Divisions.East
import yt.javi.nfltweets.domain.model.Team


class Teams {
    val teamsList = listOf(
            Team("Bills", "Buffalo", AFC, East, ic_buffalo_bills_logo, "buffalobills"),
            Team("Dolphins", "Miami", AFC, East, ic_miami_dolphins_logo, "MiamiDolphins"),
            Team("Patriots", "New England", AFC, East, ic_new_england_patriots_logo, "Patriots"),
            Team("Jets", "New York", AFC, East, ic_new_york_jets_logo, "nyjets")
    )
}