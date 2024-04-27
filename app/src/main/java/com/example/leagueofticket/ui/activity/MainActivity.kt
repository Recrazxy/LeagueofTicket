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
import com.google.android.material.navigation.NavigationBarView


class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity";
    private var homeFragment_: HomeFragment? = HomeFragment();
    private var selectedFragment_: SelectedFragment? = SelectedFragment();
    private var redpacketFragment_: RedPacketFragment? = RedPacketFragment();
    private var searchFragment_: SearchFragment? = SearchFragment();
    private var fm = supportFragmentManager;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        enableEdgeToEdge();
        val binder = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binder.root);
        initFragment();
        initListener(binder);
    }

    private fun initFragment() {
        homeFragment_ = HomeFragment();
        selectedFragment_ = SelectedFragment();
        redpacketFragment_ = RedPacketFragment();
        searchFragment_ = SearchFragment();
        fm = supportFragmentManager;
        switchFragment(homeFragment_!!)
    }

    private fun switchFragment(targetFragment: BaseFragment) {
        val transaction = fm.beginTransaction();
        transaction.replace(R.id.main_page_container, targetFragment);
        Log.d(TAG, "switchFragment: $targetFragment");
        transaction.commit();
    }

    private fun initListener(binder: ActivityMainBinding) {
        binder.mainNavigationBar.setOnItemSelectedListener(NavigationBarView.OnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    Log.d(TAG, "主页")
                    switchFragment(homeFragment_!!);
                }

                R.id.navigation_selected -> {
                    Log.d(TAG, "精选")
                    switchFragment(selectedFragment_!!);
                }

                R.id.navigation_red_packet -> {
                    Log.d(TAG, "特惠")
                    switchFragment(redpacketFragment_!!);
                }

                R.id.navigation_search -> {
                    Log.d(TAG, "搜索")
                    switchFragment(searchFragment_!!);
                }
            }
            true
        })
    }


}