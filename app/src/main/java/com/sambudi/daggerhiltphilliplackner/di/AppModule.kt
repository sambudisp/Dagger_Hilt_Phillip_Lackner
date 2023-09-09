package com.sambudi.daggerhiltphilliplackner.di

import android.app.Application
import com.sambudi.daggerhiltphilliplackner.data.remote.MyApi
import com.sambudi.daggerhiltphilliplackner.data.repository.MyRepositoryImpl
import com.sambudi.daggerhiltphilliplackner.domain.repository.MyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton // artinya kita hanya punya 1x MyApi instance selama app aktif, tidak dipanggil berulang kali
    fun provideMyApi(): MyApi {
        return Retrofit.Builder()
            .baseUrl("https://test.com")
            .build()
            .create(MyApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMyRepository(
        api: MyApi
    ): MyRepository {
        return MyRepositoryImpl(api)
    }
}

/*
@InstallIn
    SingletonComponent (selama app aktif),
    ActivityComponent (selama activity aktif),
    ViewModelComponent (selama viewmodel aktif),
    ActivityRetainedComponent (AppModule tidak terDestroy ketika layar terotasi/recreated)
    ServiceComponent (handle dependency untuk Service)
*/
