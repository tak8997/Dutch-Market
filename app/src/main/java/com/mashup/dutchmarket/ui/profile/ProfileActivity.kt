package com.mashup.dutchmarket.ui.profile

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.mashup.dutchmarket.R
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        intializeToolbar()
    }

    private fun intializeToolbar() {
        setSupportActionBar(profile_toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }
}
