package com.example.leagueofticket.ui.adapter

import android.util.Log
import androidx.fragment.app.Fragment

import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.leagueofticket.model.domain.Categories
import com.example.leagueofticket.model.domain.Data
import com.example.leagueofticket.ui.fragment.HomePagerFragment
import java.sql.RowIdLifetime


class HomePagerAdapter(fragment: Fragment) :
    FragmentStateAdapter(fragment) {
    private val categoryList_: MutableList<Data> = mutableListOf()

    fun getPageTitle(position: Int): CharSequence {
        Log.d("HomePagerAdapter", "getPageTitle: ${categoryList_[position].title}")
        return categoryList_[position].title
    }
    override fun getItemCount(): Int {
        Log.d("HomePagerAdapter", "getItemCount: ${categoryList_.size}")
        return categoryList_.size
    }

    override fun createFragment(position: Int): Fragment {
        val homePagerFragment = HomePagerFragment()
        Log.d("HomePagerAdapter", "createFragment: $homePagerFragment")
        return homePagerFragment
    }

    fun setCategories(categories: Categories) {
        categoryList_.clear()
        val data = categories.data
        categoryList_.addAll(data)
        notifyDataSetChanged()
//        Log.d("HomePagerAdapter", "getItemCount: ${categoryList_}")
    }
}