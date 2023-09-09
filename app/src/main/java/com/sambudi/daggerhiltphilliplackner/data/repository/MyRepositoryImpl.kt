package com.sambudi.daggerhiltphilliplackner.data.repository

import android.app.Application
import com.sambudi.daggerhiltphilliplackner.R
import com.sambudi.daggerhiltphilliplackner.data.model.MyResponseModel
import com.sambudi.daggerhiltphilliplackner.data.remote.MyApi
import com.sambudi.daggerhiltphilliplackner.domain.repository.MyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MyRepositoryImpl(
    private val api: MyApi
) : MyRepository {

    override suspend fun doNetworkCall() {
        api.doNetworkCall()
    }

    override suspend fun doNetworkCallWithFlow(): Flow<List<MyResponseModel>> = flow {
        emit(api.doNetworkCallWithFlow())
    }

}