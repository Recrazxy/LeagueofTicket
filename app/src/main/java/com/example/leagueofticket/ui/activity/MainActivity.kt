package com.example.leagueofticket.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.leagueofticket.R
import com.example.leagueofticket.databinding.ActivityMainBinding
import com.example.leagueofticket.ui.fragment.HomeFragment
import com.google.android.material.navigation.NavigationBarView


class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity";
    private var mNavigationView: NavigationBarView? = null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        enableEdgeToEdge();
        val binder = ActivityMainBinding.inflate(layoutInflater);

        setContentView(binder.root);
        initView();
        initListener();
        }

    private fun initListener() {
        mNavigationView?.setOnItemSelectedListener(NavigationBarView.OnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    Log.d(TAG,"主页")
                }

                R.id.navigation_selected -> {
                    Log.d(TAG,"精选")
                }

                R.id.navigation_red_packet -> {
                    Log.d(TAG,"特惠")
                    //购物车
                }

                R.id.navigation_search -> {
                    Log.d(TAG,"搜索")
                    //我的
                }
            }
            true
        })
    }

    private fun initView() {
        mNavigationView = this.findViewById<NavigationBarView>(R.id.main_navigation_bar)

        val homeFragment = HomeFragment();
        val fm = supportFragmentManager;
        val transaction = fm.beginTransaction();
        transaction.add(R.id.main_page_container, homeFragment);
        transaction.commit();
    }
}