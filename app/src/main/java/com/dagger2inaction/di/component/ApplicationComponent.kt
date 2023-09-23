package com.dagger2inaction.di.component

import android.content.Context
import androidx.lifecycle.ViewModel
import com.dagger2inaction.MainActivity
import com.dagger2inaction.di.module.DatabaseModule
import com.dagger2inaction.di.module.NetworkModule
import com.dagger2inaction.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, DatabaseModule::class, ViewModelModule::class])
interface ApplicationComponent {

    fun inject(mainActivity: MainActivity)

    // fun getMap() : Map<String, ViewModel>
    fun getMap() : Map<Class<*>, ViewModel>

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context) : ApplicationComponent
    }
}