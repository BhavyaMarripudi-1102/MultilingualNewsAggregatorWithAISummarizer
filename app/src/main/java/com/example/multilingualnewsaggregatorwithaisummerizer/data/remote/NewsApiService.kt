package com.example.multilingualnewsaggregatorwithaisummerizer.data.remote

import com.example.multilingualnewsaggregatorwithaisummerizer.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    @GET("news")
    suspend fun getNews(
        @Query("apikey") apiKey: String,
        @Query("language") language: String
    ): NewsResponse
}