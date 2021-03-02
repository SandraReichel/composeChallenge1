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
