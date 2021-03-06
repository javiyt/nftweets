package yt.javi.nftweets.infrastructure.repositories.inmemory

import org.junit.Before
import org.junit.Test
import yt.javi.nfltweets.domain.model.team.Team
import yt.javi.nftweets.R.drawable.*
import yt.javi.nftweets.domain.model.Conference.AFC
import yt.javi.nftweets.domain.model.Conference.NFC
import yt.javi.nftweets.domain.model.Division.*


class TeamInMemoryRepositoryTest {
    companion object {
        val teamsList = listOf(
                Team("Bills", "Buffalo", AFC, East, ic_buffalo_bills_logo, "buffalobills", "GoBills"),
                Team("Ravens", "Baltimore", AFC, North, ic_baltimore_ravens_logo, "Ravens", "RavensFlock"),
                Team("Texans", "Houston", AFC, South, ic_houston_texans_logo, "HoustonTexans", "WeAreTexans"),
                Team("Broncos", "Denver", AFC, West, ic_denver_broncos_logo, "Broncos", "Broncos"),
                Team("Cowboys", "Dallas", NFC, East, ic_dallas_cowboys, "dallascowboys", "DallasCowboys"),
                Team("Bears", "Chicago", NFC, North, ic_chicago_bears_logo, "ChicagoBears", "FeedDaBears"),
                Team("Falcons", "Atlanta", NFC, South, ic_atlanta_falcons_logo, "AtlantaFalcons", "RiseUp"),
                Team("Cardinals", "Arizona", NFC, West, ic_arizona_cardinals_logo, "AZCardinals", "BeRedSeeRed")
        )    }

    private lateinit var teamRepository: TeamInMemoryRepository

    @Before
    fun setUp() {
        teamRepository = TeamInMemoryRepository(teamsList)
    }

    @Test
    fun shouldReturnTeamsBasedOnGivenConference() {
        assert(teamRepository.findTeams(AFC, null).size == 4)
    }

    @Test
    fun shouldReturnAnExistingTeam() {
        assert(teamRepository.findTeam("Bills") == teamsList[0])
    }

    @Test(expected = NoSuchElementException::class)
    fun shouldNotReturnAnExistingTeam() {
        teamRepository.findTeam("NonExisting")
    }
}