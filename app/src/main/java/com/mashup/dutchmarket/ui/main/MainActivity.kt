package com.mashup.dutchmarket.ui.main

import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.mashup.dutchmarket.R
import com.mashup.dutchmarket.data.PopularPost
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeToolbar()
        initializeListener()
    }


    override fun onResume() {
        super.onResume()

        initializeViewPager()
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
