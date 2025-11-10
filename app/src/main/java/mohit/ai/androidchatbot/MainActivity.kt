package mohit.ai.androidchatbot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import mohit.ai.androidchatbot.ui.theme.AndroidChatBotTheme
import mohit.ai.chatbot.ChatBot

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidChatBotTheme {
                ChatBot.reply(this, "Hello Raees! Library Connected 🚀")
            }
        }
    }
}