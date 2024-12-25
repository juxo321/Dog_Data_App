package com.example.dog_data_app.domain

import com.example.dog_data_app.data.DogRepository
import javax.inject.Inject

class GetBreedsUseCase @Inject constructor(private val dogRepository: DogRepository) {

    suspend operator fun invoke(): List<String> {
        val response = dogRepository.getAllBreedsFromApi()
        if (response != null){
            return response.breeds
        }
        return emptyList()
    }
}