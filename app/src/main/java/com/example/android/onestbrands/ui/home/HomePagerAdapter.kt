package com.example.android.onestbrands.ui.home

import android.content.Context
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.android.onestbrands.R
import com.example.android.onestbrands.ui.home.list.BrandListFeatureFragment
import com.example.android.onestbrands.ui.home.map.MapFragment

class HomePagerAdapter(context: Context, fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    val titles: Array<String> = arrayOf(context.getString(R.string.list_tab_titile), context.getString(
        R.string.map_tab_titile
    ))

    private val tabs = mapOf(
        LIST_POSITION to BrandListFeatureFragment(),
        MAP_POSITION to MapFragment()
    )

    override fun getItem(position: Int) = tabs[position]!!

    override fun getCount() = tabs.size


    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }

    companion object {
        const val LIST_POSITION = 0
        const val MAP_POSITION = 1
    }
}