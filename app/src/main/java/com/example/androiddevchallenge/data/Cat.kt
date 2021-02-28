package com.example.androiddevchallenge.data

import androidx.compose.ui.graphics.Color
import com.example.androiddevchallenge.ui.theme.purple200

data class Cat(
    val id: Int,
    val name: String,
    val age: Int,
    val features: List<Feature>
)

sealed class Feature(color: Color) {
    object Playful : Feature(purple200)
    object Quiet : Feature(purple200)
    object Agressive : Feature(purple200)
    object Cute : Feature(purple200)
}