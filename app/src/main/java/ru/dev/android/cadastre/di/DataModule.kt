package ru.dev.android.cadastre.di

import android.app.Application
import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.dev.android.cadastre.data.api.ApiFactory
import ru.dev.android.cadastre.data.api.ApiService
import ru.dev.android.cadastre.data.definition.local.db.DefinitionDao
import ru.dev.android.cadastre.data.definition.repository.DefinitionsRepositoryImpl
import ru.dev.android.cadastre.data.local.AppDatabase
import ru.dev.android.cadastre.data.news.repository.NewsRepositoryImpl
import ru.dev.android.cadastre.domain.definitions.repository.DefinitionsRepository
import ru.dev.android.cadastre.domain.news.repository.NewsRepository

@Module
interface DataModule {

    @Binds
    @ApplicationScope
    fun bindNewsRepository(impl: NewsRepositoryImpl): NewsRepository

    @Binds
    @ApplicationScope
    fun bindDefinitionsRepository(impl: DefinitionsRepositoryImpl): DefinitionsRepository

    companion object {

        @Provides
        @ApplicationScope
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }

        @Provides
        @ApplicationScope
        fun provideDefinitionDao(
            application: Application
        ): DefinitionDao {
            return AppDatabase.getInstance(application).definitionDao()
        }
    }
}