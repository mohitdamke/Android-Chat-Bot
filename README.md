# 🤖 Android ChatBot Library

A **lightweight and modern AI ChatBot library** for Android, built using **Kotlin** and **Jetpack Compose**.
It allows developers to easily add an **AI-powered chat screen** (like Gemini) into their app — ready to use in just a few lines.

---

## 🚀 Features

✅ Ready-to-use Chat UI (like WhatsApp style)
✅ Connects with **Gemini API** or any custom AI API
✅ Built with **Jetpack Compose + MVVM**
✅ Lightweight and simple integration
✅ Auto-scrolls to the latest message
✅ Fully customizable

---

## 📦 Installation

### Step 1 — Add JitPack Repository

Add this inside your **project-level** `settings.gradle`:

```kotlin
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}
```

### Step 2 — Add the Library Dependency

In your **app-level** `build.gradle.kts`:

```kotlin
dependencies {
    implementation("com.github.RaeesDev:AndroidChatBot:1.0.0")
}
```

> Replace `RaeesDev` with your actual GitHub username and tag version.

---

## ⚙️ Setup

### Step 1 — Add API Key

In your **`res/values/strings.xml`**, add:

```xml
<string name="apiKey">YOUR_GEMINI_API_KEY</string>
```

---

## 💬 Usage (Just 2 Lines!)

In your `MainActivity.kt`:

```kotlin
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        ChatBot.initialize(getString(R.string.apiKey))  // Initialize your Gemini key

        setContent {
            AndroidChatBotTheme {
                val intent = Intent(this, ChatBotActivity::class.java)
                startActivity(intent) // 🚀 Opens ChatBot UI instantly
            }
        }
    }
}
```

That’s it!
Run your app and you’ll see a **WhatsApp-style chat screen** powered by Gemini AI 💬

---

## 🎨 Result

**✅ Example output:**

* You type: “Hi”
* Bot replies: “Hello there! How can I help you today?”

The messages appear at the **bottom**, with smooth scrolling like real chat apps.

---

## ⚙️ Optional: Customization

| Function                                          | Description          |
| ------------------------------------------------- | -------------------- |
| `setBotName("RaeesBot")`                          | Sets custom bot name |
| `setTheme(isDark = true)`                         | Enables dark mode    |
| `setCustomPrompt("You are a helpful assistant.")` | Changes AI behavior  |

---

## 🧠 Tech Stack

* Kotlin
* Jetpack Compose
* MVVM Architecture
* Coroutines
* Gemini API

---

## 📸 Demo

*(Optional – Add your own GIF or screenshot)*

```
![ChatBot Demo](https://github.com/RaeesDev/AndroidChatBot/blob/main/screenshots/demo.gif)
```

---

## 🧑‍💻 Author

**👨‍💻 Raees**
Android Developer | Kotlin | Jetpack Compose Enthusiast
🔗 [GitHub](https://github.com/RaeesDev)

---

## ⭐ Support

If you like this library, please give it a **⭐ on GitHub** — it really helps!

---

Would you like me to include a **small code snippet** showing how to get both user & bot messages (for custom UIs)?
It’ll make your README even more helpful for devs who want to use their own chat design.
