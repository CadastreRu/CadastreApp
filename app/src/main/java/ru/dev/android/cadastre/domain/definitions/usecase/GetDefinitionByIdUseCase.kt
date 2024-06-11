package ru.dev.android.cadastre.domain.definitions.usecase

import ru.dev.android.cadastre.domain.definitions.entity.Definition
import ru.dev.android.cadastre.domain.definitions.repository.DefinitionsRepository

class GetDefinitionByIdUseCase(
    private val repository: DefinitionsRepository
) {

    suspend operator fun invoke(defId: String): Definition {
        return repository.getDefinitionById(defId)
    }
}