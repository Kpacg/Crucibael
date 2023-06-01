import java.util.*
import kotlin.concurrent.schedule

fun main()
{
    //Table -> Dictionary Team, Score/Rating -> Dictionary Team1 vs Team2 -> Table
    println("Privet!")
    /*
    var Me = Player("Гриша", 1, 2500)
    var Julia = Player("Julia", 2, 1500)
    Me.resfreshRating(Julia, 20)
    println(Me.playerELO)*/
    var t = CountDownTimer(0,0,5)
    t.start()
    Timer().schedule(3000L) {
        t.stop()
    }
}