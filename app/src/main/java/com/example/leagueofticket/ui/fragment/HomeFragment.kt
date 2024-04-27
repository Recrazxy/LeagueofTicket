package com.example.leagueofticket.ui.fragment

import com.example.leagueofticket.R
import com.example.leagueofticket.base.BaseFragment
import com.example.leagueofticket.model.domain.Categories
import com.example.leagueofticket.presenter.impl.HomePresenterImpl
import com.example.leagueofticket.presenter.impl.IHomePresenter
import com.example.leagueofticket.view.IHomeCallback

class HomeFragment : BaseFragment(), IHomeCallback {
    private var homepresenter_: IHomePresenter = HomePresenterImpl()

    override fun getPageLayoutId(): Int {
        return R.layout.fragment_home
    }
    override fun initPresenter() {
        // 创建Presenter
        homepresenter_ = HomePresenterImpl()
        homepresenter_.registerCallback(this)
    }
    override fun loadData() {
        homepresenter_.getCaterories()
        // 加载数据
    }

    override fun onCatergoiesLoaded(categories: Categories) {
        // 加载的数据从这里回来
    }

    override fun release() {
        // 取消回调注册
        homepresenter_.unregisterCallback(this)
    }

}