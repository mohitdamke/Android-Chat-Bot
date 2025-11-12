package mohit.ai.chatbot.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object GeminiClient {
    private const val BASE_URL = "https://generativelanguage.googleapis.com/"

    fun create(): GeminiApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GeminiApiService::class.java)
    }
}
