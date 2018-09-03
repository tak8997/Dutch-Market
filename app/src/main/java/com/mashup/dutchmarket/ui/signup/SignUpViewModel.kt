package com.mashup.dutchmarket.ui.signup

import android.text.TextUtils
import com.mashup.dutchmarket.BaseViewModel
import com.mashup.dutchmarket.extension.isValidateEmail
import com.mashup.dutchmarket.repository.SignUpRepositoryApi
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject


internal interface SignUpViewModel {
    interface Input {
        fun fetchAuthNumber(email: String)
    }

    interface Output {
        fun confirmAuthCode(): Observable<String>
        fun isLoading(): Observable<Boolean>
    }

    class ViewModel @Inject constructor(
            private val signUpRepository: SignUpRepositoryApi

    ) : BaseViewModel(), Input, Output {

        val input: Input = this
        private val userEmail = PublishSubject.create<String>()

        val output: Output = this
        private val authCode = PublishSubject.create<String>()
        private val isLoading = PublishSubject.create<Boolean>()

        init {
            userEmail
                    .filter { !TextUtils.isEmpty(it) && it.isValidateEmail }
                    .doOnSubscribe { isLoading.onNext(true) }
                    .map { signUpRepository.fetchAuthNumber(it) }
                    .doOnTerminate { isLoading.onNext(false) }
                    .subscribe {
                        authCode
                    }
        }

        override fun fetchAuthNumber(email: String) = userEmail.onNext(email)

        override fun confirmAuthCode(): Observable<String> = authCode
        override fun isLoading(): Observable<Boolean> = isLoading

    }
}