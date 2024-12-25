package com.example.dog_data_app.data.mappers

import com.example.dog_data_app.data.network.dto.DogBreedsResponse
import com.example.dog_data_app.domain.model.DogBreeds


fun DogBreedsResponse.toDomain(): DogBreeds {
    return DogBreeds(this.message.keys.toList())
}