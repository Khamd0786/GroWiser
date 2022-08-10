package com.hammad.growiser.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.hammad.growiser.data.models.Field

@Dao
interface FieldDao {

    @Insert
    fun insert(vararg field: Field)

    @Query("SELECT * FROM fields")
    suspend fun getFields(): List<Field>


}