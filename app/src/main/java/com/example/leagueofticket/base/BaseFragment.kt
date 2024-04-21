package com.example.leagueofticket.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.leagueofticket.R

abstract class BaseFragment : Fragment() {
    private var rootview: View? = null;
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootview = getRootView(inflater, container, savedInstanceState);
        return rootview;

    }

    private fun getRootView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    abstract fun getPageLayoutId(): Int
}