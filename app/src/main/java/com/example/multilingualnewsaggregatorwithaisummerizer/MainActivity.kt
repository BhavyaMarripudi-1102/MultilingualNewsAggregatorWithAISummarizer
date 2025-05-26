package com.example.multilingualnewsaggregatorwithaisummerizer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.multilingualnewsaggregatorwithaisummerizer.ui.screen.NewsScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsScreen(apiKey = "pub_da59d3d1f7594171a36250cfbd631505")
        }
    }
}