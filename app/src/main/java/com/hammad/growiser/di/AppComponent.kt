package com.hammad.growiser.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ApiModule::class, DatabaseModule::class, DataModule::class])
interface AppComponent {


}