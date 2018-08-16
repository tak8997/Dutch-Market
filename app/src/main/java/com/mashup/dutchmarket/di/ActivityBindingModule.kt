package com.mashup.dutchmarket.di

import com.mashup.dutchmarket.ui.login.LoginActivity
import com.mashup.dutchmarket.ui.login.LoginModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
internal abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = [LoginModule::class])
    abstract fun mainActivity(): LoginActivity
}