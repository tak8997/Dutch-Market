package com.mashup.dutchmarket.di

import com.mashup.dutchmarket.ui.MainActivity
import com.mashup.dutchmarket.ui.MainModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
internal abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun mainActivity(): MainActivity
}