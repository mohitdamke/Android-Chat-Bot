package mohit.ai.chatbot.network

data class GeminiResponse(
    val candidates: List<Candidate>? = null
)

data class Candidate(
    val content: Content? = null
)

data class Content(
    val parts: List<Part>? = null
)

data class Part(
    val text: String? = null
)
