package com.example.dog_data_app.domain

import android.util.Log
import com.example.dog_data_app.data.DogRepository
import com.example.dog_data_app.domain.model.Dog
import javax.inject.Inject

class GetRandomDogUseCase @Inject constructor(private val dogRepository: DogRepository) {

    suspend operator fun invoke(breed: String) : Dog? {
        val dog = dogRepository.getRandomDogFromApi(breed)
        if (dog != null) {
            return dog
        }
        return null
    }
}