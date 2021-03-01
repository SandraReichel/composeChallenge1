package com.example.androiddevchallenge.ui.views

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.data.Feature

@Composable
fun FeatureChip(feature: Feature) {
    Box(modifier = Modifier.padding(4.dp)) {

        Card(
            elevation = 2.dp, backgroundColor = feature.color,
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.padding(2.dp)

        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(feature.icon, contentDescription = null, modifier = Modifier.padding(4.dp))
                Text(
                    text = feature.name,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(end = 4.dp)
                )
            }
        }
    }
}