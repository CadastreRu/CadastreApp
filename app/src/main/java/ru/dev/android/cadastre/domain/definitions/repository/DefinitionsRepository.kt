package ru.dev.android.cadastre.domain.definitions.repository

import androidx.lifecycle.LiveData
import ru.dev.android.cadastre.domain.definitions.entity.Definition

interface DefinitionsRepository {

    fun getDefinitionsList(): LiveData<List<Definition>>

    suspend fun getDefinitionById(defId: String): Definition

    suspend fun loadDefinitions()
}