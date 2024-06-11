package ru.dev.android.cadastre.domain.definitions.usecase

import androidx.lifecycle.LiveData
import ru.dev.android.cadastre.domain.definitions.entity.Definition
import ru.dev.android.cadastre.domain.definitions.repository.DefinitionsRepository

class GetDefinitionsListUseCase(
    private val repository: DefinitionsRepository
) {

    operator fun invoke(): LiveData<List<Definition>> {
        return repository.getDefinitionsList()
    }
}