package com.sambudi.daggerhiltphilliplackner

import androidx.lifecycle.ViewModel
import com.sambudi.daggerhiltphilliplackner.domain.repository.MyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val repository: MyRepository
    //private val repository: Lazy<MyRepository> // Jika menggunakan ini, maka repository tidak akan dicreate kecuali dipanggil
) : ViewModel() {

    suspend fun hitMyApi() = repository.doNetworkCall()
}