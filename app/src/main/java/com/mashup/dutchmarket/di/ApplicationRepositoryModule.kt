package com.mashup.dutchmarket.di

import com.mashup.dutchmarket.DutchMarket
import com.mashup.dutchmarket.repository.HttpService
import com.mashup.dutchmarket.repository.Repository
import com.mashup.dutchmarket.repository.RepositoryApi
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module(includes = [ApplicationRepositoryModule.ProvideModule::class])
internal abstract class ApplicationRepositoryModule {

    @Module
    class ProvideModule {

        @Provides
        @Singleton
        fun provideHttpLoginInterceptor() : HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        @Provides
        @Singleton
        fun provideHttpClient(loggingInterceptor: HttpLoggingInterceptor) : OkHttpClient = OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()

        @Provides
        @Singleton
        fun provideRetrofit(okHttpClient: OkHttpClient) : Retrofit =
                Retrofit.Builder()
                        .client(okHttpClient)
                        .baseUrl(HttpService.Endpoint.baseUrl)
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()

        @Provides
        @Singleton
        fun provideHttpService(retrofit: Retrofit) : HttpService = retrofit.create(HttpService::class.java)
    }

    @Binds
    @Singleton
    abstract fun provideApplicationContext(dutchMarket: DutchMarket) : DutchMarket

    @Binds
    @Singleton
    abstract fun provideApplicationRepository(repository: Repository) : RepositoryApi
}