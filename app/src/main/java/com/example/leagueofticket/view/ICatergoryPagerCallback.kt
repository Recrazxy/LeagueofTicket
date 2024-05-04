package com.example.leagueofticket.view

import com.example.leagueofticket.model.domain.ContentData

interface ICatergoryPagerCallback {
    /**
     * 数据加载回来
     */
    fun onContentLoaded(contents: List<ContentData>)

    /**
     * 加载中
     */
    fun onLoading(categoryId: Int)

    /**
     * 网络错误
     */
    fun onError(categoryId: Int)

    /**
     * 数据为空
     */
    fun onEmpty(categoryId: Int)

    /**
     * 加载更多网络错误
     */
    fun onLoaderMoreError(categoryId: Int)

    /**
     * 没有更多内容
     */
    fun onLoaderMoreEmpty(categoryId: Int)

    /**
     * 加载更多内容
     */
    fun onLoaderMoreLoaded(contents: List<ContentData>)

    /**
     * 轮播图的回调
     */
    fun onLooperListLoaded(contents: List<ContentData>)
}