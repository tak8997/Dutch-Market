package com.mashup.dutchmarket.di

import com.mashup.dutchmarket.ui.login.LoginActivity
import com.mashup.dutchmarket.ui.login.LoginModule
import com.mashup.dutchmarket.ui.login.SignUpActivity
import com.mashup.dutchmarket.ui.login.SignUpModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
internal abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = [LoginModule::class])
    abstract fun mainActivity(): LoginActivity

    @ContributesAndroidInjector(modules = [SignUpModule::class])
    abstract fun signUpActivity(): SignUpActivity
}