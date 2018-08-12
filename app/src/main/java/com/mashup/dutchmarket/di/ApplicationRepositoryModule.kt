package com.mashup.dutchmarket.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
internal class ApplicationRepositoryModule {
    @Provides
    @Singleton
    fun provideOkhttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY


    }

    @Provides
    @Singleton
    fun retrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build()
    }

    @Provides
    @Singleton
    fun provideBeerApiService(retrofit: Retrofit): BeerApiService {
        return retrofit.create(BeerApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideBeerDatabase(context: Application): BeerDatabase {
        return Room.databaseBuilder(
                context,
                BeerDatabase::class.java,
                Constant.DB_NAME)
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
    }

//    @Provides
//    @Singleton
//    fun provideApplicationContext(): Context = app.applicationContext
//
//    @Provides
//    @Singleton
//    fun provideGson(): Gson = Gson()
//
//
//    @Provides
//    @Singleton
//    fun provideApiClient(apiService: APIService): APIClientType = APIClient(apiService)
//
//    @Provides
//    @Singleton
//    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
//
//    @Provides
//    @Singleton
//    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor, apiRequestInterceptor: APIRequestInterceptor): OkHttpClient =
//            OkHttpClient.Builder()
//                    .addInterceptor(httpLoggingInterceptor)
//                    .addInterceptor(apiRequestInterceptor)
//                    .build()
//
//    @Provides
//    @Singleton
//    fun provideApiReuqestInterceptor(currentUser: CurrentUser) = APIRequestInterceptor(currentUser)
//
//    @Provides
//    @Singleton
//    fun provideSharedPreferenceManager(context: Context) = SharedPreferenceManager(context)
//
//    @Provides
//    @Singleton
//    fun provideCurrentUser(sharedPreferenceManager: SharedPreferenceManager) = CurrentUser(sharedPreferenceManager = sharedPreferenceManager)
//
//    @Provides
//    @Singleton
//    fun provideApiService(gson: Gson, okhttpCLient: OkHttpClient): APIService =
//            Retrofit.Builder()
//                    .client(okhttpCLient)
//                    .baseUrl(APIService.EndPoint.baseUrl)
//                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                    .addConverterFactory(GsonConverterFactory.create(gson))
//                    .build()
//                    .create(APIService::class.java)
}