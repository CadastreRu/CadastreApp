package ru.dev.android.cadastre.presentation.news.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.dev.android.cadastre.domain.news.entity.News
import ru.dev.android.cadastre.domain.news.usecase.GetNewsByIdUseCase
import javax.inject.Inject

class NewsDetailViewModel @Inject constructor(
    private val getNewsDetailByIdUseCase: GetNewsByIdUseCase
) : ViewModel() {

    private val _newsDetail = MutableLiveData<News>()
    val newsDetail: LiveData<News>
        get() = _newsDetail

    fun getNewsDetail(newsId: String) {
        viewModelScope.launch {
            val news = getNewsDetailByIdUseCase(newsId)
            Log.d("NewsDetailViewModel", news.toString())
            _newsDetail.value = news
        }
    }
}