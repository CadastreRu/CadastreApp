package ru.dev.android.cadastre.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import ru.dev.android.cadastre.CadastreApp
import ru.dev.android.cadastre.presentation.MainActivity
import ru.dev.android.cadastre.presentation.definition.detail.DefinitionDetailFragment
import ru.dev.android.cadastre.presentation.definition.list.DefinitionsListFragment
import ru.dev.android.cadastre.presentation.news.detail.NewsDetailFragment
import ru.dev.android.cadastre.presentation.news.list.NewsListFragment

@ApplicationScope
@Component(
    modules = [
        DataModule::class,
        ViewModelModule::class
    ]
)
interface ApplicationComponent {

    fun inject(activity: MainActivity)

    fun inject(fragment: NewsListFragment)

    fun inject(fragment: NewsDetailFragment)

    fun inject(fragment: DefinitionsListFragment)

    fun inject(fragment: DefinitionDetailFragment)

    fun inject(application: CadastreApp)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}