package ru.dev.android.cadastre.presentation.definition.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.dev.android.cadastre.domain.definitions.entity.Definition
import ru.dev.android.cadastre.domain.definitions.usecase.GetDefinitionByIdUseCase
import javax.inject.Inject

class DefinitionDetailViewModel @Inject constructor(
    private val getDefinitionByIdUseCase: GetDefinitionByIdUseCase
) : ViewModel() {

    private val _definition = MutableLiveData<Definition>()
    val definition: LiveData<Definition>
        get() = _definition

    fun getDefinition(defId: String) {
        viewModelScope.launch {
            _definition.value = getDefinitionByIdUseCase(defId)
        }
    }
}