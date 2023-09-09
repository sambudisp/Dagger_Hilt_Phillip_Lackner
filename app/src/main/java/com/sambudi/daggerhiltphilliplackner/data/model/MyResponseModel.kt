package com.sambudi.daggerhiltphilliplackner.data.model

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class MyResponseModel(

	@field:SerializedName("cek")
	val cek: String? = null

) : Parcelable
