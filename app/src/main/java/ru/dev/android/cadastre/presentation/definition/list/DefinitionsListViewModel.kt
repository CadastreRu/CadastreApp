package ru.dev.android.cadastre.presentation.definition.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.dev.android.cadastre.domain.definitions.entity.Definition
import ru.dev.android.cadastre.domain.definitions.usecase.GetDefinitionsListUseCase
import ru.dev.android.cadastre.domain.definitions.usecase.LoadDefinitionsUseCase
import javax.inject.Inject

class DefinitionsListViewModel @Inject constructor(
    getDefinitionsListUseCase: GetDefinitionsListUseCase,
    private val loadDefinitionUseCase: LoadDefinitionsUseCase

) : ViewModel() {

    val definitionsList: LiveData<List<Definition>> = getDefinitionsListUseCase()

    init {
        viewModelScope.launch {
            loadDefinitionUseCase()
        }
    }
}