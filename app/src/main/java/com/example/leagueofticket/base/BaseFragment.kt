package com.example.leagueofticket.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.widget.FrameLayout
import androidx.viewbinding.ViewBinding
import com.example.leagueofticket.databinding.BaseFragmentLayoutBinding
import com.example.leagueofticket.databinding.FragmentEmptyBinding
import com.example.leagueofticket.databinding.FragmentErrorBinding
import com.example.leagueofticket.databinding.FragmentLoadingBinding

abstract class BaseFragment : Fragment() {

    private lateinit var container_: FrameLayout
    private var currentState_ = State.NONE
    enum class State {
        NONE, LOADING, SUCCESS, ERROR, EMPTY
    }

    private lateinit var rootBinding_: ViewBinding
    lateinit var errorBinding_: ViewBinding
    lateinit var emptyBinding_: ViewBinding
    lateinit var loadingBinding_: ViewBinding
    lateinit var successBinding_: ViewBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootBinding_ = BaseFragmentLayoutBinding.inflate(inflater, container, false)
        container_ = (rootBinding_ as BaseFragmentLayoutBinding).baseContainer
        Log.d("BaseFragment", "onCreateView")
        loadStatesBinding(inflater, container)
        initView()
        initPresenter()
        loadData()
        setUpState(State.NONE)

        return rootBinding_.root
    }
    /**
     * 加载各种状态的Binding
     */
    private fun loadStatesBinding(inflater: LayoutInflater, container: ViewGroup?) {
        // 加载成功的Binding
        successBinding_ = getSuccessBinding()
        container_.addView(successBinding_.root)

        // Loading的binding
        loadLoadingBinding(inflater, container)
        container_.addView(loadingBinding_.root)

        // 加载错误页面
        loadErrorBinding(inflater, container)
        container_.addView(errorBinding_.root)

        // 加载空页面
        loadEmptyBinding(inflater, container)
        container_.addView(emptyBinding_.root)
    }

    protected open fun loadErrorBinding(inflater: LayoutInflater, container: ViewGroup?) {
        errorBinding_ = FragmentErrorBinding.inflate(layoutInflater)
    }

    protected open fun loadEmptyBinding(inflater: LayoutInflater, container: ViewGroup?) {
        emptyBinding_ = FragmentEmptyBinding.inflate(layoutInflater)
    }

    protected open fun loadLoadingBinding(inflater: LayoutInflater, container: ViewGroup?) {
        // 加载loading的binding
        loadingBinding_ = FragmentLoadingBinding.inflate(layoutInflater)
    }

    abstract fun getSuccessBinding(): ViewBinding


    // 子类可以调用这个方法来设置状态
    public fun setUpState(state : State) {
        this.currentState_ = state
        successBinding_.root.visibility = if (currentState_ == State.SUCCESS) View.VISIBLE else View.GONE
        loadingBinding_.root.visibility = if (currentState_ == State.LOADING) View.VISIBLE else View.GONE
        errorBinding_.root.visibility = if (currentState_ == State.ERROR) View.VISIBLE else View.GONE
        emptyBinding_.root.visibility = if (currentState_ == State.EMPTY) View.VISIBLE else View.GONE

    }
    protected open fun initView() {
        // 初始化view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("BaseFragment", "onDestroyView: $this")
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