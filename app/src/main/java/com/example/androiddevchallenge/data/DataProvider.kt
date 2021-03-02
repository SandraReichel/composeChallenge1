package com.example.androiddevchallenge.data

object DataProvider {

    fun getCatList() = arrayListOf(
        Cat(
            1, "Karli", 17, Gender.Male,
            arrayListOf(Fact.HomeTown("Spremberg"), Fact.ArrivalDate("12.12.2020")),
            arrayListOf(Feature.Fluffy, Feature.Cute)
        ),
        Cat(
            2, "Moni", 5, Gender.Female,
            arrayListOf(Fact.HomeTown("Schwarze Pumpe"), Fact.ArrivalDate("08.09.2019")),
            arrayListOf(Feature.Playful, Feature.Cute)
        ),
        Cat(
            3, "Mr Fluffels", 1, Gender.NotKnown,
            arrayListOf(Fact.HomeTown("Dresden"), Fact.ArrivalDate("01.01.2020")),
            arrayListOf(Feature.Fluffy, Feature.Cute, Feature.Quiet, Feature.Aggressive)
        ),
        Cat(
            4, "Lucky", 9, Gender.Male,
            arrayListOf(Fact.HomeTown("Hoyerswerda"), Fact.ArrivalDate("03.12.2020")),
            arrayListOf(Feature.Playful, Feature.Cute)
        ),
        Cat(
            5, "Kuh", 11, Gender.Male,
            arrayListOf(Fact.HomeTown("Heinrichsfeld"), Fact.ArrivalDate("02.03.2018")),
            arrayListOf()),
        Cat(
            6, "Purzel", 3, Gender.Female,
            arrayListOf(Fact.HomeTown("Spremberg"), Fact.ArrivalDate("07.06.2018")),
            arrayListOf(Feature.Playful, Feature.Cute, Feature.Outside)
        ),
        Cat(
            7, "Biene", 15, Gender.Female,
            arrayListOf(Fact.HomeTown("Spremberg"), Fact.ArrivalDate("01.02.2021")),
            arrayListOf(Feature.Fluffy, Feature.Quiet)
        ),
        Cat(
            8, "Susi", 4, Gender.Male,
            arrayListOf(Fact.HomeTown("Spremberg"), Fact.ArrivalDate("28.12.2021")),
            arrayListOf(Feature.Cute, Feature.Quiet, Feature.Aggressive)
        )
    )

    fun getCat(id: Int) = getCatList().first { it.id == id }
}
