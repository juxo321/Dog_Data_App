package com.example.dog_data_app.data

import com.example.dog_data_app.data.mappers.toDomain
import com.example.dog_data_app.data.network.DogService
import com.example.dog_data_app.domain.model.Dog
import com.example.dog_data_app.domain.model.DogBreeds
import javax.inject.Inject

class DogRepository @Inject constructor(private val dogService: DogService) {

    suspend fun getRandomDogFromApi(breed: String): Dog? {
        return dogService.getRandomDog(breed)?.toDomain()
    }

    suspend fun getAllBreedsFromApi(): DogBreeds? {
        return dogService.getAllBreeds()?.toDomain()
    }

}