package com.hammad.growiser.di

import com.hammad.growiser.data.db.dao.FieldDao
import com.hammad.growiser.data.repository.CoreRepository
import com.hammad.growiser.data.services.ApiService
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideCoreRepository(
        service: ApiService,
        fieldDao: FieldDao
    ): CoreRepository {
        return CoreRepository.Impl(service, fieldDao)
    }
}