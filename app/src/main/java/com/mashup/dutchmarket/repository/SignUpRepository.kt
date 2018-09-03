package com.mashup.dutchmarket.repository

import com.mashup.dutchmarket.data.AuthCode
import com.mashup.dutchmarket.error.CannotVerifyAuthCode
import com.mashup.dutchmarket.error.NotConnectedNetworkError
import com.mashup.dutchmarket.network.HttpService
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


internal class SignUpRepository @Inject constructor(
        private val httpService: HttpService

) : SignUpRepositoryApi {

    override fun fetchAuthNumber(email: String): Single<AuthCode> =
            httpService
                    .fetchAuthNumber(email)
                    .onErrorResumeNext {
                        Single.error(
                                if (it is HttpException && it.code() != 200)
                                    CannotVerifyAuthCode()
                                else if (it is IOException)
                                    NotConnectedNetworkError()
                                else
                                    it
                        )
                    }
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())


}