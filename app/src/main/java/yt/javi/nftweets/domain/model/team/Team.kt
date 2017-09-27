package yt.javi.nftweets.domain.model.team

import yt.javi.nftweets.domain.model.Conference
import yt.javi.nftweets.domain.model.Division


data class Team(
        val name: String,
        val city: String,
        val conference: Conference,
        val division: Division,
        val logo: Int,
        val twitterAccount: String
)