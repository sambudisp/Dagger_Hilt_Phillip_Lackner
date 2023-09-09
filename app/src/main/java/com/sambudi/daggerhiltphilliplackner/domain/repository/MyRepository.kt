package com.sambudi.daggerhiltphilliplackner.domain.repository

interface MyRepository {
    suspend fun doNetworkCall()
}