package ru.dev.android.cadastre.domain.news.usecase

import ru.dev.android.cadastre.domain.news.entity.News
import ru.dev.android.cadastre.domain.news.repository.NewsRepository

class GetNewsByIdUseCase(private val newsRepository: NewsRepository) {

    suspend operator fun invoke(newsId: String): News {
        return newsRepository.getNewsById(newsId)
    }
}