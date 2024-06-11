package ru.dev.android.cadastre.data.definition.repository

import android.app.Application
import android.view.animation.Transformation
import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import ru.dev.android.cadastre.data.api.ApiFactory
import ru.dev.android.cadastre.data.definition.mapper.DefinitionMapper
import ru.dev.android.cadastre.data.local.AppDatabase
import ru.dev.android.cadastre.domain.definitions.entity.Definition
import ru.dev.android.cadastre.domain.definitions.repository.DefinitionsRepository

class DefinitionsRepositoryImpl(
    private val context: Application
) : DefinitionsRepository {

    private val apiService = ApiFactory.apiService
    private val definitionDao = AppDatabase.getInstance(context).definitionDao()
    private val definitionMapper = DefinitionMapper()

    override fun getDefinitionsList(): LiveData<List<Definition>> {
        return definitionDao.getDefinitionsList().map {
            definitionMapper.mapListDbModelToListEntity(it)
        }
    }

    override suspend fun getDefinitionById(defId: String): Definition {
        TODO()
    }

    override suspend fun loadDefinitions() {
        val listDto = apiService.getDefinitionsList().definitionList
        val listDbModel = listDto.map { definitionMapper.mapDtoToDbModel(it) }
        definitionDao.insertDefinitionsToDb(listDbModel)
    }
}