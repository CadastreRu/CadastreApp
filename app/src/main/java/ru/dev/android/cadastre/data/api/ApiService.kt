package ru.dev.android.cadastre.data.api

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import ru.dev.android.cadastre.BuildConfig
import ru.dev.android.cadastre.data.definition.dto.DefinitionsListDto
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

    @Headers(API_KEY)
    @GET("definitions")
    suspend fun getDefinitionsList(): DefinitionsListDto

    @Headers(API_KEY)
    @GET("definitions/{id}")
    suspend fun getDefinitionDetail(
        @Path("id") defId: String
    ): DefinitionsListDto

    companion object {

        private const val API_KEY = "Authorization: ${BuildConfig.CADASTRE_API_KEY}"
    }
}