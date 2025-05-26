package com.example.multilingualnewsaggregatorwithaisummerizer.ui.screen

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.multilingualnewsaggregatorwithaisummerizer.viewmodel.NewsViewModel

@Composable
fun NewsScreen(apiKey: String, viewModel: NewsViewModel = androidx.hilt.navigation.compose.hiltViewModel()) {
    val context = LocalContext.current
    var language by remember { mutableStateOf("en") }
    var expanded by remember { mutableStateOf(false) }
    var showSummaries by remember { mutableStateOf(false) }
    var searchQuery by remember { mutableStateOf("") }

    val articles by viewModel.articles
    val isLoading by viewModel.isLoading
    val errorMessage by viewModel.errorMessage

    val languages = listOf("en", "hi", "te", "fr", "es", "ar", "de", "ru", "zh", "ja", "pt", "it")

    LaunchedEffect(language) {
        viewModel.fetchNews(apiKey, language)
    }

    val filteredArticles = if (searchQuery.isBlank()) articles else articles.filter {
        it.title?.contains(searchQuery, ignoreCase = true) == true ||
                it.description?.contains(searchQuery, ignoreCase = true) == true
    }

    Column(modifier = Modifier.fillMaxSize().padding(12.dp)) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            TextButton(onClick = { expanded = true }) {
                Text("Language: ${language.uppercase()}", color = Color(0xFF6A1B9A))
            }
            DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                languages.forEach { lang ->
                    DropdownMenuItem(text = { Text(lang.uppercase()) }, onClick = {
                        language = lang
                        expanded = false
                    })
                }
            }
        }

        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            placeholder = { Text("Search articles...") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            Switch(checked = showSummaries, onCheckedChange = { showSummaries = it })
            Spacer(modifier = Modifier.width(8.dp))
            Text("Show Summaries")
        }

        Spacer(modifier = Modifier.height(8.dp))

        if (isLoading) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        } else if (!errorMessage.isNullOrEmpty()) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = errorMessage ?: "Unknown error", textAlign = androidx.compose.ui.text.style.TextAlign.Center)
            }
        } else {
            Text("Trending", style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(vertical = 8.dp))
            LazyRow(modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp)) {
                items(articles.take(3)) { article ->
                    Card(
                        modifier = Modifier
                            .padding(end = 12.dp)
                            .width(280.dp)
                            .clickable {
                                article.link?.let { url ->
                                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                                    context.startActivity(intent)
                                }
                            },
                        shape = MaterialTheme.shapes.medium,
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        Column {
                            article.image_url?.let { imageUrl ->
                                AsyncImage(
                                    model = imageUrl,
                                    contentDescription = null,
                                    modifier = Modifier.fillMaxWidth().height(140.dp),
                                    contentScale = ContentScale.Crop
                                )
                            }
                            Text(
                                text = article.title ?: "No Title",
                                style = MaterialTheme.typography.bodyLarge,
                                modifier = Modifier.padding(8.dp),
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }
                }
            }

            LazyColumn {
                items(filteredArticles) { article ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                            .clickable {
                                article.link?.let { url ->
                                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                                    context.startActivity(intent)
                                }
                            },
                        shape = MaterialTheme.shapes.medium,
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        Column {
                            article.image_url?.let { imageUrl ->
                                AsyncImage(
                                    model = imageUrl,
                                    contentDescription = null,
                                    modifier = Modifier.fillMaxWidth().height(200.dp),
                                    contentScale = ContentScale.Crop
                                )
                            }

                            Column(modifier = Modifier.padding(12.dp)) {
                                Text(
                                    text = article.title ?: "No Title",
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold
                                )

                                Spacer(modifier = Modifier.height(4.dp))

                                if (showSummaries) {
                                    Text(
                                        text = article.description ?: "No Description",
                                        style = MaterialTheme.typography.bodyMedium,
                                        maxLines = 4,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                    Spacer(modifier = Modifier.height(4.dp))
                                }

                                Row(
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text(
                                        text = article.source_name ?: "Unknown Source",
                                        style = MaterialTheme.typography.bodySmall,
                                        color = MaterialTheme.colorScheme.primary
                                    )
                                    Text(
                                        text = article.pubDate ?: "",
                                        style = MaterialTheme.typography.bodySmall
                                    )
                                }

                                Spacer(modifier = Modifier.height(4.dp))

                                TextButton(onClick = {
                                    val shareIntent = Intent(Intent.ACTION_SEND).apply {
                                        type = "text/plain"
                                        putExtra(Intent.EXTRA_SUBJECT, article.title ?: "News Article")
                                        putExtra(Intent.EXTRA_TEXT, article.link ?: "")
                                    }
                                    context.startActivity(Intent.createChooser(shareIntent, "Share via"))
                                }) {
                                    Text("Share")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}