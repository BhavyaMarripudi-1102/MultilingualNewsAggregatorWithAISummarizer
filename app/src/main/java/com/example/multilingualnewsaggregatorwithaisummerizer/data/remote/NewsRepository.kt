package com.example.multilingualnewsaggregatorwithaisummerizer.data.remote

import com.example.multilingualnewsaggregatorwithaisummerizer.model.Article
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val apiService: NewsApiService
) {
    suspend fun getNews(apiKey: String, language: String): List<Article> {
        return apiService.getNews(apiKey, language).results ?: emptyList()
    }
}