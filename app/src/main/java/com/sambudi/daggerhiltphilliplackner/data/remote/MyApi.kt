package com.sambudi.daggerhiltphilliplackner.data.remote

import com.sambudi.daggerhiltphilliplackner.data.model.MyResponseModel
import retrofit2.http.GET

interface MyApi {

    @GET("test")
    suspend fun doNetworkCall()

    @GET("test")
    suspend fun doNetworkCallWithFlow() : List<MyResponseModel>

}