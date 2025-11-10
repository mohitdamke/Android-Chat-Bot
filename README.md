# 🤖 Android ChatBot Library

A lightweight and modern **AI ChatBot library** for Android, built with **Kotlin** and **Jetpack Compose**.
This library makes it simple for developers to integrate conversational AI features (like Gemini API) into any Android app with minimal setup.

---

## 🚀 Features

✔️ Easy to integrate and use in any Android project
✔️ Built with Kotlin and Jetpack Compose
✔️ Lightweight — no unnecessary dependencies
✔️ Can connect with Gemini or any custom AI API
✔️ Customizable message UI
✔️ MVVM-friendly architecture

---

## 📦 Installation

### Step 1 — Add JitPack Repository

In your **project-level** `settings.gradle`:

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
    implementation("com.github.mohitdamke:AndroidChatBot:1.0.0")
}
```

> Replace `RaeesDev` and version with your GitHub username and release tag.

---

## ⚙️ Usage

### 🧩 Initialize and Use the ChatBot

```kotlin
import com.raees.chatbot.ChatBot

ChatBot.reply(context, "Hello from RaeesChatBot!")
```

✅ This displays a simple chatbot-style response.
You can extend it to show messages in your own Compose-based UI or integrate with an AI API.

---

### 💬 Integrate Gemini (Optional)

If you want real AI-powered replies, you can connect it to the Gemini API:

```kotlin
ChatBot.initialize(apiKey = "YOUR_GEMINI_API_KEY")

ChatBot.ask("Tell me something interesting!") { reply ->
    Log.d("ChatBot", reply)
}
```

---

## 🎨 Customization Options

| Function                                                  | Description              |
| --------------------------------------------------------- | ------------------------ |
| `setBotName("RaeesBot")`                                  | Sets custom chatbot name |
| `setTheme(isDark = true)`                                 | Enables dark mode UI     |
| `setCustomPrompt("You are a helpful Android assistant.")` | Sets a custom AI prompt  |

---

## 🧠 Tech Stack

* **Kotlin**
* **Jetpack Compose**
* **Coroutines + Flow**
* **MVVM Architecture**
* **Gemini API (optional)**

---

## 📂 Project Structure

```
AndroidChatBot/
 ┣ app/
 ┣ chatbot/
 ┃ ┣ src/main/java/com/raees/chatbot/
 ┃ ┃ ┣ ChatBot.kt
 ┃ ┃ ┣ ChatMessage.kt
 ┃ ┃ ┗ utils/
 ┃ ┗ build.gradle.kts
 ┣ settings.gradle.kts
 ┗ README.md
```

---

## 📸 Demo

*(Optional — Add a screenshot or GIF of your chatbot in action)*
Example:

```
![ChatBot Demo](https://github.com/RaeesDev/AndroidChatBot/blob/main/screenshots/demo.gif)
```

---

## 🧑‍💻 Contributing

Contributions are welcome!
To contribute:

1. Fork the repository
2. Create your feature branch (`feature/chat-ui`)
3. Commit your changes
4. Open a Pull Request 🚀

---

## 📄 License

```
MIT License

Copyright (c) 2025 Raees
Permission is hereby granted, free of charge, to any person obtaining a copy...
```

---

## 💼 Author

**👨‍💻 Raees**
📍 Android Developer | Kotlin | Jetpack Compose Enthusiast
🔗 [GitHub](https://github.com/mohitdamke)

---

## ⭐ Support

If you like this project, don’t forget to give it a **⭐ on GitHub** and share it with other Android developers!

---

Would you like me to **enhance this README** with a **Compose-based example UI snippet** (showing a working chatbot chat screen) so it looks even more professional and interactive on GitHub?
