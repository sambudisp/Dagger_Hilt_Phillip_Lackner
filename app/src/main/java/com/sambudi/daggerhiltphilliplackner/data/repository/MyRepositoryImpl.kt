package com.sambudi.daggerhiltphilliplackner.data.repository

import android.app.Application
import com.sambudi.daggerhiltphilliplackner.R
import com.sambudi.daggerhiltphilliplackner.data.remote.MyApi
import com.sambudi.daggerhiltphilliplackner.domain.repository.MyRepository

class MyRepositoryImpl(
    private val api: MyApi,
    private val applicationContext: Application // Cek di MyApp, ada anotasi supaya dagger-hilt tau bahwa kita butuh Application di repositoryimpl yg ini
) : MyRepository {

    init {
        val appName = applicationContext.getString(R.string.app_name) // contoh kalo butuh applicationContext
        println("Hallo dari RepositoryImpl. Nama aplikasi ini adalah : $appName")
    }

    override suspend fun doNetworkCall() {
        api.doNetworkCall()
    }

}