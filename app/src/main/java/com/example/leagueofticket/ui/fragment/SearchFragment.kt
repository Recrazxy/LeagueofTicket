package com.example.leagueofticket.ui.fragment

import androidx.viewbinding.ViewBinding
import com.example.leagueofticket.base.BaseFragment
import com.example.leagueofticket.databinding.FragmentSearchBinding

class SearchFragment : BaseFragment() {
    override fun getSuccessBinding(): ViewBinding {
        return FragmentSearchBinding.inflate(layoutInflater)
    }

}