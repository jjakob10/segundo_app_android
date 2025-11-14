package com.example.segundo_app.repository.dogApi

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DogClientRetrofit {

    companion object {
        private lateinit var INSTANCE: Retrofit
        private const val BASE_URL = "https://dogapi.dog/"

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