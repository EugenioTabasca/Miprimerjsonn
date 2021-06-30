package com.example.jsonporfavor.Common

import com.example.jsonporfavor.Interface.RetrofitService
import com.example.jsonporfavor.Retrofit.RetrofitClient
import retrofit2.create

object Common {

    private val  BASE_URL = "https://simplifiedcoding.net/demos/"

    val retrofitService : RetrofitService
    get() = RetrofitClient.getClient(BASE_URL).create(RetrofitService::class.java)

}