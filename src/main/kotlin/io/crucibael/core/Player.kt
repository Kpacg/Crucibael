package io.crucibael.core

data class Player(val playerName: String, val playerFaction:String, val playerID: Int, var playerELO: Int = 1500)
{
    // TODO: Constructor with only playerID
    fun updateELO(result:Int)
    {
        // TODO:
    }
}
