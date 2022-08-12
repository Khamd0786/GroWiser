package com.hammad.growiser.di

import android.app.Application
import androidx.room.Room
import com.hammad.growiser.data.db.AppDatabase
import com.hammad.growiser.data.db.dao.FieldDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(app, AppDatabase::class.java, "app_db").allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideFieldDao(db: AppDatabase): FieldDao = db.getFieldsDao()
}
