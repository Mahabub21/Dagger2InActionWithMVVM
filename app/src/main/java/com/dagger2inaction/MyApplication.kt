package com.dagger2inaction

import android.app.Application
import com.dagger2inaction.di.component.ApplicationComponent
import com.dagger2inaction.di.component.DaggerApplicationComponent

class MyApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.factory().create(this)
    }
}