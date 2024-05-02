package com.example.leagueofticket.ui.fragment

import androidx.viewbinding.ViewBinding
import com.example.leagueofticket.base.BaseFragment
import com.example.leagueofticket.databinding.FragmentSelectedBinding

class SelectedFragment : BaseFragment() {
    override fun getRootBinding(): ViewBinding {
        return FragmentSelectedBinding.inflate(layoutInflater)
    }

}