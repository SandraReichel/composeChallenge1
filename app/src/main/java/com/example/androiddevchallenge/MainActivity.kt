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

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pets
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.CatDetailActivity.Companion.ARGUMENT_CAT_ID
import com.example.androiddevchallenge.data.Cat
import com.example.androiddevchallenge.data.DataProvider
import com.example.androiddevchallenge.data.Fact
import com.example.androiddevchallenge.data.Feature
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.views.FeatureChip
import com.example.androiddevchallenge.ui.views.NameTag

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp { catId -> openCatProfile(catId) }
            }
        }
    }

    private fun openCatProfile(catId: Int) {
        val intent = Intent(this, CatDetailActivity::class.java).apply {
            putExtra(ARGUMENT_CAT_ID , catId)
        }
        startActivity(intent)
    }
}

@Composable
fun MyApp(onCatClicked: (Int) -> Unit) {
    Surface(color = MaterialTheme.colors.background) {
        Column(horizontalAlignment = Alignment.End, modifier = Modifier.fillMaxWidth()
        ) {
            TopAppBar(title = {
                Row{
                    Text(text = "A Cat like Karli ")
                    Icon(Icons.Filled.Pets, contentDescription = null)
                } })
            CatList(DataProvider.getCatList()) {
                onCatClicked.invoke(it)
            }
        }
    }
}


@Composable
fun Header() {
    Text(
        text = "Adopting an animal can change a life. All these cute animals are ready to find a caring family",
        fontSize = 20.sp,
        modifier = Modifier.padding(20.dp),
        style = TextStyle(fontWeight = FontWeight.SemiBold)
    )
}

@Composable
fun CatList(cats: List<Cat>, onCatClicked: (Int) -> Unit) {
    LazyColumn {
        item { Header() }
        items(cats) { cat ->
            CatItem(cat) {
                onCatClicked(cat.id)
            }
        }
    }
}

@Composable
fun CatItem(cat: Cat, onClick: () -> Unit) {
    Row {
        Card(
            elevation = 8.dp, shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .clickable(onClick = onClick)
                .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
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
                    //FactsColumn(facts = cat.facts)
                    FeatureItem(features = cat.features)
                }
            }
        }
    }
}


@Composable
fun FeatureItem(features: List<Feature>) {
    Column(
        horizontalAlignment = Alignment.End,
        modifier = Modifier
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
fun Headline(text: String) {
    Text(text = text, fontSize = 20.sp, style = TextStyle(fontWeight = FontWeight.Bold))
}

@Composable
fun HeadlineHuge(text: String) {
    Text(text = text, fontSize = 24.sp, style = TextStyle(fontWeight = FontWeight.Bold))
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp({})
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp({})
    }
}