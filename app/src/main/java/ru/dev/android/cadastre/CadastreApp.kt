package ru.dev.android.cadastre

import android.app.Application
import ru.dev.android.cadastre.di.ApplicationComponent
import ru.dev.android.cadastre.di.DaggerApplicationComponent

class CadastreApp : Application() {

    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory().create(this)
    }

    override fun onCreate() {
        component.inject(this)
        super.onCreate()
    }
}