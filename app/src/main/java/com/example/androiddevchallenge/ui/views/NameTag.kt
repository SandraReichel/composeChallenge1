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
package com.example.androiddevchallenge.ui.views

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.example.androiddevchallenge.Headline
import com.example.androiddevchallenge.HeadlineHuge
import com.example.androiddevchallenge.data.Cat

@Composable
fun NameTag(cat: Cat) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Headline(cat.name)
        cat.gender.icon?.let { Icon(it, contentDescription = cat.gender.name) }
        Text(" " + cat.age.toString() + " years old")
    }
}

@Composable
fun NameHugeTag(cat: Cat) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        HeadlineHuge(cat.name)
        cat.gender.icon?.let { Icon(it, contentDescription = cat.gender.name) }
        Text(" " + cat.age.toString() + " years old")
    }
}
