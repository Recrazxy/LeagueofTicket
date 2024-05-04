package com.example.leagueofticket.ui.fragment

import androidx.viewbinding.ViewBinding
import com.example.leagueofticket.base.BaseFragment
import com.example.leagueofticket.databinding.FragmentHomePagerBinding

class HomePagerFragment : BaseFragment(){
    override fun getSuccessBinding(): ViewBinding {
        return FragmentHomePagerBinding.inflate(layoutInflater)
    }

    override fun initView() {
        setUpState(State.SUCCESS)
    }

}