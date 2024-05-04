package com.example.leagueofticket.base

import com.example.leagueofticket.view.IHomeCallback

interface IBasePresenter<T> {
    /**
     * 注册UI通知接口
     */
    fun registerCallback(callback: T)

    /**
     * 取消UI通知接口
     */
    fun unregisterCallback(callback: T)
}