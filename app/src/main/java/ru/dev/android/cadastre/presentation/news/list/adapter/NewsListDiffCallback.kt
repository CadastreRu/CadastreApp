package ru.dev.android.cadastre.presentation.news.list.adapter

import androidx.recyclerview.widget.DiffUtil
import ru.dev.android.cadastre.domain.news.entity.News

object NewsListDiffCallback : DiffUtil.ItemCallback<News>() {

    override fun areItemsTheSame(oldItem: News, newItem: News): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: News, newItem: News): Boolean {
        return oldItem == newItem
    }
}