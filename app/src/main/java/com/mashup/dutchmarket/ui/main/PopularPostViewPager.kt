package com.mashup.dutchmarket.ui.main

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.mashup.dutchmarket.data.PopularPost


internal class PopularPostViewPager(fragmentManger: FragmentManager, private val popularPosts: List<PopularPost>) : FragmentStatePagerAdapter(fragmentManger) {

    override fun getItem(popsition: Int): Fragment = PopularPostFragment.newInstance(popularPosts[popsition])

    override fun getCount(): Int = popularPosts.size

    override fun getPageWidth(position: Int): Float {
        return 0.6f

    }
}


