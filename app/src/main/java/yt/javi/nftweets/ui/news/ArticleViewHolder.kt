package yt.javi.nftweets.ui.news

import android.support.v7.widget.RecyclerView
import android.text.format.DateUtils
import android.view.View
import kotlinx.android.synthetic.main.article_list_item.view.*
import yt.javi.nftweets.domain.model.news.Article


class ArticleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val title = view.article_title

    private val description = view.article_description

    private val author = view.article_author

    private val published = view.article_published

    fun render(article: Article) {
        title.text = article.title
        description.text = article.description
        author.text = article.author
        published.text = DateUtils.getRelativeTimeSpanString(article.publishedAt.time)
    }
}