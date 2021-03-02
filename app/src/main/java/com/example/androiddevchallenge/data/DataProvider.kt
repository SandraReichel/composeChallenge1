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

import com.example.androiddevchallenge.R

object DataProvider {

    fun getCatList() = arrayListOf(
        Cat(
            1, "Karli", R.drawable.ic_baseline_pets_24, 17, Gender.Male,
            arrayListOf(Fact.HomeTown("Spremberg"), Fact.ArrivalDate("12.12.2020")),
            arrayListOf(Feature.Fluffy, Feature.Cute)
        ),
        Cat(
            2, "Moni", R.drawable.ic_baseline_pets_24, 5, Gender.Female,
            arrayListOf(Fact.HomeTown("Schwarze Pumpe"), Fact.ArrivalDate("08.09.2019")),
            arrayListOf(Feature.Playful, Feature.Cute)
        ),
        Cat(
            3, "Mr Fluffels", R.drawable.ic_baseline_pets_24, 1, Gender.NotKnown,
            arrayListOf(Fact.HomeTown("Dresden"), Fact.ArrivalDate("01.01.2020")),
            arrayListOf(Feature.Fluffy, Feature.Cute, Feature.Quiet, Feature.Aggressive)
        ),
        Cat(
            4, "Lucky", R.drawable.ic_baseline_pets_24, 9, Gender.Male,
            arrayListOf(Fact.HomeTown("Hoyerswerda"), Fact.ArrivalDate("03.12.2020")),
            arrayListOf(Feature.Playful, Feature.Cute)
        ),
        Cat(
            5, "Kuh", R.drawable.ic_baseline_pets_24, 11, Gender.Male,
            arrayListOf(Fact.HomeTown("Heinrichsfeld"), Fact.ArrivalDate("02.03.2018")),
            arrayListOf()
        ),
        Cat(
            6, "Purzel", R.drawable.ic_baseline_pets_24, 3, Gender.Female,
            arrayListOf(Fact.HomeTown("Spremberg"), Fact.ArrivalDate("07.06.2018")),
            arrayListOf(Feature.Playful, Feature.Cute, Feature.Outside)
        ),
        Cat(
            7, "Biene", R.drawable.ic_baseline_pets_24, 15, Gender.Female,
            arrayListOf(Fact.HomeTown("Spremberg"), Fact.ArrivalDate("01.02.2021")),
            arrayListOf(Feature.Fluffy, Feature.Quiet)
        ),
        Cat(
            8, "Susi", R.drawable.ic_baseline_pets_24, 4, Gender.Male,
            arrayListOf(Fact.HomeTown("Spremberg"), Fact.ArrivalDate("28.12.2021")),
            arrayListOf(Feature.Cute, Feature.Quiet, Feature.Aggressive)
        )
    )

    fun getCat(id: Int) = getCatList().first { it.id == id }
}
