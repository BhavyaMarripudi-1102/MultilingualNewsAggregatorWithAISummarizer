package com.example.multilingualnewsaggregatorwithaisummerizer.di

import com.example.multilingualnewsaggregatorwithaisummerizer.data.remote.NewsApiService
import com.example.multilingualnewsaggregatorwithaisummerizer.data.remote.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private const val BASE_URL = "https://newsdata.io/api/1/"

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideNewsApiService(retrofit: Retrofit): NewsApiService =
        retrofit.create(NewsApiService::class.java)

    @Provides
    @Singleton
    fun provideNewsRepository(apiService: NewsApiService): NewsRepository =
        NewsRepository(apiService)
}