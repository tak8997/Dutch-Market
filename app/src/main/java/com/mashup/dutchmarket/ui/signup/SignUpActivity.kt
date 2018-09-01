package com.mashup.dutchmarket.ui.signup

import android.os.Bundle
import com.mashup.dutchmarket.BaseActivity
import com.mashup.dutchmarket.R

internal class SignUpActivity : BaseActivity<SignUpViewModel.ViewModel>() {

    override fun getLayoutRes(): Int = R.layout.activity_sign_up

    override fun getViewModel(): Class<SignUpViewModel.ViewModel> = SignUpViewModel.ViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        subscribe()
    }

    private fun subscribe() {

    }
}