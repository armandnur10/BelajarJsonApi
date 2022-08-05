package com.example.belajarjsonapi.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.belajarjsonapi.remote.response.LambangItem
import com.example.belajarjsonapi.remote.ApiConfig
import com.example.belajarjsonapi.remote.response.ProvinsiResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Response

class MainViewModel: ViewModel() {

    val lambangItem = MutableLiveData<List<LambangItem>>()

    val isLoading = MutableLiveData<Boolean>()
    val isError = MutableLiveData<Throwable>()

    fun getProvinsi(
        responseHandlerProvinsi: (ProvinsiResponse) -> Unit,
        error: (Throwable) -> Unit
    )   {
        ApiConfig().getApiService().getProvinsi().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responseHandlerProvinsi(it)
            }, {
                error(it)
            })
    }

    fun getDataProvinsi() {
        isLoading.value = true
        getProvinsi({
            isLoading.value = false
            lambangItem.value = it.lambang
        }, {
            isLoading.value = false
            isError.value = it
        })
    }
}

