package com.example.segundo_app.repository.dogApi

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface DogCuriosityService {

    @GET("api/v2/facts")
    fun getDogCuriosity(@Query("limit") limit: Int = 1):Call<DogCuriosityEntity>
}