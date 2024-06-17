package ru.dev.android.cadastre.data.definition.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import ru.dev.android.cadastre.data.api.ApiService
import ru.dev.android.cadastre.data.definition.local.db.DefinitionDao
import ru.dev.android.cadastre.data.definition.mapper.DefinitionMapper
import ru.dev.android.cadastre.domain.definitions.entity.Definition
import ru.dev.android.cadastre.domain.definitions.repository.DefinitionsRepository
import javax.inject.Inject

class DefinitionsRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val definitionDao: DefinitionDao,
    private val definitionMapper: DefinitionMapper
) : DefinitionsRepository {

    override fun getDefinitionsList(): LiveData<List<Definition>> {
        return definitionDao.getDefinitionsList().map {
            definitionMapper.mapListDbModelToListEntity(it)
        }
    }

    override suspend fun getDefinitionById(defId: String): Definition {
        return definitionMapper.mapDtoListOneToEntity(apiService.getDefinitionDetail(defId))
    }

    override suspend fun loadDefinitions() {
        val listDto = apiService.getDefinitionsList().definitionList
        val listDbModel = listDto?.map { definitionMapper.mapDtoToDbModel(it) }
        if (listDbModel != null) {
            definitionDao.insertDefinitionsToDb(listDbModel)
        }
    }
}