package com.example.dog_data_app.data.network

import android.util.Log
import com.example.dog_data_app.data.network.dto.DogBreedsResponse
import com.example.dog_data_app.data.network.dto.DogResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DogService @Inject constructor(private val dogApiClient: DogApiClient) {

    suspend fun getRandomDog(breed: String): DogResponse? {
        return  withContext(Dispatchers.IO){
            val response = dogApiClient.getRandomDog(breed)
            response.body()
        }
    }

    suspend fun getAllBreeds(): DogBreedsResponse? {
        return withContext(Dispatchers.IO){
            val response = dogApiClient.getAllBreeds()
            response.body()
        }
    }
}