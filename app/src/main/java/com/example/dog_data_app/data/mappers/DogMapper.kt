package com.example.dog_data_app.data.mappers

import com.example.dog_data_app.data.network.dto.DogResponse
import com.example.dog_data_app.domain.model.Dog

fun DogResponse.toDomain(): Dog {
    return Dog(message = this.message, status = this.status)
}