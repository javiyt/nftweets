package yt.javi.nftweets.domain.service.team

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule
import yt.javi.nfltweets.domain.model.team.Team
import yt.javi.nftweets.domain.model.Conference
import yt.javi.nftweets.domain.model.team.TeamRepository
import java.util.Collections.singletonList

class GetTeamsByConferenceServiceTest {
    @Rule @JvmField
    val rule: MockitoRule = MockitoJUnit.rule()

    private lateinit var getTeamsByConferenceService: GetTeamsByConferenceService

    @Mock
    private lateinit var repository: TeamRepository

    @Mock
    private lateinit var team: Team

    @Before
    fun setUp() {
        getTeamsByConferenceService = GetTeamsByConferenceService(repository)
    }

    @Test
    fun shouldBePossibleToFindTeamsByConference() {
        given(repository.findTeams(Conference.AFC, null)).willReturn(singletonList(team))

        val teams = getTeamsByConferenceService.getTeamsByConference(Conference.AFC)
        assert(teams.size == 1)
        assert(teams[0] == team)
    }
}