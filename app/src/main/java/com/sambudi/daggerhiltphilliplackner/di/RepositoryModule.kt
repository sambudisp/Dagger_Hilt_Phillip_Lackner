package com.sambudi.daggerhiltphilliplackner.di

import com.sambudi.daggerhiltphilliplackner.data.repository.MyRepositoryImpl
import com.sambudi.daggerhiltphilliplackner.domain.repository.MyRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/*
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindMyRepository(
        myRepositoryImpl: MyRepositoryImpl
    ) : MyRepository

}*/
