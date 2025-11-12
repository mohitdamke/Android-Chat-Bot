package mohit.ai.chatbot.data

import android.content.Context
import androidx.room.Room

class ChatRepository private constructor(context: Context) {

    private val db = Room.databaseBuilder(
        context.applicationContext,
        ChatDatabase::class.java,
        "chatbot_db"
    ).build()

    private val chatDao = db.chatDao()

    suspend fun saveMessage(text: String, isUser: Boolean) {
        chatDao.insertMessage(ChatEntity(text = text, isUser = isUser))
    }

    suspend fun getMessages(): List<ChatEntity> = chatDao.getAllMessages()

    suspend fun clearChat() = chatDao.clearAll()

    companion object {
        @Volatile private var instance: ChatRepository? = null

        fun getInstance(context: Context): ChatRepository {
            return instance ?: synchronized(this) {
                instance ?: ChatRepository(context).also { instance = it }
            }
        }
    }
}
