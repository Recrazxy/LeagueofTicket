package com.example.leagueofticket.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.leagueofticket.databinding.TestfragmentHomeBinding
import com.example.leagueofticket.ui.adapter.HomePagerAdapter
import com.example.leagueofticket.ui.adapter.testAdapter
import com.google.android.material.tabs.TabLayoutMediator

class TestHomeFragment: Fragment(){
    private lateinit var binding: TestfragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = TestfragmentHomeBinding.inflate(layoutInflater)
        setupviewpager()
        setuptablayout()
        return binding.root
    }

    private fun setuptablayout() {
        TabLayoutMediator(binding.testtabLayout, binding.viewPager) { tab, position ->
            tab.text = "Tab " + (position + 1)
        }.attach()
    }

    private fun setupviewpager() {
//        val adapter = testAdapter(this)
        val adapter = HomePagerAdapter(this)
        binding.viewPager.adapter = adapter

    }
}