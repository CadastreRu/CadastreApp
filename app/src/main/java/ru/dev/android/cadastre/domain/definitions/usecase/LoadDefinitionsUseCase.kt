package ru.dev.android.cadastre.domain.definitions.usecase

import ru.dev.android.cadastre.domain.definitions.repository.DefinitionsRepository
import javax.inject.Inject

class LoadDefinitionsUseCase @Inject constructor(
    private val repository: DefinitionsRepository
) {

    suspend operator fun invoke() {
        repository.loadDefinitions()
    }
}