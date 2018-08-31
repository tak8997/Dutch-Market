package com.mashup.dutchmarket.ui.login

import android.os.Bundle
import com.mashup.dutchmarket.BaseActivity
import com.mashup.dutchmarket.R
import com.mashup.dutchmarket.viewmodel.SignUpViewModel

internal class SignUpActivity : BaseActivity<SignUpViewModel>() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun getLayoutRes(): Int = R.layout.activity_sign_up

    override fun getViewModel(): Class<SignUpViewModel> = SignUpViewModel::class.java
}
