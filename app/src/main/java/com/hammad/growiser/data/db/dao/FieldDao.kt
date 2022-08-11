package com.hammad.growiser.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hammad.growiser.data.models.Field

@Dao
interface FieldDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg field: Field)

    @Query("SELECT * FROM fields")
    fun getFields(): List<Field>

    @Query("DELETE FROM fields")
    suspend fun deleteAll()
}
