package ru.dev.android.cadastre.data.definition.mapper

import ru.dev.android.cadastre.data.definition.dto.DefinitionDto
import ru.dev.android.cadastre.data.definition.dto.DefinitionsListDto
import ru.dev.android.cadastre.data.definition.local.model.DefinitionDbModel
import ru.dev.android.cadastre.data.news.dto.NewsListDto
import ru.dev.android.cadastre.domain.definitions.entity.Definition
import ru.dev.android.cadastre.domain.news.entity.News

class DefinitionMapper {

    private fun mapDtoToEntity(definitionDto: DefinitionDto): Definition {
        return Definition(
            id = definitionDto.id,
            title = definitionDto.title ?: "",
            annotation = definitionDto.annotation ?: "",
            text = definitionDto.text ?: ""
        )
    }

    fun mapDtoToDbModel(definitionDto: DefinitionDto): DefinitionDbModel {
        return DefinitionDbModel(
            id = definitionDto.id,
            title = definitionDto.title ?: "",
            annotation = definitionDto.annotation ?: "",
            text = definitionDto.text ?: ""
        )
    }

    private fun mapDbModelToEntity(definitionDbModel: DefinitionDbModel): Definition {
        return Definition(
            id = definitionDbModel.id,
            title = definitionDbModel.title,
            annotation = definitionDbModel.annotation,
            text = definitionDbModel.text
        )
    }

    fun mapListDbModelToListEntity(definitionsList: List<DefinitionDbModel>): List<Definition> {
        return definitionsList.map {
            mapDbModelToEntity(it)
        }.sortedBy { it.title }
    }

    fun mapDtoListOneToEntity(definitionsListDto: DefinitionsListDto): Definition {
        val item = definitionsListDto.definitionList?.get(0)
        return if (item != null) {
            mapDtoToEntity(item)
        } else {
            throw RuntimeException("Definition is null")
        }
    }
}