package com.example.tugaspppbp11api.network

import com.example.tugaspppbp11api.model.ResponseWrapper
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("api/characters")
    fun getCharacters(): Call<ResponseWrapper>
}
