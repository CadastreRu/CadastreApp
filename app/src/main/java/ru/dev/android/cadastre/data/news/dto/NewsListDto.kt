package ru.dev.android.cadastre.data.news.dto

import com.google.gson.annotations.SerializedName

data class NewsListDto(
    @SerializedName("data")
    val newsList: List<NewsDto>?
)