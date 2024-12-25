package com.example.dog_data_app.ui.screen.randomdog

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dog_data_app.domain.GetBreedsUseCase
import com.example.dog_data_app.domain.GetRandomDogUseCase
import com.example.dog_data_app.domain.model.Dog
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RandomDogViewModel @Inject constructor(
    private val getRandomDogUseCase: GetRandomDogUseCase,
    private val getBreedsUseCase: GetBreedsUseCase
):ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val _dog = MutableLiveData<Dog>()
    val dog: LiveData<Dog> get() = _dog

    private val _error = MutableLiveData<Boolean>(false)
    val error: LiveData<Boolean> get() = _error

    private val _breeds = MutableLiveData<List<String>>()
    val breeds: LiveData<List<String>> get() = _breeds

    val selectedOption = MutableLiveData<String>("")


    init {
        getAllBreeds()
    }

    private fun getAllBreeds(){
        _isLoading.value = true
        viewModelScope.launch {
            val response = getBreedsUseCase()
            if (response.isNotEmpty()) {
                _breeds.value = response!!
                selectedOption.value = breeds.value!![0]
                getRandomDog(selectedOption.value!!)
            }else {
                _error.value = true
            }
            _isLoading.value = false
        }
    }

    fun getRandomDog(selectedOption: String) {
        _isLoading.value = true
        viewModelScope.launch {
            val response = getRandomDogUseCase(breed = selectedOption)
            if (response != null) {
                _dog.value = response!!
            }else {
                _error.value = true
            }
            _isLoading.value = false
        }
    }


}