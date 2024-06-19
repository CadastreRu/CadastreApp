package ru.dev.android.cadastre.data.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import ru.dev.android.cadastre.BuildConfig

object ApiFactory {

    private const val HEADER_REQUEST_KEY = "Authorization"
    private const val BASE_URL = "https://api.cadastre.ru/v1/"

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val originalRequest = chain.request()
            val newRequest = originalRequest
                .newBuilder()
                .url(originalRequest.url)
                .addHeader(HEADER_REQUEST_KEY, BuildConfig.CADASTRE_API_KEY)
                .build()
            chain.proceed(newRequest)
        }.build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    val apiService: ApiService = retrofit.create()
}