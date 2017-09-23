package yt.javi.nfltweets.domain.service.team

import yt.javi.nfltweets.domain.model.Conference
import yt.javi.nfltweets.domain.model.team.Team
import yt.javi.nfltweets.domain.model.team.TeamRepository


class GetTeamsByConferenceService(private val repository: TeamRepository) {
    fun getTeamsByConference(conference: Conference): List<Team> =
            repository.findTeams(conference, null)
}