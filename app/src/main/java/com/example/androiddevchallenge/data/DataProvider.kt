package com.example.androiddevchallenge.data

object DataProvider {

    fun getCatList() = arrayListOf(
        Cat(1, "Karli", 17, arrayListOf(Feature.Fluffy, Feature.Cute)),
        Cat(2, "Moni", 5, arrayListOf(Feature.Playful, Feature.Cute)),
        Cat(
            3,
            "Mutschmann",
            1,
            arrayListOf(Feature.Fluffy, Feature.Cute, Feature.Quiet, Feature.Aggressive)
        ),
        Cat(4, "Lucky", 9, arrayListOf(Feature.Playful, Feature.Cute)),
        Cat(5, "Kuh", 11, arrayListOf()),
        Cat(
            6,
            "Purzel",
            3,
            arrayListOf(Feature.Playful, Feature.Cute, Feature.Outside)
        ),
        Cat(7, "Biene", 15, arrayListOf(Feature.Fluffy, Feature.Quiet)),
        Cat(8, "Susi", 4, arrayListOf(Feature.Cute, Feature.Quiet, Feature.Aggressive))
    )
}
