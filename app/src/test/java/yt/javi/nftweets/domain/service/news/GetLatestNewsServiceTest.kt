package yt.javi.nftweets.domain.service.news

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.BDDMockito
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule
import yt.javi.nftweets.domain.model.news.Article
import yt.javi.nftweets.domain.model.news.ArticleRepository
import java.net.URL
import java.util.*

class GetLatestNewsServiceTest {
    @Rule
    @JvmField
    val rule: MockitoRule = MockitoJUnit.rule()

    private lateinit var getLatestNewsService: GetLatestNewsService

    @Mock
    private lateinit var repository: ArticleRepository

    @Mock
    private lateinit var article: Article

    @Mock
    private lateinit var url: URL

    @Before
    fun setUp() {
        getLatestNewsService = GetLatestNewsService(repository, url)
    }

    @Test
    fun shouldBePossibleToFindTeamsByConference() {
        BDDMockito.given(repository.getLatestNews(url)).willReturn(Collections.singletonList(article))

        val articles = getLatestNewsService.getLatestNews()
        assert(articles.size == 1)
        assert(articles[0] == article)
    }
}