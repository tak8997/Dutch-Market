package com.mashup.dutchmarket

import android.app.Activity
import android.app.Application
import com.mashup.dutchmarket.di.DaggerApplicationComponent
import com.squareup.leakcanary.LeakCanary
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

internal class DutchMarket : Application(), HasActivityInjector {

    companion object {
        lateinit var instance: DutchMarket
            private set
    }

    @Inject lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        instance = this

        intializeDagger()
        intializeLeakCanary()
    }

    private fun intializeLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return
        }
        LeakCanary.install(this)
    }

    private fun intializeDagger() {
        DaggerApplicationComponent
                .builder()
                .create(this)
                .inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector
}
