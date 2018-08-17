package com.mashup.dutchmarket.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.mashup.dutchmarket.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeViews()
    }

    private fun initializeViews() {
        setSupportActionBar(toolbar)

        val actionBar = supportActionBar

        actionBar?.setHomeAsUpIndicator(R.drawable.ic_hamburger)
    }
}
