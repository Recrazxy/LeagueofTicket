package com.example.leagueofticket.presenter

import com.example.leagueofticket.base.IBasePresenter
import com.example.leagueofticket.view.ICatergoryPagerCallback

interface ICategoryPagerPresenter: IBasePresenter<ICatergoryPagerCallback> {
    /**
     * 根据分类id获取内容
     */
    fun getContentByCategoryId(categoryId: Int)

    fun loadMore(categoryId: Int)

    fun reload(categoryId: Int)

}