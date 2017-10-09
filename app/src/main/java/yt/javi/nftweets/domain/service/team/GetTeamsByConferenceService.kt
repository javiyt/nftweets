package yt.javi.nftweets.domain.service.team

import yt.javi.nfltweets.domain.model.team.Team
import yt.javi.nftweets.domain.model.Conference
import yt.javi.nftweets.domain.model.team.TeamRepository


class GetTeamsByConferenceService(private val repository: TeamRepository) {
    fun getTeamsByConference(conference: Conference): List<Team> =
            repository.findTeams(conference, null)
}