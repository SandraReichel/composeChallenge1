package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.Cat
import com.example.androiddevchallenge.data.DataProvider
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.views.FactsColumn
import com.example.androiddevchallenge.ui.views.FeatureChip
import com.example.androiddevchallenge.ui.views.NameTag

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
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            TopAppBar(title = { Text(text = " Meet " + cat.name) })
            Box() {
                Image(
                    painter = painterResource(R.drawable.karli),
                    contentDescription = "cute cat",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
                Row() {
                    cat.features.forEach { feature ->
                        FeatureChip(feature = feature)
                    }
                }
            }
            NameTag(cat = cat)
            CatFacts(cat = cat)
        }

    }
}

@Composable
fun CatFacts(cat: Cat) {
    Column {
        Text(text = "Nummer " + cat.id)
        FactsColumn(facts = cat.facts)
    }
}

@Preview("Light2 Theme", widthDp = 360, heightDp = 640)
@Composable
fun CatLightPreview() {
    MyTheme {
        CatDetail(DataProvider.getCat(1))
    }
}

@Preview("Dark2 Theme", widthDp = 360, heightDp = 640)
@Composable
fun CatDarkPreview() {
    MyTheme(darkTheme = true) {
        CatDetail(DataProvider.getCat(0))
    }
}