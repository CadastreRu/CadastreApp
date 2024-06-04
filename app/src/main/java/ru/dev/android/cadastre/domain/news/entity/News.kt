package ru.dev.android.cadastre.domain.news.entity

data class News(
    val id: String,
    val title: String,
    val type: String,
    val annotation: String,
    val text: String?,
    val date: String,
    val update: String,
    val image: String,
    val thumbnail: String
)