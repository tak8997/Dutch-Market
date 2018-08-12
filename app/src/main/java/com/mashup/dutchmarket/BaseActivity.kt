package com.mashup.dutchmarket

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection


internal open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AndroidInjection.inject(this)
    }
}