package com.example.segundo_app.repository.catApi

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CatClientRetrofit {


    companion object {
        private lateinit var INSTANCE: Retrofit
        private const val BASE_URL = "https://catfact.ninja/"

        private fun getRetrofitInstance(): Retrofit {
            val http = OkHttpClient.Builder()
            if (!::INSTANCE.isInitialized) {
                INSTANCE = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(http.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return INSTANCE
        }
        fun <S> createService(className: Class<S>): S {
            return getRetrofitInstance().create(className)
        }
    }
}