package com.example.tugaspppbp11api.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    fun getInstance(): ApiService {
        // Membuat logging interceptor untuk melihat log dari request/response
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        // Menambahkan logging interceptor ke OkHttpClient
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

        // Membuat instance Retrofit dengan konfigurasi yang sudah ditentukan
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api-blue-archive.vercel.app")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        // Mengembalikan instance ApiService
        return retrofit.create(ApiService::class.java)
    }
}