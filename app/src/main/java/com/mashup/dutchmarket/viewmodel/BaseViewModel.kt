package com.mashup.dutchmarket.viewmodel

import android.arch.lifecycle.ViewModel
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.annotation.CallSuper


internal abstract class BaseViewModel : ViewModel() {

    @CallSuper
    fun onCreate(context: Context, instanceState: Bundle?) {

    }

    @CallSuper
    fun intent(intent: Intent) {

    }

    override fun onCleared() {

        super.onCleared()
    }
}