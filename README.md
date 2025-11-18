# 🤖 Android ChatBot Library (Powered by Google Gemini)

A plug-and-play AI chatbot UI for Android apps — written in **Kotlin + Jetpack Compose**.
Just initialize the SDK and launch the `ChatBotActivity` to get a fully functional AI chat screen.

---

## 📌 Preview

✨ Fully designed chat UI
✨ Modern input bar with loading state
✨ User & Bot chat bubbles
✨ Auto-scroll, clean spacing, smooth UX

---

## 🚀 Installation

### 1️⃣ Add JitPack to `settings.gradle`

```gradle
dependencyResolutionManagement {
    repositories {
        mavenCentral()
        maven { url "https://jitpack.io" }
    }
}
```

### 2️⃣ Add Library Dependency

```gradle
implementation("com.github.YOUR_GITHUB_USERNAME:android-chatbot:1.0.0")
```

> 🔁 Replace `mohitdamke` with your GitHub username.
> 🔁 Update the version tag when releasing new updates.

---

## 🔑 Add API Key

In `res/values/strings.xml`:

```xml
<string name="apiKey">YOUR_API_KEY_HERE</string>
```

---

## 💬 Usage

Add this to your `MainActivity.kt`:

```kotlin
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Initialize SDK (Required)
        ChatBot.initialize(getString(R.string.apiKey))

        // Launch ChatBot Screen
        startActivity(Intent(this, ChatBotActivity::class.java))
    }
}
```

That’s it — no extra setup needed!
The library will automatically load the full chat UI & Gemini conversation system.

---

## ⚙️ Minimum Requirements

| Component | Requirement                  |
| --------- | ---------------------------- |
| Android   | API 24+                      |
| Language  | Kotlin                       |
| UI        | Jetpack Compose (Material 3) |
| Internet  | Required                     |

---

## 🎨 Customization (Coming Soon)

| Feature                   | Status      |
| ------------------------- | ----------- |
| Theme color customization | 🟡 Upcoming |
| Profile/Bot icons         | 🟡 Upcoming |
| Voice Input               | 🔜          |
| Image Support             | 🔜          |
| Message timestamps        | 🔜          |

---

## 📦 Sample Integration Project

A demo app showing complete implementation is included inside:

```
/example/
```

(If you want, I can generate this folder for the repo.)

---

## 🧩 Library Architecture

* Jetpack Compose UI
* Material 3 Design
* MVVM Pattern
* Google Gemini API Integration
* Kotlin Coroutines + Flows

---

## 🐞 Issues & Contributions

Found a bug? Have a feature request?
Create an issue here on GitHub — contributions are welcome!

---

## ⭐ Support

If this library helped you, support the project by **giving a star ⭐**.
Your encouragement motivates further updates and features.

---

### 🔥 Author

**Mohit Damke (Android Developer)**
Built with ❤️ for developers who want to add AI to their apps easily.

---

### 📄 License

You can choose one of the following for your repo:

* MIT License (recommended for open usage)
* Apache 2.0 License
* Proprietary (if you want private/paid library later)
