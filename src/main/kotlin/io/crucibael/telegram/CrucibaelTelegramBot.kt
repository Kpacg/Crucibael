package io.crucibael.telegram

import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.methods.updates.GetUpdates
import org.telegram.telegrambots.meta.api.objects.Update

class CrucibaelTelegramBot (var botTokenName:String): TelegramLongPollingBot(botTokenName) {
    override fun getBotUsername(): String = "Crucibael_bot"

    override fun getBotToken(): String = "6052489295:AAGhHTAaJYalXRLMnyNhY_rX8QC1aCFqyqA"

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

    fun sendMessage(chatId: Long, text:String)
    {
        val message = SendMessage(chatId.toString(), text)
        execute(message)
    }
}