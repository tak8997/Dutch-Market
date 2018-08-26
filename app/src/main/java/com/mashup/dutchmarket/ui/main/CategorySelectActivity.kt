package com.mashup.dutchmarket.ui.main

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import com.mashup.dutchmarket.DutchMarket
import com.mashup.dutchmarket.R
import kotlinx.android.synthetic.main.activity_category_select.*
import kotlinx.android.synthetic.main.item_category_list.view.*
import android.support.v7.widget.DividerItemDecoration
import com.mashup.dutchmarket.extension.paddingInPixel


class CategorySelectActivity : AppCompatActivity() {

    private val categorySelectAdapter by lazy {
        CategorySelectAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_select)

        intializeRecycler()
        intializeCategories()
        initializeToolbar()
    }

    private fun intializeRecycler() {
        with(category_select_recycler) {
            setHasFixedSize(true)
            addItemDecoration(SimpleDividerItemDecoration())

            layoutManager = LinearLayoutManager(this@CategorySelectActivity)
            adapter = categorySelectAdapter
        }
    }

    private fun intializeCategories() {
        val categories = mutableListOf<String>()

        categories.add("의류")
        categories.add("잡화")
        categories.add("식품")
        categories.add("화장품")
        categories.add("기타")

        categorySelectAdapter.addCategories(categories)
    }

    private fun initializeToolbar() {
        setSupportActionBar(category_select_toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId) {
            android.R.id.home -> {
                finish()
            }
        }

        return super.onOptionsItemSelected(item)
    }

    class CategorySelectAdapter : RecyclerView.Adapter<CategorySelectAdapter.ViewHolder>() {

        private val categories: MutableList<String> = mutableListOf()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategorySelectAdapter.ViewHolder= ViewHolder(LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_category_list, parent, false)
        )

        override fun getItemCount(): Int = categories.size

        override fun onBindViewHolder(viewholder: ViewHolder, position: Int) {
            viewholder.itemView.category.text = categories[position]
            viewholder.itemView.category.setTextColor(ContextCompat.getColor(DutchMarket.instance, R.color._000000))
            viewholder.itemView.category.setPadding(50.paddingInPixel, 16.paddingInPixel, 0, 15.paddingInPixel)
        }

        fun addCategories(categories: MutableList<String>) {
            this.categories.clear()
            this.categories.addAll(categories)

            notifyDataSetChanged()
        }

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    }
}
