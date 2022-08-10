package com.hammad.growiser.di

import android.app.Application
import com.hammad.growiser.data.services.ApiService
import com.hammad.growiser.utils.K
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApiModule {

    @Provides
    fun provideBuilder(): Retrofit.Builder {
        return Retrofit.Builder().baseUrl(K.BASE_URL).addConverterFactory(GsonConverterFactory.create())
    }

    @Singleton
    @Provides
    fun provideApiService(builder: Retrofit.Builder): ApiService {
        return builder.build().create(ApiService::class.java)
    }


}