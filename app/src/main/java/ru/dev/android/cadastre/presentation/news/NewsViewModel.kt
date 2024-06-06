package ru.dev.android.cadastre.presentation.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.dev.android.cadastre.data.news.repository.NewsRepositoryImpl
import ru.dev.android.cadastre.domain.news.entity.News
import ru.dev.android.cadastre.domain.news.usecase.GetNewsListUseCase

class NewsViewModel : ViewModel() {

    private val repository = NewsRepositoryImpl()

    private val getNewsListUseCase = GetNewsListUseCase(repository)

    private val _newsList = MutableLiveData<List<News>>()
    val newsList: LiveData<List<News>>
        get() = _newsList

    init {
        viewModelScope.launch {
            _newsList.value = getNewsListUseCase()
        }
    }
}