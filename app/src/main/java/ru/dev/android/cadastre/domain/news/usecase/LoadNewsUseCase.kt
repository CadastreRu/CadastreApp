package ru.dev.android.cadastre.domain.news.usecase

import ru.dev.android.cadastre.domain.news.repository.NewsRepository

class LoadNewsUseCase(private val newsRepository: NewsRepository) {

    operator fun invoke() {
        newsRepository.loadNews()
    }
}