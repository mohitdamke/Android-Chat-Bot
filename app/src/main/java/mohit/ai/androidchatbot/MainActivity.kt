package mohit.ai.androidchatbot

import android.R.attr.apiKey
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.crashlytics.FirebaseCrashlytics
import mohit.ai.androidchatbot.ui.theme.AndroidChatBotTheme
import mohit.ai.chatbot.ChatBot
import mohit.ai.chatbot.ChatBotActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        FirebaseApp.initializeApp(this)
        FirebaseCrashlytics.getInstance().isCrashlyticsCollectionEnabled = true
        signInAnonymously()
        ChatBot.initialize(BuildConfig.CHATBOT_API_KEY)

        setContent {
            AndroidChatBotTheme {
                val intent = Intent(this, ChatBotActivity::class.java)
                startActivity(intent)
            }
        }
    }
}

private fun signInAnonymously() {
    val auth = FirebaseAuth.getInstance()

    // Already logged in? Skip
    if (auth.currentUser != null) return

    auth.signInAnonymously()
        .addOnSuccessListener {
            FirebaseCrashlytics.getInstance().log("Anonymous login success → UID: ${it.user?.uid}")
        }
        .addOnFailureListener { e ->
            FirebaseCrashlytics.getInstance().recordException(e)
        }
}
