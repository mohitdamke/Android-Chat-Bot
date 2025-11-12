package mohit.ai.chatbot.viewmodel

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import kotlinx.coroutines.launch
import mohit.ai.chatbot.ChatBot
import mohit.ai.chatbot.data.ChatRepository
import mohit.ai.chatbot.model.ChatMessage

class ChatViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = ChatRepository.getInstance(application)

    // Reactive state variables
    var messages = mutableStateListOf<ChatMessage>()
        private set

    var inputText = mutableStateOf("")
        private set

    var isLoading = mutableStateOf(false)
        private set

    init {
        // Load saved chats from local Room database
        viewModelScope.launch {
            val saved = repository.getMessages()
            messages.addAll(saved.map { ChatMessage(text = it.text, isUser = it.isUser) })
        }
    }

    fun onInputChange(value: String) {
        inputText.value = value
    }

    @RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
    fun sendMessage() {
        val text = inputText.value.trim()
        if (text.isEmpty() || isLoading.value) return

        inputText.value = ""
        messages.add(ChatMessage(text = text, isUser = true))
        viewModelScope.launch { repository.saveMessage(text, true) }

        messages.add(ChatMessage(text = "Typing...", isUser = false))
        isLoading.value = true

        viewModelScope.launch {
            val reply = ChatBot.ask(text)
            messages.removeLast()
            messages.add(ChatMessage(text = reply, isUser = false))
            repository.saveMessage(reply, false)
            isLoading.value = false
        }
    }

    fun clearChat() {
        viewModelScope.launch {
            repository.clearChat()
            messages.clear()
        }
    }
}
