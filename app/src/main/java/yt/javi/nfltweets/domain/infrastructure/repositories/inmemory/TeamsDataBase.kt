package yt.javi.nfltweets.domain.infrastructure.repositories.inmemory

import yt.javi.nfltweets.R.drawable.*
import yt.javi.nfltweets.domain.model.Conference.AFC
import yt.javi.nfltweets.domain.model.Conference.NFC
import yt.javi.nfltweets.domain.model.Division.*
import yt.javi.nfltweets.domain.model.team.Team


object TeamsDataBase {
    val teamsList = listOf(
            Team("Bills", "Buffalo", AFC, East, ic_buffalo_bills_logo, "buffalobills"),
            Team("Dolphins", "Miami", AFC, East, ic_miami_dolphins_logo, "MiamiDolphins"),
            Team("Patriots", "New England", AFC, East, ic_new_england_patriots_logo, "Patriots"),
            Team("Jets", "New York", AFC, East, ic_new_york_jets_logo, "nyjets"),
            Team("Ravens", "Baltimore", AFC, North, ic_baltimore_ravens_logo, "Ravens"),
            Team("Bengals", "Cincinnati", AFC, North, ic_cincinnati_bengals_logo, "Bengals"),
            Team("Browns", "Cleveland", AFC, North, ic_cleveland_browns_logo, "Browns"),
            Team("Steelers", "Pittsburgh", AFC, North, ic_pittsburgh_steelers_logo, "Steelers"),
            Team("Texans", "Houston", AFC, South, ic_houston_texans_logo, "HoustonTexans"),
            Team("Colts", "Indianapolis", AFC, South, ic_indianapolis_colts_logo, "Colts"),
            Team("Jaguars", "Jacksonville", AFC, South, ic_jacksonville_jaguars_logo, "Jaguars"),
            Team("Titans", "Tennessee", AFC, South, ic_tennessee_titans_logo, "Titans"),
            Team("Broncos", "Denver", AFC, West, ic_denver_broncos_logo, "Broncos"),
            Team("Chiefs", "Kansas City", AFC, West, ic_kansas_city_chiefs_logo, "Chiefs"),
            Team("Chargers", "Los Angeles", AFC, West, ic_los_angeles_chargers_logo, "Chargers"),
            Team("Raiders", "Oakland", AFC, West, ic_oakland_raiders_logo, "RAIDERS"),
            Team("Cowboys", "Dallas", NFC, East, ic_dallas_cowboys, "dallascowboys"),
            Team("Giants", "New York", NFC, East, ic_new_york_giants_logo, "Giants"),
            Team("Eagles", "Philadelphia", NFC, East, ic_philadelphia_eagles_logo, "Eagles"),
            Team("Redskins", "Washington", NFC, East, ic_washington_redskins_logo, "Redskins"),
            Team("Bears", "Chicago", NFC, North, ic_chicago_bears_logo, "ChicagoBears"),
            Team("Lions", "Detroit", NFC, North, ic_detroit_lions_logo, "Lions"),
            Team("Packers", "Green Bay", NFC, North, ic_green_bay_packers_logo, "packers"),
            Team("Vikings", "Minnesota", NFC, North, ic_minnesota_vikings_logo, "Vikings"),
            Team("Falcons", "Atlanta", NFC, South, ic_atlanta_falcons_logo, "AtlantaFalcons"),
            Team("Panthers", "Carolina", NFC, South, ic_carolina_panthers_logo, "Panthers"),
            Team("Saints", "New Orleans", NFC, South, ic_new_orleans_saints_logo, "Saints"),
            Team("Buccaneers", "Tampa Bay", NFC, South, ic_tampa_bay_buccaneers_logo, "TBBuccaneers"),
            Team("Cardinals", "Arizona", NFC, West, ic_arizona_cardinals_logo, "AZCardinals"),
            Team("Rams", "Los Angeles", NFC, West, ic_los_angeles_rams_logo, "RamsNFL"),
            Team("49ers", "San Francisco", NFC, West, ic_san_francisco_49ers_logo, "49ers"),
            Team("Seahawks", "Seattle", NFC, West, ic_seattle_seahawks_logo, "Seahawks")
    )
}