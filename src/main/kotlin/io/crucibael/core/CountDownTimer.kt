package io.crucibael.core

import java.util.*
import kotlin.concurrent.schedule
class CountDownTimer(private var hours:Int = 0, private var minutes: Int = 0, private var seconds: Int = 0) {
    private var timer: Timer? = null

    fun start() {
        timer = Timer()
        timer?.schedule(1000L) {
            println("Elapsed time: " + hours.toString() + ":" + minutes.toString() + ":" + seconds.toString())
            if(seconds == 0)
            {
                if(minutes == 0)
                {
                    if(hours == 0)
                    {
                        return@schedule
                    }
                    else {
                        hours--
                        minutes = 59
                        seconds = 59
                    }
                }
                else
                {
                    minutes--
                }
                seconds = 59
            }
            else
                seconds--
            start()
        }
    }

    fun stop() {
        timer?.cancel()
    }

    // Пример использования класса
    fun example() {
        val timer = CountDownTimer()
        timer.start()
        // Через 30 секунд остановить таймер
        Timer().schedule(30000L) {
            timer.stop()
        }
    }
}