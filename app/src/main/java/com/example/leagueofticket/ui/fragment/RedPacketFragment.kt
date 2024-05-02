package com.example.leagueofticket.ui.fragment

import androidx.viewbinding.ViewBinding
import com.example.leagueofticket.base.BaseFragment
import com.example.leagueofticket.databinding.FragmentRedpacketBinding

class RedPacketFragment : BaseFragment() {
    override fun getRootBinding(): ViewBinding {
        return FragmentRedpacketBinding.inflate(layoutInflater)
    }

}