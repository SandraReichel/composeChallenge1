package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
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
