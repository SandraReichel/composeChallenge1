package com.example.androiddevchallenge.data

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.purple200

data class Cat(
    val id: Int,
    val name: String,
    val age: Int,
    val features: List<Feature>
)

sealed class Feature(val name: String, val color: Color, @DrawableRes val icon: Int) {
    object Playful : Feature("playful", Color(0xFFE0BBE4), R.drawable.ic_baseline_videogame_asset_24)
    object Quiet : Feature("quiet", Color(0xFF957DAD), R.drawable.ic_baseline_self_improvement_24)
    object Aggressive : Feature("aggressive", Color(0xFFD291BC), R.drawable.ic_baseline_sports_kabaddi_24)
    object Cute : Feature("cute", Color(0xFFFEC8D8), R.drawable.ic_baseline_tag_faces_24)
    object Fluffy : Feature("fluffy", Color(0xFFFFDFD3), R.drawable.ic_baseline_face_24)
    object Outside : Feature("outside", Color(0xFFE0BFD3), R.drawable.ic_baseline_eco_24)
}
