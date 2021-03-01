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
package com.example.androiddevchallenge

import android.os.Bundle
import android.view.Gravity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.data.Cat
import com.example.androiddevchallenge.data.DataProvider
import com.example.androiddevchallenge.data.Feature
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.purple200

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    Surface(color = MaterialTheme.colors.background) {
        Column {
            Text(text = "Ready... Set... GO!")
            CatList( DataProvider.getCatList())
        }
    }
}


@Composable
fun Header() {
    Text(text = "Ready... Set... GO!")
}

@Composable
fun CatList(cats: List<Cat>) {
    Column {
        Header()
        cats.forEach { message ->
            CatItem(message, {})
        }
    }
}


@Composable
fun CatItem(cat: Cat, onClick: () -> Unit) {
    Card(
        elevation = 8.dp, shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(16.dp)
            .fillMaxWidth()
    ) {

        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            NameTag(cat = cat)

            Row(verticalAlignment = Alignment.Top) {
                Image(
                    painter = painterResource(R.drawable.karli),
                    contentDescription = "cute cat",
                    modifier = Modifier
                        .height(80.dp)
                        .width(80.dp)
                        .padding(8.dp)
                        .clip(shape = RoundedCornerShape(10.dp)),
                    contentScale = ContentScale.Crop
                )

                FeatureItem(features = cat.features)
            }
        }
    }
}


@Composable
fun FeatureItem(features: List<Feature>) {
    Column(horizontalAlignment = Alignment.End,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        val chunkedList = features.chunked(2)
        chunkedList.forEach {
            Row() {
                it.forEach { feature ->
                    FeatureChip(feature = feature)
                }
            }
        }
    }
}

@Composable
fun NameTag(cat: Cat) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Headline(cat.name)
        Text(" " + cat.age.toString() + " years old")
    }

}

@Composable
fun FeatureChip(feature: Feature) {
    Card(
        elevation = 4.dp, backgroundColor = feature.color, shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .padding(4.dp)

    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(feature.icon),
                contentDescription = "cute cat",
                modifier = Modifier
                    .padding(4.dp)
            )
            Text(text = feature.name)


        }
    }
}

@Composable
fun Headline(text: String) {
    Text(text = text, fontSize = 20.sp, style = TextStyle(fontWeight = FontWeight.Bold))
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}
