package ru.dev.android.cadastre.data.api

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import ru.dev.android.cadastre.BuildConfig
import ru.dev.android.cadastre.data.definition.dto.DefinitionsListDto
import ru.dev.android.cadastre.data.news.dto.NewsListDto

interface ApiService {

    @GET("news")
    suspend fun getNewsList(): NewsListDto

    @GET("news/{id}")
    suspend fun getNewsDetail(
        @Path("id") newsId: String
    ): NewsListDto

    @GET("definitions")
    suspend fun getDefinitionsList(): DefinitionsListDto

    @GET("definitions/{id}")
    suspend fun getDefinitionDetail(
        @Path("id") defId: String
    ): DefinitionsListDto
}