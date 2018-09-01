package com.mashup.dutchmarket.ui.signup

import com.mashup.dutchmarket.di.ActivityScope
import com.mashup.dutchmarket.di.qualifier.SignUp
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable


@Module(includes = [SignUpModule.ProvideModule::class])
internal interface SignUpModule {

    @Module
    class ProvideModule {
        @Provides
        @ActivityScope
        @SignUp
        fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()
    }


}