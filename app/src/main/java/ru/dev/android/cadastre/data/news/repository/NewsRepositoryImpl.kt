package ru.dev.android.cadastre.data.news.repository

import ru.dev.android.cadastre.data.api.ApiFactory
import ru.dev.android.cadastre.data.news.mapper.NewsMapper
import ru.dev.android.cadastre.domain.news.entity.News
import ru.dev.android.cadastre.domain.news.repository.NewsRepository

class NewsRepositoryImpl : NewsRepository {

    private val service = ApiFactory.apiService
    private val mapper = NewsMapper()

    override suspend fun getNewsById(newsId: String): News {
        TODO("Not yet implemented")
    }

    override suspend fun getNewsList(): List<News> {
        return mapper.mapDtoListToEntityList(service.getNewsList())
    }

    override fun loadNews() {
        TODO("Not yet implemented")
    }
}