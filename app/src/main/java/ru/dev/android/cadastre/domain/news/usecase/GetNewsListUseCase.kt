package ru.dev.android.cadastre.domain.news.usecase

import androidx.lifecycle.LiveData
import ru.dev.android.cadastre.domain.news.entity.News
import ru.dev.android.cadastre.domain.news.repository.NewsRepository

class GetNewsListUseCase(private val newsRepository: NewsRepository) {

    operator fun invoke(): LiveData<List<News>> {
        return newsRepository.getNewsList()
    }
}