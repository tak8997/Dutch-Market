package com.mashup.dutchmarket.di

import com.mashup.dutchmarket.ui.LoginActivity
import com.mashup.dutchmarket.ui.LoginModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
internal abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = [LoginModule::class])
    abstract fun mainActivity(): LoginActivity
}