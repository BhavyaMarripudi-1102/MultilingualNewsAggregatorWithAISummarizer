package com.example.multilingualnewsaggregatorwithaisummerizer.model

import com.google.gson.annotations.SerializedName

data class NewsResponse(
    val results: List<Article>?
)

data class Article(
    val title: String?,
    val description: String?,
    val link: String?,
    val image_url: String?,
    val source_name: String?,
    val pubDate: String?
)