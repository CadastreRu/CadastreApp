package ru.dev.android.cadastre.data.news.repository

import ru.dev.android.cadastre.data.api.ApiService
import ru.dev.android.cadastre.data.news.mapper.NewsMapper
import ru.dev.android.cadastre.domain.news.entity.News
import ru.dev.android.cadastre.domain.news.repository.NewsRepository
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val service: ApiService,
    private val mapper: NewsMapper
) : NewsRepository {

    override suspend fun getNewsById(newsId: String): News {
        return mapper.mapDtoListOneNewsToEntity(service.getNewsDetail(newsId))
    }

    override suspend fun getNewsList(): List<News> {
        return mapper.mapDtoListToEntityList(service.getNewsList())
    }
}