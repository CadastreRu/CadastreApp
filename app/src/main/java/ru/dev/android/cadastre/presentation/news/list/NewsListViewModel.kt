package ru.dev.android.cadastre.presentation.news.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.dev.android.cadastre.domain.news.entity.News
import ru.dev.android.cadastre.domain.news.usecase.GetNewsListUseCase
import javax.inject.Inject

class NewsListViewModel @Inject constructor(
    private val getNewsListUseCase: GetNewsListUseCase
) : ViewModel() {

    private val _newsList = MutableLiveData<List<News>>()
    val newsList: LiveData<List<News>>
        get() = _newsList

    private val _newsLoadProgress = MutableLiveData<Boolean>()
    val newsLoadProgress: LiveData<Boolean>
        get() = _newsLoadProgress

    init {
        viewModelScope.launch {
            _newsLoadProgress.value = true
            _newsList.value = getNewsListUseCase()
            launch {
                _newsLoadProgress.value = false
            }
        }
    }
}