package io.crucibael.core

import io.crucibael.telegram.CrucibaelTelegramBot
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession
import java.util.*
import kotlin.concurrent.schedule
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody

fun main()
{
    val botToken = "6052489295:AAFXxjN45OQ16krJ8JuM2BWhX6o0i8F4qWE"
    //Table -> Dictionary Team, Score/Rating -> Dictionary Team1 vs Team2 -> Table
    /*
    var Me = Player("Гриша", 1, 2500)
    var Julia = Player("Julia", 2, 1500)
    Me.resfreshRating(Julia, 20)
    println(Me.playerELO)
    var t = CountDownTimer(0, 0, 5)
    t.start()
    Timer().schedule(3000L) {
        t.stop()
    }
    val myBot = CrucibaelTelegramBot(botToken)
    val telegramBotsApi = TelegramBotsApi(DefaultBotSession::class.java)
    telegramBotsApi.registerBot(myBot)*/

    val client = OkHttpClient()

    val mediaType = "application/json".toMediaTypeOrNull()
    var body = "{\"url\":\"Empty\"}".toRequestBody(mediaType)
    var request = Request.Builder()
        .url("https://api.telegram.org/bot6052489295%3AAAFXxjN45OQ16krJ8JuM2BWhX6o0i8F4qWE/getMe")
        .post(body)
        .addHeader("accept", "application/json")
        .build()
    var response = client.newCall(request).execute()


    /*body = "{\"offset\":null,\"limit\":1,\"timeout\":0}".toRequestBody(mediaType)
    request = Request.Builder()
        .url("https://api.telegram.org/bot6052489295%3AAAFXxjN45OQ16krJ8JuM2BWhX6o0i8F4qWE/getUpdates")
        .post(body)
        .addHeader("accept", "application/json")
        .addHeader("content-type", "application/json")
        .build()

    response = client.newCall(request).execute()
    println(response.code)*/

    /* while(true)
     {
         var timer = Timer()
         timer?.schedule(100L)
         {
             myBot.
             myBot.onUpdateReceived(update = myBot.run {  })
             *

        }
    } */
}