package ru.dev.android.cadastre.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.dev.android.cadastre.presentation.definition.detail.DefinitionDetailViewModel
import ru.dev.android.cadastre.presentation.definition.list.DefinitionsListViewModel
import ru.dev.android.cadastre.presentation.news.detail.NewsDetailViewModel
import ru.dev.android.cadastre.presentation.news.list.NewsListViewModel

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(NewsListViewModel::class)
    fun bindNewsListViewModel(viewModel: NewsListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(NewsDetailViewModel::class)
    fun bindNewsDetailViewModel(viewModel: NewsDetailViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DefinitionsListViewModel::class)
    fun bindDefinitionListViewModel(viewModel: DefinitionsListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DefinitionDetailViewModel::class)
    fun bindDefinitionDetailViewModel(viewModel: DefinitionDetailViewModel): ViewModel
}