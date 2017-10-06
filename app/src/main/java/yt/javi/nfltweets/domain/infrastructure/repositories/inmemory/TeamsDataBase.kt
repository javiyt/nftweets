package yt.javi.nfltweets.domain.infrastructure.repositories.inmemory

import yt.javi.nfltweets.R.drawable.*
import yt.javi.nfltweets.domain.model.Conference.AFC
import yt.javi.nfltweets.domain.model.Conference.NFC
import yt.javi.nfltweets.domain.model.Division.*
import yt.javi.nfltweets.domain.model.team.Team


object TeamsDataBase {
    val teamsList = listOf(
            Team("Bills", "Buffalo", AFC, East, ic_buffalo_bills_logo, "buffalobills", "GoBills"),
            Team("Dolphins", "Miami", AFC, East, ic_miami_dolphins_logo, "MiamiDolphins", "FinsUp"),
            Team("Patriots", "New England", AFC, East, ic_new_england_patriots_logo, "Patriots", "Patriots"),
            Team("Jets", "New York", AFC, East, ic_new_york_jets_logo, "nyjets", "JetUp"),
            Team("Ravens", "Baltimore", AFC, North, ic_baltimore_ravens_logo, "Ravens", "RavensFlock"),
            Team("Bengals", "Cincinnati", AFC, North, ic_cincinnati_bengals_logo, "Bengals", "WhoDey"),
            Team("Browns", "Cleveland", AFC, North, ic_cleveland_browns_logo, "Browns", "DawgPound"),
            Team("Steelers", "Pittsburgh", AFC, North, ic_pittsburgh_steelers_logo, "Steelers", "HereWeGo"),
            Team("Texans", "Houston", AFC, South, ic_houston_texans_logo, "HoustonTexans", "WeAreTexans"),
            Team("Colts", "Indianapolis", AFC, South, ic_indianapolis_colts_logo, "Colts", "ForTheShoe"),
            Team("Jaguars", "Jacksonville", AFC, South, ic_jacksonville_jaguars_logo, "Jaguars", "Jaguars"),
            Team("Titans", "Tennessee", AFC, South, ic_tennessee_titans_logo, "Titans", "TitanUp"),
            Team("Broncos", "Denver", AFC, West, ic_denver_broncos_logo, "Broncos", "Broncos"),
            Team("Chiefs", "Kansas City", AFC, West, ic_kansas_city_chiefs_logo, "Chiefs", "Chiefs"),
            Team("Chargers", "Los Angeles", AFC, West, ic_los_angeles_chargers_logo, "Chargers", "Chargers"),
            Team("Raiders", "Oakland", AFC, West, ic_oakland_raiders_logo, "RAIDERS", "RaiderNation"),
            Team("Cowboys", "Dallas", NFC, East, ic_dallas_cowboys, "dallascowboys", "DallasCowboys"),
            Team("Giants", "New York", NFC, East, ic_new_york_giants_logo, "Giants", "GiantsPride"),
            Team("Eagles", "Philadelphia", NFC, East, ic_philadelphia_eagles_logo, "Eagles", "FlyEaglesFly"),
            Team("Redskins", "Washington", NFC, East, ic_washington_redskins_logo, "Redskins", "HTTR"),
            Team("Bears", "Chicago", NFC, North, ic_chicago_bears_logo, "ChicagoBears", "FeedDaBears"),
            Team("Lions", "Detroit", NFC, North, ic_detroit_lions_logo, "Lions", "OnePride"),
            Team("Packers", "Green Bay", NFC, North, ic_green_bay_packers_logo, "packers", "GoPackGo"),
            Team("Vikings", "Minnesota", NFC, North, ic_minnesota_vikings_logo, "Vikings", "Skol"),
            Team("Falcons", "Atlanta", NFC, South, ic_atlanta_falcons_logo, "AtlantaFalcons", "RiseUp"),
            Team("Panthers", "Carolina", NFC, South, ic_carolina_panthers_logo, "Panthers", "KeepPounding"),
            Team("Saints", "New Orleans", NFC, South, ic_new_orleans_saints_logo, "Saints", "Saints50"),
            Team("Buccaneers", "Tampa Bay", NFC, South, ic_tampa_bay_buccaneers_logo, "TBBuccaneers", "SiegeTheDay"),
            Team("Cardinals", "Arizona", NFC, West, ic_arizona_cardinals_logo, "AZCardinals", "BeRedSeeRed"),
            Team("Rams", "Los Angeles", NFC, West, ic_los_angeles_rams_logo, "RamsNFL", "MobSquad"),
            Team("49ers", "San Francisco", NFC, West, ic_san_francisco_49ers_logo, "49ers", "GoNiners"),
            Team("Seahawks", "Seattle", NFC, West, ic_seattle_seahawks_logo, "Seahawks", "WeAre12")
    )
}