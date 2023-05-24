fun main()
{
    println("Privet!")
    var Me = Player("Гриша", 1, 1500)
    var Julia = Player("Julia", 2, 1600)
    Me.resfreshRating(Julia, 20)
    println(Me.playerELO)
}