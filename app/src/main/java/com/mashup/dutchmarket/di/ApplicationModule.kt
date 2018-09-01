package com.mashup.dutchmarket.di

import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import com.mashup.dutchmarket.BaseViewModelFactory
import com.mashup.dutchmarket.DutchMarket
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module(includes = [ApplicationModule.ProvideModule::class])
internal abstract class ApplicationModule {

    @Module
    class ProvideModule {

        @Singleton
        @Provides
        fun provideContext(): Context = DutchMarket.instance
    }

    @Singleton
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: BaseViewModelFactory): ViewModelProvider.Factory
}