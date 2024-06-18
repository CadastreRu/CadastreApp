package ru.dev.android.cadastre.data.definition.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "definitions")
data class DefinitionDbModel(
    @PrimaryKey
    val id: String,
    val title: String,
    val annotation: String,
    val text: String
)