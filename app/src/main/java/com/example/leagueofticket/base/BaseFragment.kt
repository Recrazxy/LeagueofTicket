package com.example.leagueofticket.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.leagueofticket.R

abstract class BaseFragment : Fragment() {
    lateinit var rootBinding_: ViewBinding
    private var rootview_: View? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootview_ = inflater.inflate(R.layout.fragment_home, container, false)
        rootBinding_ = getRootBinding()
//        Log.d("BaseFragment", "homebinding: $rootBinding_")
        initView()
        initPresenter()
        loadData()
        return rootBinding_.root
    }

    abstract fun getRootBinding(): ViewBinding


    protected open fun initView() {
        // 初始化view
    }

    override fun onDestroyView() {
        super.onDestroyView()
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

}