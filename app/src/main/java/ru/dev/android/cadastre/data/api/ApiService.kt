package ru.dev.android.cadastre.data.api

import retrofit2.http.GET
import retrofit2.http.Headers
import ru.dev.android.cadastre.BuildConfig
import ru.dev.android.cadastre.data.news.dto.NewsListDto

interface ApiService {

    @Headers(API_KEY)
    @GET("news")
    suspend fun getNewsList(): NewsListDto

    companion object {

        private const val API_KEY = "Authorization: ${BuildConfig.CADASTRE_API_KEY}"
    }
}