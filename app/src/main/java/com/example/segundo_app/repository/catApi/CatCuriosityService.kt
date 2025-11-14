package com.example.segundo_app.repository.catApi

import retrofit2.Call
import retrofit2.http.GET

interface CatCuriosityService {

    @GET("fact")
    fun getCatCuriosity(): Call<CatCuriosityEntity>
}