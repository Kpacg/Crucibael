class Player constructor(var playerName: String, val playerID: Int, var playerELO: Int = 1500){
    var playerCoefficient = 5
    fun resfreshRating(opponent: Player, result:Int)
    {
        playerELO = playerELO + playerCoefficient*(
                result - (20/(1 - Math.pow(10.0, ((opponent.playerELO - playerELO).toDouble()/400)))).toInt())
    }
    //var playerTeam
}