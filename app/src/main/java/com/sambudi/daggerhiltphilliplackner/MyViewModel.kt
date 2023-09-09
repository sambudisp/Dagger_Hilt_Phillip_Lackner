package com.sambudi.daggerhiltphilliplackner

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.direku.cuanamansambilrebahan.data.source.responsestatus.Resource
import com.sambudi.daggerhiltphilliplackner.data.model.MyResponseModel
import com.sambudi.daggerhiltphilliplackner.domain.repository.MyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val repository: MyRepository
    //private val repository: Lazy<MyRepository> // Jika menggunakan ini, maka repository tidak akan dicreate kecuali dipanggil
) : ViewModel() {

    private val _result = MutableLiveData<Resource<List<MyResponseModel>>>()
    val result: MutableLiveData<Resource<List<MyResponseModel>>> = _result

    suspend fun hitMyApi() = repository.doNetworkCall()

    suspend fun hitMyApiWithFlow() {
        viewModelScope.launch {
            _result.value = Resource.loading()
            repository.doNetworkCallWithFlow()
                .flowOn(Dispatchers.IO)
                .catch { e ->
                    // Handle e
                    _result.postValue(Resource.throwable(e))
                }
                .collect { result ->
                    _result.postValue(Resource.success(result))
                }
        }
    }
}