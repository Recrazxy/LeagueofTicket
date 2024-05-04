package com.example.leagueofticket.ui.adapter

import androidx.fragment.app.Fragment

import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.leagueofticket.model.domain.Categories
import com.example.leagueofticket.model.domain.Data
import com.example.leagueofticket.ui.fragment.HomePagerFragment


class HomePagerAdapter(fragment: Fragment) :
    FragmentStateAdapter(fragment) {
    private val categoryList_: MutableList<Data> = mutableListOf()

    fun getPageTitle(position: Int): CharSequence {
//        Log.d("HomePagerAdapter", "getPageTitle: ${categoryList_[position].title}")
        return categoryList_[position].title
    }
    override fun getItemCount(): Int {
//        Log.d("HomePagerAdapter", "getItemCount: ${categoryList_.size}")
        return categoryList_.size
    }

    override fun createFragment(position: Int): Fragment {
        //        Log.d("HomePagerAdapter", "createFragment: $homePagerFragment")
        val homePagerFragment = HomePagerFragment.newInstance(categoryList_[position])
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