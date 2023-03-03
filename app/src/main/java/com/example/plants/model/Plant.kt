package com.example.plants.model

import androidx.annotation.DrawableRes
import androidx.annotation.IdRes

data class Plant(
    val id: Int,
    val name: String,
    val description: String,
    @DrawableRes val imageId: Int,
)
