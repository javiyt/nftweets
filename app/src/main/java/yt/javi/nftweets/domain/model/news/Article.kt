package yt.javi.nftweets.domain.model.news

import java.net.URL
import java.sql.Timestamp


data class Article(
        val author: String,
        val title: String,
        val description: String,
        val url: URL,
        val urlToImage: URL,
        val publishedAt: Timestamp
)