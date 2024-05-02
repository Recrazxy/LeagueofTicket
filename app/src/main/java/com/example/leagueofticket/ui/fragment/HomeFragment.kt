package com.example.leagueofticket.ui.fragment

import android.util.Log
import androidx.viewbinding.ViewBinding
import com.example.leagueofticket.R
import com.example.leagueofticket.base.BaseFragment
import com.example.leagueofticket.databinding.FragmentHomeBinding
import com.example.leagueofticket.model.domain.Categories
import com.example.leagueofticket.presenter.impl.HomePresenterImpl
import com.example.leagueofticket.presenter.impl.IHomePresenter
import com.example.leagueofticket.ui.adapter.HomePagerAdapter
import com.example.leagueofticket.view.IHomeCallback
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : BaseFragment(), IHomeCallback {
    private lateinit var homePagerAdapter_: HomePagerAdapter
    private var homepresenter_: IHomePresenter = HomePresenterImpl()
    private lateinit var homeBinding_: FragmentHomeBinding

    override fun getRootBinding(): ViewBinding {
        homeBinding_ = FragmentHomeBinding.inflate(layoutInflater)
        return homeBinding_
    }

    override fun initView() {
        // 设置适配器
        setupViewPage()
        setupTabLayout()
//        Log.d("HomeFragment", "homePager_adapter: ${thehomePager_.adapter}")
//        Log.d("HomeFragment", "homebinding: $homeBinding_")
//        Log.d("HomeFragment", "homePager_: $homePager_")
    }

    private fun setupViewPage() {
        homePagerAdapter_ = HomePagerAdapter(this)
//        homePagerAdapter_ = testAdapter(this)
//        val iamtestAdapter = testAdapter(this)
//        Log.d("HomeFragment", "homepageradapter: $homePagerAdapter_")
        homeBinding_.theHomePager2.adapter = homePagerAdapter_
    }

    private fun setupTabLayout() {
        TabLayoutMediator(homeBinding_.homeTabLayout, homeBinding_.theHomePager2/*thehomePager_*/) { tab, position ->
            tab.text = homePagerAdapter_.getPageTitle(position)
        }.attach()
    }

    override fun initPresenter() {
        // 创建Presenter
        homepresenter_ = HomePresenterImpl()
        homepresenter_.registerCallback(this)
    }

    override fun loadData() {
        homepresenter_.getCatergories()
        Log.d("HomeFragment", "loaddataed")
        // 加载数据
    }

    override fun onCatergoriesLoaded(categories: Categories) {
        // 加载的数据从这里回来
        Log.d("onCatergories", "onCatergoriesLoaded: $categories")
        homePagerAdapter_.setCategories(categories)
    }

    override fun release() {
        // 取消回调注册
        homepresenter_.unregisterCallback(this)
    }

}