package ru.dev.android.cadastre.domain.news.repository

import androidx.lifecycle.LiveData
import ru.dev.android.cadastre.domain.news.entity.News

interface NewsRepository {

    suspend fun getNewsById(newsId: String): News

    fun getNewsList(): LiveData<List<News>>

    fun loadNews()
}