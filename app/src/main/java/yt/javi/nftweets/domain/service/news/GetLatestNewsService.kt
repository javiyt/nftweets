package yt.javi.nftweets.domain.service.news

import yt.javi.nftweets.domain.model.news.Article
import yt.javi.nftweets.domain.model.news.ArticleRepository
import java.net.URL


class GetLatestNewsService(private val repository: ArticleRepository, private val url: URL) {
    fun getLatestNews(): List<Article> = repository.getLatestNews(url)
}