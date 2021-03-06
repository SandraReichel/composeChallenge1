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
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.Cat
import com.example.androiddevchallenge.data.DataProvider
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.views.FactsColumn
import com.example.androiddevchallenge.ui.views.FeatureChip
import com.example.androiddevchallenge.ui.views.NameHugeTag

class CatDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val catId = intent?.getIntExtra(ARGUMENT_CAT_ID, 0) ?: 0
        val cat = DataProvider.getCat(catId)

        setContent {
            MyTheme {
                CatDetail(cat)
            }
        }
    }

    companion object {
        const val ARGUMENT_CAT_ID = "argument_cat_id"
    }
}

@Composable
fun CatDetail(cat: Cat) {
    Surface(color = MaterialTheme.colors.background) {

        Box(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Card(
                elevation = 8.dp, shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp, top = 250.dp)
                        .fillMaxWidth()
                        .fillMaxHeight()
                ) {
                    NameHugeTag(cat = cat)
                    Spacer(Modifier.padding(8.dp))
                    CatFacts(cat = cat)
                    Spacer(Modifier.padding(8.dp))
                    Text("This is the best cat ever. This eat loves cuddles and is super fun. ")
                    Spacer(Modifier.padding(8.dp))
                    Button(onClick = {}) {
                        Row() {
                            Icon(Icons.Filled.Favorite, contentDescription = null)
                            Text(" Adopt Now")
                        }
                    }
                }
            }
        }

        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            TopAppBar(title = { Text(text = " Meet " + cat.name) })
            Box(contentAlignment = Alignment.BottomEnd) {
                Image(
                    painter = painterResource(cat.image),
                    contentDescription = "cute cat",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
                Row {
                    cat.features.forEach { feature ->
                        FeatureChip(feature = feature)
                    }
                }
            }
        }
    }
}

@Composable
fun CatFacts(cat: Cat) {
    Column {
        FactsColumn(facts = cat.facts)
    }
}

@Preview("Light2 Theme", widthDp = 360, heightDp = 640)
@Composable
fun CatLightPreview() {
    MyTheme {
        CatDetail(DataProvider.getCat(3))
    }
}

@Preview("Dark2 Theme", widthDp = 360, heightDp = 640)
@Composable
fun CatDarkPreview() {
    MyTheme(darkTheme = true) {
        CatDetail(DataProvider.getCat(3))
    }
}
