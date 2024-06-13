package ru.dev.android.cadastre.presentation.definition.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.dev.android.cadastre.data.definition.repository.DefinitionsRepositoryImpl
import ru.dev.android.cadastre.domain.definitions.entity.Definition
import ru.dev.android.cadastre.domain.definitions.usecase.GetDefinitionByIdUseCase

class DefinitionDetailViewModel(
    context: Application
) : AndroidViewModel(context) {

    private val repository = DefinitionsRepositoryImpl(context)
    private val getDefinitionByIdUseCase = GetDefinitionByIdUseCase(repository)

    private val _definition = MutableLiveData<Definition>()
    val definition: LiveData<Definition>
        get() = _definition

    fun getDefinition(defId: String) {
        viewModelScope.launch {
            _definition.value = getDefinitionByIdUseCase(defId)
        }
    }
}