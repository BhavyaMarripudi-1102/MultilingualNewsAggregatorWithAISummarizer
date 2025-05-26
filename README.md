# 🌐 Multilingual News Aggregator with AI Summarizer

An Android app built with **Kotlin**, **Jetpack Compose**, **Retrofit**, and **Hilt** that aggregates global news in multiple languages and provides **AI-generated summaries**.

---

## ✨ Features

- 🌍 Multilingual support: English, Hindi, Telugu, French, German, Spanish, Arabic, Chinese, Japanese, Portuguese, Italian, and more.
- 🕒 Published date and 📰 Source name
- 🖼️ Clean image-rich UI using Jetpack Compose
- 🔍 Real-time Search by keyword or topic
- 📈 Trending Section (horizontal carousel)
- 📤 Share articles with one click

---

## 📱 Tech Stack

| Layer      | Tech                                                                 |
|------------|----------------------------------------------------------------------|
| UI         | Jetpack Compose, Material3                                           |
| Language   | Kotlin                                                               |
| Architecture | MVVM with Hilt DI, StateFlow                                       |
| Networking | Retrofit, NewsData.io API                                            |
| Images     | Coil                                                                 |

---

## 🚀 Setup Instructions

1. **Clone this repo**
    ```bash
    git clone https://github.com/BhavyaMarripudi-1102/MultilingualNewsAggregatorWithAISummarizer.git
    ```

2. **Open the project in Android Studio**

3. **Insert your API key** from [NewsData.io](https://newsdata.io) in `MainActivity.kt`
    ```kotlin
    NewsApp(apiKey = "your_actual_api_key_here")
    ```

4. **Run the app** on an emulator or Android device

---

## 🔑 API Source

> This app is powered by **NewsData.io** — providing multilingual news articles via REST API.

Sign up for your own free API key at: [https://newsdata.io](https://newsdata.io)

---

## 📸 Screenshots

| Language Picker | Search | Share | Summary Toggle | Main UI |
|-----------------|--------|-------|----------------|---------|
| ![](screenshots/languages.jpeg) | ![](screenshots/search.jpeg) | ![](screenshots/share.jpeg) | ![](screenshots/summary.jpeg) | ![](screenshots/main.jpeg) |


## 🛡 License

This project is licensed under the MIT License – see the [`LICENSE`](app/LICENSE) file for details.

---

## 👤 Author

Developed by [Bhavya Marripudi](https://github.com/BhavyaMarripudi-1102)