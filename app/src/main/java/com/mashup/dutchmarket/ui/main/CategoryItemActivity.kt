package com.mashup.dutchmarket.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.mashup.dutchmarket.R
import com.mashup.dutchmarket.data.Post
import kotlinx.android.synthetic.main.activity_category_item.*

class CategoryItemActivity : AppCompatActivity() {

    companion object {
        const val CATEGORY_ITEM = "category_item"
    }

    private val postRecyclerAdapter: PostRecyclerAdapter by lazy {
        PostRecyclerAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_item)

        val categoryTitle = intent.extras.getString(CATEGORY_ITEM)

        initializeToolbar(categoryTitle)
        initializeRecycler()

        //dummy
        val dummyPosts = mutableListOf<Post>()

        dummyPosts.add(Post("", "하하", "2016.09.01까지", 6))
        dummyPosts.add(Post("", "하하", "2016.09.01까지", 6))
        dummyPosts.add(Post("", "하하", "2016.09.01까지", 6))
        dummyPosts.add(Post("", "하하", "2016.09.01까지", 6))
        dummyPosts.add(Post("", "하하", "2016.09.01까지", 6))
        dummyPosts.add(Post("", "하하", "2016.09.01까지", 6))
        dummyPosts.add(Post("", "하하", "2016.09.01까지", 6))
        dummyPosts.add(Post("", "하하", "2016.09.01까지", 6))
        dummyPosts.add(Post("", "하하", "2016.09.01까지", 6))

        postRecyclerAdapter.addPosts(dummyPosts)
    }

    private fun initializeToolbar(categoryTitle: String) {
        setSupportActionBar(category_post_toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        category_toolbar_title.text = categoryTitle
    }

    private fun initializeRecycler() {
        category_post_recycler.layoutManager = LinearLayoutManager(this)
        category_post_recycler.adapter = postRecyclerAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.category_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId) {
            R.id.category_item_search -> {

            }
            android.R.id.home -> {

            }
        }

        return super.onOptionsItemSelected(item)
    }
}
