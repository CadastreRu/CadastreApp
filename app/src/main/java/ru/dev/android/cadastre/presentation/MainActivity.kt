package ru.dev.android.cadastre.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import ru.dev.android.cadastre.R
import ru.dev.android.cadastre.presentation.news.NewsViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: NewsViewModel by lazy {
        ViewModelProvider(this)[NewsViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.newsList.observe(this) {
            Log.d("MainActivity", "size: ${it.size}")
        }
    }
}