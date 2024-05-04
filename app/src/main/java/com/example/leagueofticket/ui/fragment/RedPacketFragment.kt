package com.example.leagueofticket.ui.fragment

import androidx.viewbinding.ViewBinding
import com.example.leagueofticket.base.BaseFragment
import com.example.leagueofticket.databinding.FragmentRedpacketBinding

class RedPacketFragment : BaseFragment() {
    override fun getSuccessBinding(): ViewBinding {
        return FragmentRedpacketBinding.inflate(layoutInflater)
    }

    override fun initView() {
        setUpState(State.SUCCESS)
    }
}