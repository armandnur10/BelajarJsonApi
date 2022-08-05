package com.example.belajarjsonapi.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProvinsiResponse(

	@field:SerializedName("lambang")
	val lambang: List<LambangItem>? = null

) : Parcelable

@Parcelize
data class LambangItem(

	@field:SerializedName("index")
	val index: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("url")
	val url: String? = null
) : Parcelable
