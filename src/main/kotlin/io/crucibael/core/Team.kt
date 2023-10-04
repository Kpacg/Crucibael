package io.crucibael.core

data class Team(var teamName: String, var teamCaptain:Player, var teamCity : String, val teamID : Int)
{
    private var teamPlayers = mutableListOf<Player>()
    fun addPlayer(player: Player)
    {
        // TODO:
    }
    fun removePlayer(player: Player)
    {
        // TODO:
    }
}
