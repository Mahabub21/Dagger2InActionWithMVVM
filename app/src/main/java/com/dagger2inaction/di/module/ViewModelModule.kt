package com.dagger2inaction.di.module

import androidx.lifecycle.ViewModel
import com.dagger2inaction.viewmodels.MainViewModel
import com.dagger2inaction.viewmodels.MainViewModel2
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

   @Binds
   //@StringKey("mainViewModel")
   @ClassKey(MainViewModel::class)
   @IntoMap
   abstract fun mainViewModel(mainViewModel: MainViewModel) : ViewModel

    @Binds
    //@StringKey("mainViewModel2")
    @ClassKey(MainViewModel2::class)
    @IntoMap
    abstract fun mainViewModel2(mainViewModel: MainViewModel) : ViewModel
}