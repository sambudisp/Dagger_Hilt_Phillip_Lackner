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

    /*@Provides
    @Singleton
    fun provideMyRepository(
        api: MyApi,
        applicationContext: Application,
        @Named("hello1") hello: String
    ): MyRepository {
        return MyRepositoryImpl(api, applicationContext)
    }*/

    @Provides
    @Singleton
    @Named("hello1")
    // jika ada function yg returnnya sama, kita tambahin @Named untuk ngasih tau dagger-hilt bahwa yang kita inginkan adalah Function yg ini, bukan yang lain. Cara pemanggilannya ada di contoh provideMyRepository
    // karena jika tanpa @Named dagger-hilt akan bingung harus manggil yang mana, kalau tidak ada yang sama baru deh tanpa @Named gpp kayak si provideMyRepository
    fun provideStringLangsung1() = "Helloww 1"

    @Provides
    @Singleton
    @Named("hello2")
    fun provideStringLangsung2() = "Helloww 2"
}

/*
@InstallIn
    SingletonComponent (selama app aktif),
    ActivityComponent (selama activity aktif),
    ViewModelComponent (selama viewmodel aktif),
    ActivityRetainedComponent (AppModule tidak terDestroy ketika layar terotasi/recreated)
    ServiceComponent (handle dependency untuk Service)
*/
