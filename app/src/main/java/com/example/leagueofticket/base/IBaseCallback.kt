package com.example.leagueofticket.base

interface IBaseCallback {
    fun onNetworkError()

    fun onLoading()

    fun onEmpty()
}