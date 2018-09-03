package com.mashup.dutchmarket.ui.signup

import android.os.Bundle
import android.widget.Toast
import com.mashup.dutchmarket.BaseActivity
import com.mashup.dutchmarket.R
import com.mashup.dutchmarket.extension.toast
import kotlinx.android.synthetic.main.activity_sign_up.*

internal class SignUpActivity : BaseActivity<SignUpViewModel.ViewModel>() {

    override fun getLayoutRes(): Int = R.layout.activity_sign_up

    override fun getViewModel(): Class<SignUpViewModel.ViewModel> = SignUpViewModel.ViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        intializeListener()

        subscribe()
    }

    private fun intializeListener() {
        send_auth_code.setOnClickListener {
            viewModel.input.fetchAuthNumber(email = email.text.toString())
        }
    }

    private fun subscribe() {
        addDisposables(
                viewModel.output
                        .confirmAuthCode()
                        .subscribe {
                            toast("인증 코드가 발송되었습니다.", Toast.LENGTH_LONG)
                        },

                viewModel.output
                        .isLoading()
                        .subscribe {
                            if(it == true) {
                                showLoadingDialog()
                            } else {
                                hideLoadingDialog()
                            }
                        }
        )
    }

}