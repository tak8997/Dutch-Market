package com.mashup.dutchmarket.di

import com.mashup.dutchmarket.DutchMarket
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(
        AndroidSupportInjectionModule::class,
        ActivityBindingModule::class,
        ApplicationModule::class,
        ApplicationRepositoryModule::class
))
internal interface ApplicationComponent : AndroidInjector<DutchMarket> {

//    @Component.Builder
//    interface Bulder {
//
//        @BindsInstance
//        fun application(application: Application): Bulder
//
//        fun build(): ApplicationComponent
//    }

    @Component.Builder
    abstract class Builder: AndroidInjector.Builder<DutchMarket>()
}