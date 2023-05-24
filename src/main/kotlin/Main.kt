fun main()
{
    println("Privet!")
    var Me = Player("Гриша", 1, 2500)
    var Julia = Player("Julia", 2, 1000)
    Me.resfreshRating(Julia, 20)
    println(Me.playerELO)
}