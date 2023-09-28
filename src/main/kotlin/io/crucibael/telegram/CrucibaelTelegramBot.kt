package io.crucibael.telegram

import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.methods.updates.GetUpdates
import org.telegram.telegrambots.meta.api.objects.Update
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody

class CrucibaelTelegramBot (var botTokenName:String): TelegramLongPollingBot(botTokenName) {
    override fun getBotUsername(): String = "Crucibael_bot"

    override fun getBotToken(): String = "6052489295:AAFXxjN45OQ16krJ8JuM2BWhX6o0i8F4qWE"

    override fun onUpdateReceived(update: Update) {
        //обработка входящего сообщения
        if(update.hasMessage())
        {
            val message = update.message
            if(message.hasText())
            {
                val chatid = message.chatId
                val text = message.text
                when(text){
                    "START" -> sendMessage(chatid, "PRIVET")
                }
            }
        }
    }
    fun GetUpdates(): List<Update>{
        val client = OkHttpClient()

        val mediaType = "application/json".toMediaTypeOrNull()
        val body = RequestBody.create(mediaType, "{\"offset\":null,\"limit\":null,\"timeout\":null}")
        val request = Request.Builder()
            .url("https://api.telegram.org/bottoken/getUpdates")
            .post(body)
            .addHeader("accept", "application/json")
            .addHeader("User-Agent", "Telegram Bot SDK - (https://github.com/irazasyed/telegram-bot-sdk)")
            .addHeader("content-type", "application/json")
            .build()

        val response = client.newCall(request).execute()

    }
    fun sendMessage(chatId: Long, text:String)
    {
        val message = SendMessage(chatId.toString(), text)
        execute(message)
    }
}