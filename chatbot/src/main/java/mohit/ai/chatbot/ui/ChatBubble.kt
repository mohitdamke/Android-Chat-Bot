package mohit.ai.chatbot.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mohit.ai.chatbot.ChatBot
import mohit.ai.chatbot.common.copyToClipboard
import mohit.ai.chatbot.common.shareText
import mohit.ai.chatbot.model.ChatMessage

@Composable
fun ChatBubble(message: ChatMessage) {
    val context = LocalContext.current
    val config = ChatBot.uiConfig

    var showActions by remember { mutableStateOf(false) }

    val bubbleColor = if (message.isUser) config.userBubbleColor else config.botBubbleColor
    val textColor = if (message.isUser) config.userTextColor else config.botTextColor
    val iconRes = if (message.isUser) config.userIconRes else config.botIconRes
    val iconSize = if (message.isUser) config.userIconSize else config.botIconSize

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        horizontalArrangement = if (message.isUser) Arrangement.End else Arrangement.Start,
        verticalAlignment = Alignment.Bottom
    ) {

        // 👉 Bot Icon (left)
        if (!message.isUser && iconRes != null) {
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = "Bot Icon",
                modifier = Modifier
                    .size(iconSize)
                    .padding(end = 6.dp)
            )
        }

        Card(
            shape = RoundedCornerShape(config.bubbleCornerRadius),
            colors = CardDefaults.cardColors(containerColor = bubbleColor),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            modifier = Modifier
                .widthIn(max = 280.dp)
                .combinedClickable(
                    onClick = { showActions = false },
                    onLongClick = { showActions = true }
                )
        ) {
            Column(modifier = Modifier.padding(12.dp)) {
                Text(
                    text = message.text,
                    color = textColor,
                    fontSize = 16.sp
                )

                // ⚡ Actions (Copy & Share)
                if (showActions) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Icon(
                            imageVector = Icons.Default.ContentCopy,
                            contentDescription = "Copy",
                            modifier = Modifier
                                .size(20.dp)
                                .clickable {
                                    copyToClipboard(context, message.text)
                                    showActions = false
                                }
                        )
                        Spacer(modifier = Modifier.width(14.dp))
                        Icon(
                            imageVector = Icons.Default.Share,
                            contentDescription = "Share",
                            modifier = Modifier
                                .size(20.dp)
                                .clickable {
                                    shareText(context, message.text)
                                    showActions = false
                                }
                        )
                    }
                }
            }
        }

        // 👉 User Icon (right)
        if (message.isUser && iconRes != null) {
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = "User Icon",
                modifier = Modifier
                    .size(iconSize)
                    .padding(start = 6.dp)
            )
        }
    }
}
