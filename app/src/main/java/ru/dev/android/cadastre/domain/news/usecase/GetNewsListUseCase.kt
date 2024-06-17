package ru.dev.android.cadastre.domain.news.usecase

import ru.dev.android.cadastre.domain.news.entity.News
import ru.dev.android.cadastre.domain.news.repository.NewsRepository
import javax.inject.Inject

class GetNewsListUseCase @Inject constructor(private val newsRepository: NewsRepository) {

    suspend operator fun invoke(): List<News> {
        return newsRepository.getNewsList()
    }
}