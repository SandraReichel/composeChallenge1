/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.data

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.EmojiNature
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Female
import androidx.compose.material.icons.filled.LocationCity
import androidx.compose.material.icons.filled.Male
import androidx.compose.material.icons.filled.SelfImprovement
import androidx.compose.material.icons.filled.SportsKabaddi
import androidx.compose.material.icons.filled.TagFaces
import androidx.compose.material.icons.filled.VideogameAsset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class Cat(
    val id: Int,
    val name: String,
    @DrawableRes val image: Int,
    val age: Int,
    val gender: Gender,
    val facts: List<Fact>,
    val features: List<Feature>
)

sealed class Fact(val value: String, val icon: ImageVector) {
    class HomeTown(townName: String) : Fact(townName, Icons.Filled.LocationCity)
    class ArrivalDate(date: String) : Fact(date, Icons.Filled.CalendarToday)
}

sealed class Feature(val name: String, val color: Color, val icon: ImageVector) {
    object Playful : Feature("playful", Color(0xFFE0BBE4), Icons.Filled.VideogameAsset)
    object Quiet : Feature("quiet", Color(0xFF957DAD), Icons.Filled.SelfImprovement)
    object Aggressive : Feature("aggressive", Color(0xFFD291BC), Icons.Filled.SportsKabaddi)
    object Cute : Feature("cute", Color(0xFFFEC8D8), Icons.Filled.TagFaces)
    object Fluffy : Feature("fluffy", Color(0xFFFFDFD3), Icons.Filled.Face)
    object Outside : Feature("outside", Color(0xFFE0BFD3), Icons.Filled.EmojiNature)
}

sealed class Gender(val name: String, val icon: ImageVector?) {
    object Male : Gender("male", Icons.Filled.Male)
    object Female : Gender("female", Icons.Filled.Female)
    object NotKnown : Gender("not known", null)
}
