package com.hammad.growiser.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hammad.growiser.data.db.dao.FieldDao
import com.hammad.growiser.data.models.Field

@Database(entities = [Field::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun getFieldsDao(): FieldDao

}