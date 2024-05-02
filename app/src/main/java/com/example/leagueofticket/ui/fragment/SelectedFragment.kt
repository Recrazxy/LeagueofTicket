package com.example.leagueofticket.ui.fragment

import androidx.viewbinding.ViewBinding
import com.example.leagueofticket.base.BaseFragment
import com.example.leagueofticket.databinding.FragmentSelectedBinding

class SelectedFragment : BaseFragment() {
    override fun getSuccessBinding(): ViewBinding {
        return FragmentSelectedBinding.inflate(layoutInflater)
    }

}