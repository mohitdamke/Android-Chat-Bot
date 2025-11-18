# 🤖 Android ChatBot Library (Powered by Google Gemini)

A plug-and-play **AI Chatbot UI for Android** — built using **Kotlin + Jetpack Compose**.
Just initialize the SDK and launch `ChatBotActivity` to get a complete AI chat interface.

## 🔥 New Update — Copy & Share Messages

You can now copy or share any message directly inside the chat.

Action	Gesture
Show copy/share options	Long-press on any message
Hide the action buttons	Single tap on the message bubble

✔ Works for both user & bot messages
✔ Clean UI with smooth UX
✔ 100% optional — doesn't affect normal chatting

Normal	Actions Visible
| **Normal**                                                                                               | **Actions Visible**                                                                                      |
| -------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------- |
| <img src="https://github.com/user-attachments/assets/1111ba50-5b8d-49d2-8632-aed195db0a4c" width="330"/> | <img src="https://github.com/user-attachments/assets/af11c0c2-9d56-4acd-b136-ae931872368f" width="330"/> |



## 📌 Preview

<div align="center"> <img src="https://github.com/user-attachments/assets/cfb2a519-c384-4512-8ac0-c0e65376f1e3" width="320" /> &nbsp;&nbsp; <img src="https://github.com/user-attachments/assets/8562647e-55f0-435f-b401-29299c7b0953" width="320" /> </div> <br>

✨ Fully designed chat interface
✨ Modern input bar with loading state
✨ User/Bot message bubbles
✨ Auto scroll with smooth UX

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

### 2️⃣ Add library dependency

```gradle
implementation("com.github.mohitdamke:android-chatbot:1.0.0")

---

## 🔑 Add Gemini API Key

In `res/values/strings.xml`:

```xml
<string name="apiKey">YOUR_API_KEY_HERE</string>
```

---

## 💬 Usage

Add inside `MainActivity.kt`:

```kotlin
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Initialize SDK
        ChatBot.initialize(getString(R.string.apiKey))

        // Launch ChatBot Screen
        startActivity(Intent(this, ChatBotActivity::class.java))
    }
}
```

That's it 🎉
The chatbot screen will load with message history, bubbles, UI & Gemini conversation handling.

---

## 🎨 Customization (Full UI Control)

The library allows developers to **customize 100% of the UI** using `ChatBotUIConfig`.

### ✨ Example

```kotlin
ChatScreen(
    config = ChatBotUIConfig(
        userBubbleColor = Color(0xFF222222),
        botBubbleColor = Color.White,
        userTextColor = Color.White,
        botTextColor = Color.Black,
        bubbleCornerRadius = 22.dp,
        backgroundColor = Color(0xFF101012),

        userIconRes = R.drawable.my_profile,
        botIconRes = R.drawable.my_robot,

        userIconSize = 52.dp,
        botIconSize = 38.dp,

        inputBarColor = Color.DarkGray,
        sendButtonColor = Color(0xFF4CAF50)
    )
)
```

### 🧩 Supported Customization Options

| UI Component              | Customizable |
| ------------------------- | ------------ |
| Background Color          | ✅            |
| Chat Bubbles (User / Bot) | ✅            |
| Text Colors               | ✅            |
| Bubble Corner Radius      | ✅            |
| Profile Icons             | ✅            |
| Icon Size                 | ✅            |
| Input Bar UI              | ✅            |
| Send Button Color         | ✅            |

➡️ No code changes required — configuration only.

---

## ⚙️ Minimum Requirements

| Component | Requirement     |
| --------- | --------------- |
| Android   | API 24+         |
| Language  | Kotlin          |
| UI        | Jetpack Compose |
| Internet  | Required        |

---

## 📦 Sample Integration Project

Example app included inside:

```
/example/
```

(If missing — clone this repo and request it in Issues.)

---

## 🧩 Library Architecture

* Jetpack Compose UI
* Material 3 Design
* MVVM Pattern
* Kotlin Coroutines + Flows
* Google Gemini API Integration

---

## 🐞 Issues & Contributions

Found a bug or want new features?
🔗 Open an **Issue / Pull Request** — contributions are welcomed.

---

## ⭐ Support the project

If this project helped you:
👉 **Give a star ⭐ on GitHub** to support its development.

---

### 🔥 Author

**Mohit Damke — Android Developer**
Built with ❤️ for developers who want to integrate AI in minutes.

---

### 📄 License

You can choose one:

* MIT License (recommended)
* Apache 2.0
* Proprietary (if planning paid distribution later)

---
