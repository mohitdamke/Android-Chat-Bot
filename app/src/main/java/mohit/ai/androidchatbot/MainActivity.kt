package mohit.ai.androidchatbot

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import mohit.ai.androidchatbot.ui.theme.AndroidChatBotTheme
import mohit.ai.chatbot.ChatBot
import mohit.ai.chatbot.ChatBotActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ChatBot.initialize(getString(R.string.apiKey))

        setContent {
            AndroidChatBotTheme {
                val intent = Intent(this, ChatBotActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
