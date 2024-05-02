package com.example.leagueofticket.view

import com.example.leagueofticket.model.domain.Categories

interface IHomeCallback {
    fun onCatergoriesLoaded(categories: Categories)

    fun onNetworkError()

    fun onLoading()

    fun onEmpty()
}