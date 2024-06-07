package ru.dev.android.cadastre.presentation.news.list.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import ru.dev.android.cadastre.databinding.ItemNewsBinding
import ru.dev.android.cadastre.domain.news.entity.News

class NewsListAdapter(
    private val context: Context
) : ListAdapter<News, NewsListViewHolder>(NewsListDiffCallback) {

    var onNewsItemClickListener: ((News) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsListViewHolder {
        val binding = ItemNewsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return NewsListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsListViewHolder, position: Int) {
        val news = getItem(position)
        with(holder.binding) {
            Glide
                .with(context)
                .load(news.thumbnail)
                .into(newsImage)
            newsTitle.text = news.title
            newsDate.text = news.date
            root.setOnClickListener {
                onNewsItemClickListener?.invoke(news)
            }
        }
    }
}