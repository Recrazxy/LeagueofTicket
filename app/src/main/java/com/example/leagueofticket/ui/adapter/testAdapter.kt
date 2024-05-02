package com.example.leagueofticket.ui.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.leagueofticket.ui.fragment.HomeFragment
import com.example.leagueofticket.ui.fragment.SelectedFragment

class testAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> SelectedFragment()
            1 -> HomeFragment()
            else -> HomeFragment()
        }
    }
}
