package com.example.leagueofticket.presenter.impl

import com.example.leagueofticket.view.IHomeCallback

interface IHomePresenter {
    /**
     * 获取商品分类
     */
    fun getCaterories();

    /**
     * 注册UI通知接口
     */
    fun registerCallback(callback: IHomeCallback);

    /**
     * 取消UI通知接口
     */
    fun unregisterCallback(callback: IHomeCallback);
}