package ru.dev.android.cadastre.presentation.definition.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.dev.android.cadastre.data.definition.repository.DefinitionsRepositoryImpl
import ru.dev.android.cadastre.domain.definitions.entity.Definition
import ru.dev.android.cadastre.domain.definitions.usecase.GetDefinitionsListUseCase

class DefinitionsListViewModel(
    private val context: Application
) : AndroidViewModel(context) {

    private val repository = DefinitionsRepositoryImpl(context)
    private val getDefinitionsListUseCase = GetDefinitionsListUseCase(repository)

    val definitionsList: LiveData<List<Definition>> = getDefinitionsListUseCase()

    init {
        viewModelScope.launch {
            repository.loadDefinitions()
        }
    }
}