package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import com.example.androiddevchallenge.data.DataProvider
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.views.FactsColumn

class CatDetailActivity : AppCompatActivity(){
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            val catId = intent?.getIntExtra(ARGUMENT_CAT_ID, 0) ?: 0
            val cat = DataProvider.getCat(catId)
            
            setContent {
                MyTheme {
                    setContent {
                        Row() {
                            Text(text = "Nummer " + cat.id)
                            FactsColumn(facts = cat.facts)
                        }
                       
                    }
                }
            }
        }
    companion object {
        const val ARGUMENT_CAT_ID = "argument_cat_id"
    }
    }