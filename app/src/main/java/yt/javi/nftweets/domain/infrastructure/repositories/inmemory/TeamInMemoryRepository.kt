package yt.javi.nftweets.domain.infrastructure.repositories.inmemory

import yt.javi.nftweets.domain.model.Conference
import yt.javi.nftweets.domain.model.Division
import yt.javi.nftweets.domain.model.team.Team
import yt.javi.nftweets.domain.model.team.TeamRepository


class TeamInMemoryRepository(private val teams: List<Team>): TeamRepository {
    override fun findTeams(conference: Conference?, division: Division?): List<Team> =
            teams.filter { conference == null || it.conference == conference }
                    .filter { division == null || it.division == division }

    override fun findTeam(name: String): Team = teams.first { it.name == name }
}