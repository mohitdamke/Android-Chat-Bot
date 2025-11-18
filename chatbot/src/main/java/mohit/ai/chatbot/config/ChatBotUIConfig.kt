package mohit.ai.chatbot.config

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import mohit.ai.chatbot.R

data class ChatBotUIConfig(
    val userBubbleColor: Color = Color(0xFFDCF8C6),
    val botBubbleColor: Color = Color.White,
    val userTextColor: Color = Color.Black,
    val botTextColor: Color = Color.Black,
    val bubbleCornerRadius: Dp = 16.dp,

    // Background
    val backgroundColor: Color = Color(0xFFF3F5F8),

    // Input bar
    val inputBarColor: Color = Color.White,
    val inputFieldColor: Color = Color(0xFFF2F3F7),
    val inputPlaceholder: String = "Message…",
    val sendButtonColor: Color = Color(0xFF2E6EF7),
    val sendButtonDisabledColor: Color = Color(0xFF9EB4F9),
    val sendIconTint: Color = Color.White,
    val textSize: TextUnit = 16.sp,

    // Icons
    val userIconRes: Int? = R.drawable.person,
    val botIconRes: Int? = R.drawable.robot,
    val userIconSize: Dp = 36.dp,
    val botIconSize: Dp = 36.dp
)
