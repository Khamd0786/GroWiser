package com.hammad.growiser

import android.app.Application
import com.hammad.growiser.di.AppComponent
import com.hammad.growiser.di.AppModule
import com.hammad.growiser.di.DaggerAppComponent

class GroWiserApp: Application() {

    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        app = this
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()

    }

    companion object {
       private lateinit var app: GroWiserApp
       fun get() = app
    }
}