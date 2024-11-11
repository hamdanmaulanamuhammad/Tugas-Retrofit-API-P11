package com.example.tugaspppbp11api.model

import com.google.gson.annotations.SerializedName

data class ResponseWrapper(
    @SerializedName("message") val message: String,
    @SerializedName("dataAllPage") val dataAllPage: Int,
    @SerializedName("data") val data: List<Character>
)