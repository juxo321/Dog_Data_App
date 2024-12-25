package com.example.dog_data_app.domain

import com.example.dog_data_app.data.DogRepository
import com.example.dog_data_app.domain.model.DogBreeds
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetBreedsUseCaseTest {

    @MockK
    lateinit var dogRepository: DogRepository

    lateinit var getBreedsUseCase: GetBreedsUseCase

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getBreedsUseCase = GetBreedsUseCase(dogRepository)
    }


    @Test
    fun `when the api doesnt return any breed`() = runBlocking {
        coEvery { dogRepository.getAllBreedsFromApi() } returns null

        val response = getBreedsUseCase()

        assert(response == emptyList<String>())

    }

    @Test
    fun `when the api returns a DogBreeds object that contains a list of string`() = runBlocking {
        val dogBreeds = DogBreeds(listOf("beagle"))
        val breedList = listOf("beagle")

        coEvery { dogRepository.getAllBreedsFromApi()  } returns dogBreeds

        val response = getBreedsUseCase()

        assert(response == breedList)

    }


}