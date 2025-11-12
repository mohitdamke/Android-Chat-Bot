package mohit.ai.chatbot

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import mohit.ai.chatbot.network.GeminiClient
import mohit.ai.chatbot.network.GeminiRequest

object ChatBot {

    private var apiKey: String? = null
    private const val MODEL = "gemini-2.0-flash"

    fun initialize(apiKey: String) {
        this.apiKey = apiKey
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
