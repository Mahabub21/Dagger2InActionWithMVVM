package com.dagger2inaction.di.component

import android.content.Context
import com.dagger2inaction.MainActivity
import com.dagger2inaction.di.module.DatabaseModule
import com.dagger2inaction.di.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, DatabaseModule::class])
interface ApplicationComponent {

    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context) : ApplicationComponent
    }
}