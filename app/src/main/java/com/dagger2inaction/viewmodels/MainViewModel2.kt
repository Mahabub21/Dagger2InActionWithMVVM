package com.dagger2inaction.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MainViewModel2 @Inject constructor(private val randomize: Randomize) : ViewModel() {
    class Randomize @Inject constructor() {
        fun onAction() {
            Log.d("MainViewModel2", "Random Action")
        }
    }

}