package com.mashup.dutchmarket.ui.signup

import android.content.Context
import android.util.Log
import com.mashup.dutchmarket.BaseViewModel
import com.mashup.dutchmarket.di.qualifier.SignUp
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


internal interface SignUpViewModel {
    interface Input {

    }

    interface Output {

    }

    class ViewModel @Inject constructor(
//            @SignUp val compositeDisposable: CompositeDisposable

    ) : BaseViewModel(), Input, Output {

        init {
            Log.d("asdf!!","aa")
        }

        override fun getActivityScopeDisposable(): CompositeDisposable = CompositeDisposable()
    }
}