package com.example.leagueofticket.presenter

interface ICategoryPagerPresenter {
    /**
     * 根据分类id获取内容
     */
    fun getContentByCategoryId(categoryId: Int)

    fun loadMore(categoryId: Int)

    fun reload(categoryId: Int)
}