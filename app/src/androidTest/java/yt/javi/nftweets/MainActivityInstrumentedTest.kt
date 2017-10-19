package yt.javi.nftweets

import android.support.test.espresso.IdlingRegistry
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.github.tomakehurst.wiremock.client.WireMock.aResponse
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo
import com.github.tomakehurst.wiremock.junit.WireMockRule
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
    @Rule
    @JvmField
    var activityRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Rule
    @JvmField
    var wireMockRule = WireMockRule(9200)

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
        externalStubs()

        IdlingRegistry.getInstance().register(activityRule.activity.getEspressoIdlingResource())

        click(R.id.action_show_news)
        assertRecyclerViewItemCount(R.id.news_list, 10)
    }

    private fun externalStubs() {
        stubFor(
                get(urlPathEqualTo("/news"))
                        .willReturn(aResponse()
                                .withStatus(200)
                                .withBody("{\n" +
                                        "  \"status\":\"ok\",\n" +
                                        "  \"source\":\"nfl-news\",\n" +
                                        "  \"sortBy\":\"latest\",\n" +
                                        "  \"articles\":[\n" +
                                        "    {\n" +
                                        "      \"author\":\"Bethany Longstaff\",\n" +
                                        "      \"title\":\"sed vestibulum sit amet cursus id turpis integer aliquet massa\",\n" +
                                        "      \"description\":\"in purus eu magna vulputate luctus cum sociis natoque penatibus et magnis dis parturient\",\n" +
                                        "      \"url\":\"https://slate.com/at/velit/eu.json\",\n" +
                                        "      \"urlToImage\":\"http://dummyimage.com/191x200.png/ff4444/ffffff\",\n" +
                                        "      \"publishedAt\":\"2017-04-17T09:21:05Z\"\n" +
                                        "    },\n" +
                                        "    {\n" +
                                        "      \"author\":\"Augy Copeland\",\n" +
                                        "      \"title\":\"non velit nec nisi vulputate nonummy maecenas tincidunt lacus at\",\n" +
                                        "      \"description\":\"dolor morbi vel lectus in quam fringilla rhoncus mauris enim leo rhoncus sed vestibulum sit\",\n" +
                                        "      \"url\":\"https://rakuten.co.jp/volutpat/eleifend/donec/ut/dolor.jpg\",\n" +
                                        "      \"urlToImage\":\"http://dummyimage.com/158x250.png/cc0000/ffffff\",\n" +
                                        "      \"publishedAt\":\"2017-01-08T18:56:31Z\"\n" +
                                        "    },\n" +
                                        "    {\n" +
                                        "      \"author\":\"Murial Gallard\",\n" +
                                        "      \"title\":\"sit amet turpis elementum ligula vehicula consequat morbi a ipsum\",\n" +
                                        "      \"description\":\"tristique est et tempus semper est quam pharetra magna ac consequat metus sapien ut nunc vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere\",\n" +
                                        "      \"url\":\"https://eventbrite.com/justo/morbi/ut/odio/cras/mi.json\",\n" +
                                        "      \"urlToImage\":\"http://dummyimage.com/196x182.png/dddddd/000000\",\n" +
                                        "      \"publishedAt\":\"2017-02-16T17:49:00Z\"\n" +
                                        "    },\n" +
                                        "    {\n" +
                                        "      \"author\":\"Reginauld Mullin\",\n" +
                                        "      \"title\":\"suscipit ligula in lacus curabitur at ipsum ac tellus semper\",\n" +
                                        "      \"description\":\"bibendum imperdiet nullam orci pede venenatis non sodales sed tincidunt eu felis fusce posuere felis sed lacus\",\n" +
                                        "      \"url\":\"http://samsung.com/non.html\",\n" +
                                        "      \"urlToImage\":\"http://dummyimage.com/201x175.bmp/5fa2dd/ffffff\",\n" +
                                        "      \"publishedAt\":\"2017-07-22T03:58:10Z\"\n" +
                                        "    },\n" +
                                        "    {\n" +
                                        "      \"author\":\"Clare Stuckey\",\n" +
                                        "      \"title\":\"et magnis dis parturient montes nascetur ridiculus mus vivamus vestibulum\",\n" +
                                        "      \"description\":\"fusce lacus purus aliquet at feugiat non pretium quis lectus suspendisse potenti in eleifend quam a odio in hac habitasse platea dictumst\",\n" +
                                        "      \"url\":\"http://goo.gl/praesent.png\",\n" +
                                        "      \"urlToImage\":\"http://dummyimage.com/124x170.png/dddddd/000000\",\n" +
                                        "      \"publishedAt\":\"2017-08-01T11:19:44Z\"\n" +
                                        "    },\n" +
                                        "    {\n" +
                                        "      \"author\":\"Carley Heskin\",\n" +
                                        "      \"title\":\"amet nulla quisque arcu libero rutrum ac lobortis vel dapibus at diam\",\n" +
                                        "      \"description\":\"porttitor id consequat in consequat ut nulla sed accumsan felis ut at dolor quis odio consequat varius integer ac leo pellentesque ultrices mattis odio donec\",\n" +
                                        "      \"url\":\"http://vinaora.com/nisi/eu/orci/mauris/lacinia.html\",\n" +
                                        "      \"urlToImage\":\"http://dummyimage.com/224x131.jpg/5fa2dd/ffffff\",\n" +
                                        "      \"publishedAt\":\"2017-02-20T03:27:53Z\"\n" +
                                        "    },\n" +
                                        "    {\n" +
                                        "      \"author\":\"Hort Esposita\",\n" +
                                        "      \"title\":\"cras mi pede malesuada in imperdiet et commodo vulputate justo\",\n" +
                                        "      \"description\":\"faucibus accumsan odio curabitur convallis duis consequat dui nec nisi volutpat eleifend donec ut dolor morbi vel\",\n" +
                                        "      \"url\":\"https://zimbio.com/pulvinar/lobortis/est/phasellus/sit.json\",\n" +
                                        "      \"urlToImage\":\"http://dummyimage.com/111x113.bmp/5fa2dd/ffffff\",\n" +
                                        "      \"publishedAt\":\"2017-05-24T06:09:25Z\"\n" +
                                        "    },\n" +
                                        "    {\n" +
                                        "      \"author\":\"Kylie Aitken\",\n" +
                                        "      \"title\":\"parturient montes nascetur ridiculus mus etiam vel augue vestibulum rutrum rutrum neque\",\n" +
                                        "      \"description\":\"libero ut massa volutpat convallis morbi odio odio elementum eu interdum eu tincidunt in leo maecenas pulvinar lobortis est phasellus sit amet erat nulla\",\n" +
                                        "      \"url\":\"http://rediff.com/sed/vestibulum/sit/amet/cursus/id/turpis.aspx\",\n" +
                                        "      \"urlToImage\":\"http://dummyimage.com/139x222.jpg/ff4444/ffffff\",\n" +
                                        "      \"publishedAt\":\"2016-11-12T19:54:12Z\"\n" +
                                        "    },\n" +
                                        "    {\n" +
                                        "      \"author\":\"Abbye Goundry\",\n" +
                                        "      \"title\":\"tortor duis mattis egestas metus aenean fermentum donec ut mauris eget\",\n" +
                                        "      \"description\":\"aliquam sit amet diam in magna bibendum imperdiet nullam orci pede venenatis non sodales sed tincidunt eu felis fusce posuere felis sed\",\n" +
                                        "      \"url\":\"http://1und1.de/pede.html\",\n" +
                                        "      \"urlToImage\":\"http://dummyimage.com/201x120.jpg/cc0000/ffffff\",\n" +
                                        "      \"publishedAt\":\"2017-06-10T13:13:44Z\"\n" +
                                        "    },\n" +
                                        "    {\n" +
                                        "      \"author\":\"Kristi Ledwich\",\n" +
                                        "      \"title\":\"sit amet nulla quisque arcu libero rutrum ac lobortis vel dapibus\",\n" +
                                        "      \"description\":\"nibh ligula nec sem duis aliquam convallis nunc proin at turpis a pede posuere nonummy integer non velit donec diam neque vestibulum eget vulputate ut ultrices\",\n" +
                                        "      \"url\":\"https://mtv.com/amet/eleifend/pede/libero.aspx\",\n" +
                                        "      \"urlToImage\":\"http://dummyimage.com/143x217.jpg/cc0000/ffffff\",\n" +
                                        "      \"publishedAt\":\"2017-03-03T07:36:19Z\"\n" +
                                        "    }\n" +
                                        "  ]\n" +
                                        "}"))
        )
    }
}