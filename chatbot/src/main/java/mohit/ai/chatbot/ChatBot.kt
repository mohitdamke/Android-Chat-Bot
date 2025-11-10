package mohit.ai.chatbot

import android.content.Context
import android.widget.Toast

object ChatBot {
    fun reply(context: Context, userMessage: String) {
        Toast.makeText(context, "🤖 Bot says: $userMessage", Toast.LENGTH_SHORT).show()
    }
}
