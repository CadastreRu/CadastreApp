package ru.dev.android.cadastre.data.definition.local.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.dev.android.cadastre.data.definition.local.model.DefinitionDbModel

@Dao
interface DefinitionDao {

    @Query("SELECT * FROM definitions")
    fun getDefinitionsList(): LiveData<List<DefinitionDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDefinitionsToDb(definitions: List<DefinitionDbModel>)
}