package yt.javi.nftweets.domain.infrastructure.repositories.http

import com.beust.klaxon.JsonObject
import com.beust.klaxon.Parser
import com.beust.klaxon.array
import com.beust.klaxon.string
import yt.javi.nftweets.domain.model.news.Article
import yt.javi.nftweets.domain.model.news.ArticleRepository
import java.net.URL
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*


class ArticleHttpRepository(private val parser: Parser, private val httpReader: HttpReader) : ArticleRepository {
    override fun getLatestNews(url: URL): List<Article> {
        val formatter = SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'", Locale.US)

        return (parser.parse(httpReader.getText(url)) as JsonObject)
                .array<JsonObject>("articles")!!
                .map {
                    Article(
                            it.string("author")!!,
                            it.string("title")!!,
                            it.string("description")!!,
                            URL(it.string("url")),
                            URL(it.string("urlToImage")),
                            Timestamp(formatter.parse(it.string("publishedAt")).time)
                    )
                }
    }

}