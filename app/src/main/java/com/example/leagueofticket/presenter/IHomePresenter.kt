package com.example.leagueofticket.presenter

import com.example.leagueofticket.base.IBasePresenter
import com.example.leagueofticket.view.IHomeCallback

interface IHomePresenter: IBasePresenter<IHomeCallback> {
    /**
     * 获取商品分类
     */
    fun getCatergories()


}