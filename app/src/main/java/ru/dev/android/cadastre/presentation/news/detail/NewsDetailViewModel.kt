package ru.dev.android.cadastre.presentation.news.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.dev.android.cadastre.data.news.repository.NewsRepositoryImpl
import ru.dev.android.cadastre.domain.news.entity.News

class NewsDetailViewModel : ViewModel() {

    private val repository = NewsRepositoryImpl()

    private val _newsDetail = MutableLiveData<News>()
    val newsDetail: LiveData<News>
        get() = _newsDetail

    fun getNewsDetail(newsId: String) {
        viewModelScope.launch {
            val news = repository.getNewsById(newsId)
            Log.d("NewsDetailViewModel", news.toString())
            _newsDetail.value = news
        }
    }
}