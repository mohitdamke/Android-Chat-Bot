package mohit.ai.chatbot.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.launch
import mohit.ai.chatbot.viewmodel.ChatViewModel
import mohit.ai.chatbot.model.ChatMessage

@RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
@Composable
fun ChatScreen(viewModel: ChatViewModel = viewModel()) {
    val messages by remember { derivedStateOf { viewModel.messages } }
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    // Auto-scroll to the latest message
    LaunchedEffect(messages.size) {
        if (messages.isNotEmpty()) {
            coroutineScope.launch {
                listState.animateScrollToItem(0)
            }
        }
    }

    Scaffold(
        bottomBar = {
            ChatInputBar(
                text = viewModel.inputText.value,
                onTextChange = viewModel::onInputChange,
                onSend = viewModel::sendMessage,
                isLoading = viewModel.isLoading.value
            )
        }
    ) { padding ->
        LazyColumn(
            state = listState,
            reverseLayout = true, // 👈 Important for WhatsApp-style (bottom-up)
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color(0xFFF7F8FA))
                .padding(horizontal = 12.dp, vertical = 8.dp)
        ) {
            // 👇 reverse order so the latest message stays at the bottom visually
            items(messages.reversed()) { msg ->
                ChatBubble(message = msg)
            }
        }
    }
}
