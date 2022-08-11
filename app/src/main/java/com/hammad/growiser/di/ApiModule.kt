package com.hammad.growiser.di

import android.app.Application
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.hammad.growiser.data.services.ApiService
import com.hammad.growiser.utils.K
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApiModule {

    @Provides
    fun provideBuilder(app: Application): Retrofit.Builder {
        val chucker = ChuckerInterceptor.Builder(app).build()
        val client = OkHttpClient.Builder()
            .addInterceptor(chucker)
            .build()
        return Retrofit.Builder().client(client).baseUrl(K.BASE_URL).addConverterFactory(GsonConverterFactory.create())
    }

    @Singleton
    @Provides
    fun provideApiService(builder: Retrofit.Builder): ApiService {
        return builder.build().create(ApiService::class.java)
    }


}