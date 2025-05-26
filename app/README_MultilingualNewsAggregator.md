# 🌐 Multilingual News Aggregator with AI Summarizer

An advanced Android app that fetches real-time news from multiple languages, summarizes content using AI, and provides a clean, user-friendly interface with theme support and news interaction features.

---

## ✨ Features

- 🌍 **Multilingual News** – Supports 10+ languages including English, Hindi, Telugu, French, German, Arabic, Japanese, and more.
- 🌓 **Light/Dark Theme Toggle**
- 📰 **Source Name and Publish Time** – Displayed for every article.
- 🧠 **Summary Toggle** – Show or hide AI-summarized content under each article.
- 🔗 **Open in Browser** – Tap any article to view in the browser.
- 🖼️ **News Images** – Each article shows its cover image.
- 🔍 **Search** – Search news by title or content.
- 🔥 **Trending Section** – Top 3 horizontal news carousel (upcoming).

---

## 🧑‍💻 Tech Stack

- **Jetpack Compose** – Modern UI toolkit for native Android.
- **Kotlin** – Language used for all layers.
- **Retrofit** – For API requests.
- **Hilt** – Dependency injection.
- **Room (upcoming)** – Offline caching.
- **Coil** – Image loading.
- **StateFlow** – State management.

---

## 📸 Screenshots

| Language Picker | Search | Share | Summary Toggle | Main UI |
|------------------|--------|-------|----------------|---------|
| ![](screenshots/languages.jpeg) | ![](screenshots/search.jpeg) | ![](screenshots/Share.jpeg) | ![](screenshots/ShowSummary.jpeg) | ![](screenshots/main.jpeg) |

---

## 🔑 Setup

1. Clone the repository:
```bash
git clone https://github.com/BhavyaMarripudi-1102/MultilingualNewsAggregatorWithAISummarizer.git
```
2. Open the project in **Android Studio**.
3. Add your NewsData.io API key in `MainActivity.kt` or wherever needed.
4. Run the app on your emulator or Android device.

---

## 📦 API Source

Powered by [NewsData.io](https://newsdata.io) – Provides multilingual, real-time news.

---

## 📄 License

This project is licensed under the MIT License – see [`LICENSE`](../LICENSE) for details.

---

## 🚀 Built By

**Bhavya Marripudi** with ❤️ using Kotlin + Jetpack Compose.