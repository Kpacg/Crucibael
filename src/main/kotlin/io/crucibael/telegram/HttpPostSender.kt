package io.crucibael.telegram

import mu.KotlinLogging
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.util.concurrent.TimeUnit


class HttpPostSender {
    private val logger = KotlinLogging.logger {}

    private val client = OkHttpClient.Builder()
        .connectTimeout(3, TimeUnit.SECONDS)
        .writeTimeout(3, TimeUnit.SECONDS)
        .readTimeout(3, TimeUnit.SECONDS)
        .build()

    fun post(url: String, json: String = ""): String {
        logger.info("Start")

        val body: RequestBody = json.toRequestBody("application/json".toMediaType())
        val request: Request = Request.Builder()
            .url(url)
            .post(body)
            .build()

        val response = client.newCall(request).execute()
        logger.info("Received response with code [${response.code}]")
        return response.body!!.string().also {
            logger.info("Body: $it")
        }
    }
}

fun main() {
    val sender = HttpPostSender()
    val response = sender.post("https://api.telegram.org/bot6052489295%3AAAFXxjN45OQ16krJ8JuM2BWhX6o0i8F4qWE/getMe")
    println(response)
}