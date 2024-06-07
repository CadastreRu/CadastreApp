package ru.dev.android.cadastre.data.news.mapper

import ru.dev.android.cadastre.data.news.dto.NewsDto
import ru.dev.android.cadastre.data.news.dto.NewsListDto
import ru.dev.android.cadastre.domain.news.entity.News

class NewsMapper {

    private fun mapDtoToEntity(newsDto: NewsDto): News {
        return News(
            id = newsDto.id ?: "",
            title = newsDto.title ?: "",
            annotation = newsDto.annotation ?: "",
            text = newsDto.text ?: "",
            date = newsDto.date ?: "",
            update = newsDto.update ?: "",
            image = newsDto.image ?: "",
            thumbnail = newsDto.thumbnail ?: ""
        )
    }

    fun mapDtoListOneNewsToEntity(newsListDto: NewsListDto): News {
        val item = newsListDto.newsList?.get(0)
        return if (item != null) {
            mapDtoToEntity(item)
        } else {
            throw RuntimeException("News is null")
        }
    }

    fun mapDtoListToEntityList(newsListDto: NewsListDto): List<News> {
        return newsListDto.newsList?.map {
            mapDtoToEntity(it)
        }?.sortedByDescending { it.date } ?: emptyList()
    }
}