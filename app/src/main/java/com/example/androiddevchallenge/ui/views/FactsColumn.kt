package com.example.androiddevchallenge.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.Fact

@Composable
fun FactsColumn(facts: List<Fact>) {
    Column {
        facts.forEach { fact ->
            Row {
                Icon(fact.icon, contentDescription = null, modifier = Modifier.padding(4.dp).width(14.dp).height(14.dp))
                Text(fact.value)
            }
        }
    }
}
