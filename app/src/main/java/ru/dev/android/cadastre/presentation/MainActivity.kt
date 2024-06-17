package ru.dev.android.cadastre.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.dev.android.cadastre.CadastreApp
import ru.dev.android.cadastre.R

class MainActivity : AppCompatActivity() {

    private val component by lazy {
        (application as CadastreApp).component
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}