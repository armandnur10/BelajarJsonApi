package com.example.belajarjsonapi.remote

import com.example.belajarjsonapi.remote.response.LambangItem
import com.example.belajarjsonapi.remote.response.ProvinsiResponse
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET

interface ApiService {

    @GET("province/200")
    fun getProvinsi(): Flowable<ProvinsiResponse>
}