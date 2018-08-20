package com.mashup.dutchmarket.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.mashup.dutchmarket.R
import kotlinx.android.synthetic.main.item_navigation_list.view.*


internal class NavigationListAdapter(private val context: Context,
                                     private val categories: MutableList<String>

) : BaseAdapter() {

    override fun getView(position: Int, viewGroup: View?, parent: ViewGroup?): View {
        val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val view = inflater.inflate(R.layout.item_navigation_list, parent, false)

        view.category.text = categories[position]

        return view
    }

    override fun getItem(position: Int): String? = categories[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = categories.count()
}