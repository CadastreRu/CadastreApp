package ru.dev.android.cadastre.data.api

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query
import ru.dev.android.cadastre.BuildConfig
import ru.dev.android.cadastre.data.news.dto.NewsDto
import ru.dev.android.cadastre.data.news.dto.NewsListDto

interface ApiService {

    @Headers(API_KEY)
    @GET("news")
    suspend fun getNewsList(): NewsListDto

    @Headers(API_KEY)
    @GET("news/{id}")
    suspend fun getNewsDetail(
        @Path("id") newsId: String
    ): NewsListDto

    companion object {

        private const val API_KEY = "Authorization: ${BuildConfig.CADASTRE_API_KEY}"
    }
}