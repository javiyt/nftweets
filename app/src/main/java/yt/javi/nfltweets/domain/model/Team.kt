package yt.javi.nfltweets.domain.model


data class Team(
        val name: String,
        val city: String,
        val conference: Conferences,
        val division: Divisions,
        val logo: Int, val twitterAccount: String
)