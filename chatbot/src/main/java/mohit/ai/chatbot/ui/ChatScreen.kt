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
import mohit.ai.chatbot.config.ChatBotUIConfig

@RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
@Composable
fun ChatScreen(
    viewModel: ChatViewModel = viewModel(),
    config: ChatBotUIConfig = ChatBotUIConfig()   // 🔥 config injected here
) {

    val messages by remember { derivedStateOf { viewModel.messages } }
    val listState = rememberLazyListState()
    val scope = rememberCoroutineScope()

    // Auto-scroll when new messages arrive
    LaunchedEffect(messages.size) {
        if (messages.isNotEmpty()) {
            scope.launch { listState.animateScrollToItem(0) }
        }
    }

    Scaffold(
        containerColor = config.backgroundColor,   // 🔥 customizable background
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        bottomBar = {
            ChatInputBar(
                text = viewModel.inputText.value,
                onTextChange = viewModel::onInputChange,
                onSend = viewModel::sendMessage,
                isLoading = viewModel.isLoading.value,
            )
        }
    ) { padding ->

        LazyColumn(
            state = listState,
            reverseLayout = true,
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    PaddingValues(
                        start = 12.dp,
                        end = 12.dp,
                        top = 6.dp,
                        bottom = padding.calculateBottomPadding() + 6.dp
                    )
                )
                .background(config.backgroundColor),         // 🔥 customizable
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(messages.reversed()) { msg: ChatMessage ->
                ChatBubble(
                    message = msg,
                )
            }
        }
    }
}
