package com.example.leagueofticket.utils

import com.example.leagueofticket.model.Api
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitManager private constructor() {

    private var retrofit_: Retrofit ?= null

    init {
        retrofit_ = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    companion object {
        const val BASE_URL: String = "https://api.sunofbeaches.com/shop/"
        // const val BASE_URL: String = "http://10.0.2.2:50200/shop/api/"
        var instance: RetrofitManager? = null
            get() {
                if (field == null) {
                    field = RetrofitManager()
                }
                return field
            }

        fun get(): RetrofitManager {
            return instance!!
        }
    }

    fun getApi(): Api {
        return retrofit_?.create(Api::class.java)!!
    }
}