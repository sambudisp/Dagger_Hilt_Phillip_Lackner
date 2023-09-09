package com.sambudi.daggerhiltphilliplackner.domain.repository

import com.sambudi.daggerhiltphilliplackner.data.model.MyResponseModel
import kotlinx.coroutines.flow.Flow

interface MyRepository {
    suspend fun doNetworkCall()
    suspend fun doNetworkCallWithFlow() : Flow<List<MyResponseModel>>
}