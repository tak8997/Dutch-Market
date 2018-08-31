package com.mashup.dutchmarket.di

import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import javax.inject.Singleton


@Module(includes = [ApplicationModule.ProvideModule::class])
internal abstract class ApplicationModule {

    @Module
    class ProvideModule {


    }

    @Singleton
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: BaseViewModelFactory): ViewModelProvider.Factory
}