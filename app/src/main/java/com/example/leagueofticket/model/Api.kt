package com.example.leagueofticket.model

import com.example.leagueofticket.model.domain.Categories
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("discovery/categories")
    fun getCatergories() : Call<Categories>
}