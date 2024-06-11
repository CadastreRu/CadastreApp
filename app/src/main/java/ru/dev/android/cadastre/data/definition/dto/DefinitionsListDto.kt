package ru.dev.android.cadastre.data.definition.dto

import com.google.gson.annotations.SerializedName

data class DefinitionsListDto(
    @SerializedName("data")
    val definitionList: List<DefinitionDto>
)