package yt.javi.nftweets.ui.news

import android.support.v7.widget.RecyclerView.Adapter
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.LayoutInflater
import android.view.ViewGroup
import yt.javi.nftweets.R
import yt.javi.nftweets.domain.model.news.Article


class ArticleAdapter(private val articles: List<Article>) : Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ArticleViewHolder(
                LayoutInflater.from(parent.context).inflate(
                        R.layout.article_list_item,
                        parent,
                        false
                )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        (holder as ArticleViewHolder).render(articles[position])
    }

    override fun getItemCount(): Int = articles.size
}