package com.example.dog_data_app.data.network.dto

import com.google.gson.annotations.SerializedName

data class DogResponse(
    @SerializedName("message") val message: String,
    @SerializedName("status") val status: String
)