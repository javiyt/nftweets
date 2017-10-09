package yt.javi.nftweets.domain.infrastructure.repositories.http

import com.beust.klaxon.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.BDDMockito
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule
import java.net.URL
import java.util.Collections.singletonList

class ArticleHttpRepositoryTest {
    @Rule
    @JvmField
    val rule: MockitoRule = MockitoJUnit.rule()

    private lateinit var articleHttpRepository: ArticleHttpRepository

    @Mock
    private lateinit var parser: Parser

    @Mock
    private lateinit var url: URL

    @Mock
    private lateinit var httpReader: HttpReader

    @Mock
    private lateinit var jsonObject: JsonObject

    @Mock
    private lateinit var stringBuilder: StringBuilder

    private lateinit var jsonArray: JsonArray<JsonObject>

    @Before
    fun setUp() {
        jsonArray = JsonArray(singletonList(jsonObject))
        articleHttpRepository = ArticleHttpRepository(parser, httpReader)
    }

    @Test
    fun shouldBePossibleToGetLatestNewsFromURL() {
        BDDMockito.given(httpReader.getText(url)).willReturn(stringBuilder)
        BDDMockito.given(parser.parse(stringBuilder)).willReturn(jsonObject)
        BDDMockito.given(jsonObject.array<JsonObject>("articles")).willReturn(jsonArray)
        BDDMockito.given(jsonObject.string("author")).willReturn("test")
        BDDMockito.given(jsonObject.string("title")).willReturn("test")
        BDDMockito.given(jsonObject.string("description")).willReturn("test")
        BDDMockito.given(jsonObject.string("url")).willReturn("http://test.com")
        BDDMockito.given(jsonObject.string("urlToImage")).willReturn("http://test.com")
        BDDMockito.given(jsonObject.string("publishedAt")).willReturn("2017-09-26T23:21:00Z")

        assert(articleHttpRepository.getLatestNews(url).size == 1)
    }
}