package yt.javi.nfltweets.domain.model.team

import yt.javi.nfltweets.domain.model.Conference
import yt.javi.nfltweets.domain.model.Division


data class Team(
        val name: String,
        val city: String,
        val conference: Conference,
        val division: Division,
        val logo: Int,
        val twitterAccount: String,
        val twitterHashTag: String
)