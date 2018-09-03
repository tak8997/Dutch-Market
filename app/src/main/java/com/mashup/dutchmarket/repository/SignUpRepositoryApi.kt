package com.mashup.dutchmarket.repository

import com.mashup.dutchmarket.data.AuthCode
import io.reactivex.Single


internal interface SignUpRepositoryApi {
    fun fetchAuthNumber(email: String): Single<AuthCode>
}