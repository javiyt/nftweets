package yt.javi.nftweets.domain.model.news

import java.net.URL


interface ArticleRepository {
    fun getLatestNews(url: URL): List<Article>
}