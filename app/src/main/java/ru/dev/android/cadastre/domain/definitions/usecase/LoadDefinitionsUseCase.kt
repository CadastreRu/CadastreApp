package ru.dev.android.cadastre.domain.definitions.usecase

import ru.dev.android.cadastre.domain.definitions.repository.DefinitionsRepository

class LoadDefinitionsUseCase(
    private val repository: DefinitionsRepository
) {

    suspend operator fun invoke() {
        repository.loadDefinitions()
    }
}