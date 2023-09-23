package com.dagger2inaction.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dagger2inaction.db.Product
import com.dagger2inaction.repository.ProductRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val repository: ProductRepository,
                    private val randomize: Randomize) : ViewModel() {

    val productsLiveData : LiveData<List<Product>>
        get() = repository.products

    init {
        viewModelScope.launch {
            repository.getProducts()
        }
    }

    class Randomize @Inject constructor() {
        fun onAction() {
            Log.d("MainViewModel", "Random Action")
        }
    }

}