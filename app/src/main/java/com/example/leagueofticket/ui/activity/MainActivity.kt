package com.example.leagueofticket.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.leagueofticket.R
import com.example.leagueofticket.base.BaseFragment
import com.example.leagueofticket.databinding.ActivityMainBinding
import com.example.leagueofticket.ui.fragment.HomeFragment
import com.example.leagueofticket.ui.fragment.RedPacketFragment
import com.example.leagueofticket.ui.fragment.SearchFragment
import com.example.leagueofticket.ui.fragment.SelectedFragment
import com.example.leagueofticket.ui.fragment.TestHomeFragment
import com.google.android.material.navigation.NavigationBarView


class MainActivity : AppCompatActivity() {
    private lateinit var testFragmet: TestHomeFragment
    private val TAG = "MainActivity"
    private lateinit var homeFragment_: HomeFragment
    private lateinit var selectedFragment_: SelectedFragment
    private lateinit var redpacketFragment_: RedPacketFragment
    private lateinit var searchFragment_: SearchFragment
    private var fm = supportFragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initFragment()
        Log.d(TAG, "initFragmented")
        initListener(binding)
    }

    private fun initFragment() {
        homeFragment_ = HomeFragment()
        selectedFragment_ = SelectedFragment()
        redpacketFragment_ = RedPacketFragment()
        searchFragment_ = SearchFragment()
        testFragmet = TestHomeFragment()
        fm = supportFragmentManager
        switchFragment(homeFragment_)
//        switchFragment(testFragmet)
    }

    private fun switchFragment(targetFragment: BaseFragment/*TestHomeFragment*/) {
        val transaction = fm.beginTransaction()
        transaction.replace(R.id.main_page_container, targetFragment)
        Log.d(TAG, "switchFragment: $targetFragment")
        transaction.commit()
    }

    private fun initListener(binder: ActivityMainBinding) {
        binder.mainNavigationBar.setOnItemSelectedListener(NavigationBarView.OnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    Log.d(TAG, "主页")
                    switchFragment(homeFragment_)
//                    switchFragment(testFragmet)
                }

                R.id.navigation_selected -> {
                    Log.d(TAG, "精选")
                    switchFragment(selectedFragment_)
                }

                R.id.navigation_red_packet -> {
                    Log.d(TAG, "特惠")
                    switchFragment(redpacketFragment_)
                }

                R.id.navigation_search -> {
                    Log.d(TAG, "搜索")
                    switchFragment(searchFragment_)
                }
            }
            true
        })
    }
}