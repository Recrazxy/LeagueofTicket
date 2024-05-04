package com.example.leagueofticket.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.viewbinding.ViewBinding
import com.example.leagueofticket.base.BaseFragment
import com.example.leagueofticket.databinding.FragmentHomePagerBinding
import com.example.leagueofticket.model.domain.Data
import com.example.leagueofticket.utils.Constants

class HomePagerFragment : BaseFragment(){

    companion object {
        fun newInstance(category: Data): HomePagerFragment {
            val homePagerFragment = HomePagerFragment()
            val bundle = Bundle()
            bundle.putString(Constants.KEY_HOME_PAGER_TITLE, category.title)
            bundle.putInt(Constants.KEY_HOME_PAGER_MATERIAL_ID, category.id)
            homePagerFragment.arguments = bundle
            return homePagerFragment
        }

    }
    override fun getSuccessBinding(): ViewBinding {
        return FragmentHomePagerBinding.inflate(layoutInflater)
    }

    override fun initView() {
        setUpState(State.SUCCESS)
    }

    override fun loadData() {
        arguments?.let {
            val title = it.getString(Constants.KEY_HOME_PAGER_TITLE)
            val materialId = it.getInt(Constants.KEY_HOME_PAGER_MATERIAL_ID)
        }
        Log.d("HomePagerFragment", "loadData: $arguments")
    }
}