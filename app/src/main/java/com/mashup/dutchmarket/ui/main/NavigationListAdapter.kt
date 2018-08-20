package com.mashup.dutchmarket.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.mashup.dutchmarket.R


internal class NavigationListAdapter(private val context: Context,
                                     private val navigationLists: List<String>

) : BaseAdapter() {

    override fun getView(position: Int, viewGroup: View?, parent: ViewGroup?): View {
        val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        return inflater.inflate(R.layout.item_navigation_list, parent, false)
    }

    override fun getItem(position: Int): Any = navigationLists[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = navigationLists.count()
}