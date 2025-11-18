package mohit.ai.chatbot

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import mohit.ai.chatbot.config.ChatBotUIConfig
import mohit.ai.chatbot.network.GeminiClient
import mohit.ai.chatbot.network.GeminiRequest

object ChatBot {

    val version: String
        get() = BuildConfig.CHATBOT_VERSION
    private var apiKey: String? = null
    private const val MODEL = "gemini-2.0-flash"
    var uiConfig: ChatBotUIConfig = ChatBotUIConfig()
        private set
    fun initialize(apiKey: String, config: ChatBotUIConfig = ChatBotUIConfig()) {
        this.apiKey = apiKey
        this.uiConfig = config
        Log.d("ChatBot", "ChatBot Library initialized — v$version")

    }

    suspend fun ask(prompt: String): String {
        if (apiKey.isNullOrEmpty()) {
            return "⚠️ Please call ChatBot.initialize(apiKey) first!"
        }

        return withContext(Dispatchers.IO) {
            try {
                val service = GeminiClient.create()
                val response = service.generateContent(
                    apiKey = apiKey!!,
                    model = MODEL,
                    request = GeminiRequest(
                        contents = listOf(
                            mapOf("parts" to listOf(mapOf("text" to prompt)))
                        )
                    )
                )

                // ✅ Safely extract actual AI text
                val reply = response.candidates
                    ?.firstOrNull()
                    ?.content
                    ?.parts
                    ?.firstOrNull()
                    ?.text
                    ?.trim()
                    ?: "⚠️ No response from AI"

                reply
            } catch (e: Exception) {
                "❌ Error: ${e.localizedMessage ?: "Unknown error"}"
            }
        }
    }
}
