package com.example.multilingualnewsaggregatorwithaisummerizer.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.multilingualnewsaggregatorwithaisummerizer.data.remote.NewsRepository
import com.example.multilingualnewsaggregatorwithaisummerizer.model.Article
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val repository: NewsRepository
) : ViewModel() {

    private val _articles = mutableStateOf<List<Article>>(emptyList())
    val articles: State<List<Article>> = _articles

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    private val _errorMessage = mutableStateOf<String?>(null)
    val errorMessage: State<String?> = _errorMessage

    fun fetchNews(apiKey: String, language: String) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val result = repository.getNews(apiKey, language)
                _articles.value = result
                _errorMessage.value = if (result.isEmpty()) "No articles available." else null
            } catch (e: Exception) {
                _errorMessage.value = e.message ?: "Unknown error"
            } finally {
                _isLoading.value = false
            }
        }
    }
}