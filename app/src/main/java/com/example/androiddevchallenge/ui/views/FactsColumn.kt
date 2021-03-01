package com.example.androiddevchallenge.ui.views

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.example.androiddevchallenge.data.Fact

@Composable
fun FactsColumn(facts: List<Fact>) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        facts.forEach { fact ->
            Icon(fact.icon, contentDescription = null)
            Text(fact.value)
        }

    }
}