package yt.javi.nftweets

import android.support.test.espresso.IdlingRegistry
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.schibsted.spain.barista.BaristaAssertions.assertDisplayed
import com.schibsted.spain.barista.BaristaAssertions.assertRecyclerViewItemCount
import com.schibsted.spain.barista.BaristaClickActions.click
import com.schibsted.spain.barista.BaristaViewPagerActions.swipeViewPagerBack
import com.schibsted.spain.barista.BaristaViewPagerActions.swipeViewPagerForward
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import yt.javi.nftweets.ui.main.MainActivity


@RunWith(AndroidJUnit4::class)
class MainActivityInstrumentedTest {
    @Rule @JvmField
    var activityRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test
    fun shouldShowTabsToSelectConferences() {
        assertDisplayed(R.id.tabs)
        assertDisplayed("AFC")
        assertDisplayed("NFC")
    }

    @Test
    fun shouldDisplayAllAFCTeams() {
        swipeViewPagerBack(R.id.pager)
        assertRecyclerViewItemCount(R.id.teams_list, 16)
    }

    @Test
    fun shouldDisplayAllNFCTeams() {
        swipeViewPagerForward(R.id.pager)
        assertDisplayed("NFC East")
    }

    @Test
    fun shouldBePossibleToGoToNews() {
        IdlingRegistry.getInstance().register(activityRule.activity.getEspressoIdlingResource())

        click(R.id.action_show_news)
        assertRecyclerViewItemCount(R.id.news_list, 10)
    }
}