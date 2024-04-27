package com.example.leagueofticket.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.leagueofticket.R

abstract class BaseFragment : Fragment() {
    private var rootview: View? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootview = getRootView(inflater, container, savedInstanceState);
        initPresenter()
        loadData()
        return rootview
    }

    override fun onDestroy() {
        super.onDestroy()
        release()
    }

    protected open fun release() {
        // 释放资源
    }

    protected open fun initPresenter() {
        // 创建presenter
    }

    protected open fun loadData() {
        // 加载数据
    }

    private fun getRootView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getPageLayoutId(), container, false)
    }

    abstract fun getPageLayoutId(): Int
}