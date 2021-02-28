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
    object Playful : Feature("playful", purple200, R.drawable.ic_baseline_videogame_asset_24)
    object Quiet : Feature("quiet", purple200, R.drawable.ic_baseline_self_improvement_24)
    object Aggressive : Feature("aggressive", purple200, R.drawable.ic_baseline_sports_kabaddi_24)
    object Cute : Feature("cute", purple200, R.drawable.ic_baseline_tag_faces_24)
    object Fluffy : Feature("fluffy", purple200, R.drawable.ic_baseline_face_24)
    object Outside : Feature("outside", purple200, R.drawable.ic_baseline_eco_24)
}