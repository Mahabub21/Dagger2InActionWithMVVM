package com.dagger2inaction.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dagger2inaction.db.FakerDB
import com.dagger2inaction.db.Product
import com.dagger2inaction.retrofit.FakerAPI
import javax.inject.Inject

class ProductRepository @Inject constructor(private val fakerAPI: FakerAPI, private val fakerDB: FakerDB) {

    private val _products = MutableLiveData<List<Product>>()
    val products : LiveData<List<Product>> get() = _products

    suspend fun getProducts() {
        val result = fakerAPI.getProducts()
        if(result.isSuccessful && result.body() != null) {
            fakerDB.getFakerDAO().addProducts(result.body()!!)
            _products.postValue(result.body())
        }
    }

}