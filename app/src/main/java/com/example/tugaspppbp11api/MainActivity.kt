package com.example.tugaspppbp11api

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugaspppbp11api.databinding.ActivityMainBinding
import com.example.tugaspppbp11api.model.Character
import com.example.tugaspppbp11api.model.ResponseWrapper
import com.example.tugaspppbp11api.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup RecyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        // Panggil API untuk mengambil data karakter
        fetchCharacters()
    }

    private fun fetchCharacters() {
        val apiService = ApiClient.getInstance()
        apiService.getCharacters().enqueue(object : Callback<ResponseWrapper> {
            override fun onResponse(call: Call<ResponseWrapper>, response: Response<ResponseWrapper>) {
                if (response.isSuccessful) {
                    // Ambil daftar karakter dari data respons
                    val characters = response.body()?.data ?: emptyList()
                    // Set adapter RecyclerView dengan daftar karakter
                    binding.recyclerView.adapter = CharacterAdapter(characters)
                } else {
                    Toast.makeText(this@MainActivity, "Failed to load data", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ResponseWrapper>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
