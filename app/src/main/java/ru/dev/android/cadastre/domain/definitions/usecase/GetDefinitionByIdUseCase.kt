package ru.dev.android.cadastre.domain.definitions.usecase

import ru.dev.android.cadastre.domain.definitions.entity.Definition
import ru.dev.android.cadastre.domain.definitions.repository.DefinitionsRepository
import javax.inject.Inject

class GetDefinitionByIdUseCase @Inject constructor(
    private val repository: DefinitionsRepository
) {

    suspend operator fun invoke(defId: String): Definition {
        return repository.getDefinitionById(defId)
    }
}