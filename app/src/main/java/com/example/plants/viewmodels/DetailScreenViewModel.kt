package com.example.plants.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.plants.model.Plant
import com.example.plants.repository.PlantRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DetailScreenViewModel : ViewModel() {
    private val _plant = MutableStateFlow<Plant?>(null)
    val plant = _plant.asStateFlow()
    private val _numLikes = MutableStateFlow<Int>(0)
    val numLikes = _numLikes.asStateFlow()

    fun getPlant(plantId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _plant.value = PlantRepository.getPlant(plantId)
        }
    }

    fun getPlant(plantName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _plant.value = PlantRepository.getPlantByName(plantName)
        }
    }

    fun incrementLike() {
        _numLikes.value++
    }
}
