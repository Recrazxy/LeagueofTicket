package com.example.leagueofticket.ui.fragment

import androidx.viewbinding.ViewBinding
import com.example.leagueofticket.base.BaseFragment
import com.example.leagueofticket.databinding.FragmentHomePagerBinding

class HomePagerFragment : BaseFragment(){
    override fun getRootBinding(): ViewBinding {
        return FragmentHomePagerBinding.inflate(layoutInflater)
    }

}