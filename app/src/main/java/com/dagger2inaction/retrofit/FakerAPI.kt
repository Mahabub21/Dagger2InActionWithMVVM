package com.dagger2inaction.retrofit

import com.dagger2inaction.db.Product
import retrofit2.Response
import retrofit2.http.GET

interface FakerAPI {

    @GET("products")
    suspend fun getProducts() : Response<List<Product>>

}