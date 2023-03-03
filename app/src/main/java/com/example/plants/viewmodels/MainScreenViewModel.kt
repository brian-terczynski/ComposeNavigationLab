package com.example.plants.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.plants.model.Plant
import com.example.plants.repository.PlantRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainScreenViewModel : ViewModel() {
    private val _plants = MutableStateFlow<List<Plant>>(
        emptyList()
    )
    val plants = _plants.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _plants.value = PlantRepository.getAllPlants()
        }
    }
}
