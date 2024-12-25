package com.example.dog_data_app.domain

import com.example.dog_data_app.data.DogRepository
import com.example.dog_data_app.domain.model.Dog
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetRandomDogUseCaseTest {

    @MockK
    private lateinit var dogRepository: DogRepository


    lateinit var getRandomDogUseCase: GetRandomDogUseCase

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getRandomDogUseCase = GetRandomDogUseCase(dogRepository)
    }

    @Test
    fun `when the api return anything`() = runBlocking {
        val breed = "beagle"
        coEvery { dogRepository.getRandomDogFromApi(breed) } returns null

        val response = getRandomDogUseCase(breed)

        assert(response == null)
    }

    @Test
    fun `when the api returns a dog that isnt null`() = runBlocking {
        val breed = "beagle"
        val message = "https://images.dog.ceo/breeds/boxer/n02108089_3365.jpg"
        val status = "success"
        val dog = Dog(message, status)

        coEvery { dogRepository.getRandomDogFromApi(breed) }returns dog

        val response = getRandomDogUseCase(breed)

        assert(response == dog)

    }

}