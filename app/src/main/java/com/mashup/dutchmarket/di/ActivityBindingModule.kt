package com.mashup.dutchmarket.di

import com.mashup.dutchmarket.ui.login.LoginActivity
import com.mashup.dutchmarket.ui.login.LoginModule
import com.mashup.dutchmarket.ui.signup.SignUpActivity
import com.mashup.dutchmarket.ui.signup.SignUpModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
internal abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [LoginModule::class])
    abstract fun mainActivity(): LoginActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [SignUpModule::class])
    abstract fun signUpActivity(): SignUpActivity
}