package com.example.dog_data_app.data.network

import com.example.dog_data_app.data.network.dto.DogBreedsResponse
import com.example.dog_data_app.data.network.dto.DogResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DogApiClient {

    @GET("breed/{breed}/images/random")
    suspend fun getRandomDog(@Path("breed") breed: String): Response<DogResponse>

    @GET("breeds/list/all")
    suspend fun getAllBreeds(): Response<DogBreedsResponse>
}