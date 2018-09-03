package com.mashup.dutchmarket.network

import com.mashup.dutchmarket.data.AuthCode
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query


internal interface HttpService {
    object Endpoint {
        const val baseUrl = "http://ec2-13-125-62-50.ap-northeast-2.compute.amazonaws.com"
    }

    @GET("/user/checkemail")
    fun fetchAuthNumber(@Query("userEmail") userEmail: String): Single<AuthCode>
}