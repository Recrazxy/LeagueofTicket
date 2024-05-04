package com.example.leagueofticket.view

import com.example.leagueofticket.base.IBaseCallback
import com.example.leagueofticket.model.domain.Categories

interface IHomeCallback: IBaseCallback {
    fun onCatergoriesLoaded(categories: Categories)

}