package com.example.tugaspppbp11api.model

import com.google.gson.annotations.SerializedName

data class Character(
    @SerializedName("_id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("school") val school: String,
    @SerializedName("birthday") val birthday: String,
    @SerializedName("photoUrl") val photoUrl: String,
    @SerializedName("image") val image: String,
    @SerializedName("imageSchool") val imageSchool: String,
    @SerializedName("damageType") val damageType: String
)
