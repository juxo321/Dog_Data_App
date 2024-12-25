package com.example.dog_data_app.data.network.dto

import com.google.gson.annotations.SerializedName

data class DogBreedsResponse (
    @SerializedName("message") val message: Map<String, List<String>>,
    @SerializedName("status") val status: String
)