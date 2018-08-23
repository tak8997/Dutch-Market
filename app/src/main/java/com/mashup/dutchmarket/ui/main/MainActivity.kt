package com.mashup.dutchmarket.ui.main

import android.content.Intent
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import com.mashup.dutchmarket.R
import com.mashup.dutchmarket.data.PopularPost
import com.mashup.dutchmarket.data.Post
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val postAdapter: PostRecyclerAdapter by lazy {
        PostRecyclerAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        intiailizeRecyclerView()
        intializeNavigationList()
        initializeToolbar()
        initializeListener()
    }

    override fun onResume() {
        super.onResume()

        initializeViewPager()
    }

    private fun intializeNavigationList() {
        val categories = mutableListOf<String>()

        categories.add("의류")
        categories.add("잡화")
        categories.add("식품")
        categories.add("화장품")
        categories.add("기타")

        nav_listview.adapter = CategoryListAdapter(this, categories)
        nav_listview.onItemClickListener = AdapterView.OnItemClickListener { adapterView: AdapterView<*>, view1: View, position: Int, id: Long ->
            val category: String = adapterView.getItemAtPosition(position).toString()

            Intent(this@MainActivity, CategoryItemActivity::class.java).apply {
                putExtra(CategoryItemActivity.CATEGORY_ITEM, category)

                startActivity(this)
            }
        }
    }

    private fun intiailizeRecyclerView() {
        with(post_recycler) {
            setHasFixedSize(true)

            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = postAdapter
        }

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

        postAdapter.addPosts(dummyPosts)
    }

    private fun initializeViewPager() {
        val popularPosts = mutableListOf<PopularPost>()

        popularPosts.add(PopularPost("", "하하하하"))
        popularPosts.add(PopularPost("", "하하하하"))
        popularPosts.add(PopularPost("", "하하하하"))
        popularPosts.add(PopularPost("", "하하하하"))
        popularPosts.add(PopularPost("", "하하하하"))

        val pagerAdapter = PopularPostViewPager(supportFragmentManager, popularPosts)

        pager.adapter = pagerAdapter
    }

    private fun initializeToolbar() {
        setSupportActionBar(toolbar)

        supportActionBar?.setHomeAsUpIndicator(R.drawable.hamburger)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    private fun initializeListener() {
        nav_view.setNavigationItemSelectedListener {
            when(it) {

            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId) {
            android.R.id.home -> {
                drawer_layout.openDrawer(GravityCompat.START)
            }
        }

        return super.onOptionsItemSelected(item)
    }

}
