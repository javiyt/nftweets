package yt.javi.nftweets.infrastructure.repositories.http

import com.beust.klaxon.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.BDDMockito
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule
import java.net.URL

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
    private lateinit var jsonArticles: JsonObject

    @Mock
    private lateinit var jsonArticle1: JsonObject

    @Mock
    private lateinit var jsonArticle2: JsonObject

    @Mock
    private lateinit var stringBuilder: StringBuilder

    private lateinit var jsonArray: JsonArray<JsonObject>

    @Before
    fun setUp() {
        jsonArray = JsonArray(arrayListOf(jsonArticle1, jsonArticle2))
        articleHttpRepository = ArticleHttpRepository(parser, httpReader)
    }

    @Test
    fun shouldBePossibleToGetLatestNewsFromURL() {
        BDDMockito.given(httpReader.getText(url)).willReturn(stringBuilder)
        BDDMockito.given(parser.parse(stringBuilder)).willReturn(jsonArticles)
        BDDMockito.given(jsonArticles.array<JsonObject>("articles")).willReturn(jsonArray)
        BDDMockito.given(jsonArticle1.string("author")).willReturn("test")
        BDDMockito.given(jsonArticle1.string("title")).willReturn("test")
        BDDMockito.given(jsonArticle1.string("description")).willReturn("test")
        BDDMockito.given(jsonArticle1.string("url")).willReturn("http://test.com")
        BDDMockito.given(jsonArticle1.string("urlToImage")).willReturn("http://test.com")
        BDDMockito.given(jsonArticle1.string("publishedAt")).willReturn("2017-09-26T23:21:00Z")
        BDDMockito.given(jsonArticle2.string("author")).willReturn("test2")
        BDDMockito.given(jsonArticle2.string("title")).willReturn("test2")
        BDDMockito.given(jsonArticle2.string("description")).willReturn("test2")
        BDDMockito.given(jsonArticle2.string("url")).willReturn("http://test2.com")
        BDDMockito.given(jsonArticle2.string("urlToImage")).willReturn("http://test2.com")
        BDDMockito.given(jsonArticle2.string("publishedAt")).willReturn("2017-09-26T23:22:00Z")

        assert(articleHttpRepository.getLatestNews(url).size == 2)
        assert(articleHttpRepository.getLatestNews(url)[0].title == jsonArticle2.string("title"))
    }
}