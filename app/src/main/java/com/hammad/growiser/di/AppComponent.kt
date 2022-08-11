package com.hammad.growiser.di

import com.hammad.growiser.view.activity.HomeActivity
import com.hammad.growiser.view.fragment.GroceryFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ApiModule::class, DatabaseModule::class, DataModule::class, ViewModelFactory.ViewModelModule::class])
interface AppComponent {

    fun inject(groceryFragment: GroceryFragment)
    fun inject(homeActivity: HomeActivity)

}