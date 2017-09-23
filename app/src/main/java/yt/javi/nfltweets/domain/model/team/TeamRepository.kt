package yt.javi.nfltweets.domain.model.team

import yt.javi.nfltweets.domain.model.Conference
import yt.javi.nfltweets.domain.model.Division


interface TeamRepository {
    fun findTeams(conference: Conference?, division: Division?): List<Team>

    fun findTeam(name: String): Team
}