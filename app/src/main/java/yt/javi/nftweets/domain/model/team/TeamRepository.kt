package yt.javi.nftweets.domain.model.team

import yt.javi.nfltweets.domain.model.team.Team
import yt.javi.nftweets.domain.model.Conference
import yt.javi.nftweets.domain.model.Division


interface TeamRepository {
    fun findTeams(conference: Conference?, division: Division?): List<Team>

    fun findTeam(name: String): Team
}