package io.crucibael.core

import java.util.Date

//tournament -> rounds -> meets
data class Tournament (val tournamentName: String, val numberOfRounds: Int, val location: String, val eventDay: Date, val teamTournament:Boolean = true)
{
    var tournamentParticipants = mutableListOf<Player>()
    var tournamentRounds = arrayListOf<Round>()
    var currentRound = 0
    fun start():Boolean {
        //1. Создать экземпляр первого раунда
        //2. Разбить игроков из списка tournamentParticipants на пары по рейтингу
        //3. Добавить получившиеся пары в список pairs первого раунда
        return TODO("Provide the return value")
    }

    fun nextRound():Boolean
    {
        if(currentRound >= numberOfRounds)
            return false
        //1. Создать экземпляр очередного раунда
        //2. Разбить игроков из списка tournamentParticipants на пары по результатам предыдущего раунда
        return TODO("Provide the return value")
    }
}

data class Round (val roundNumber:Int)
{
    var pairs = mutableListOf<Meet>()
}
data class Meet (val player1: Player, val player2: Player, var result:Int = 10)
{
    fun isEqual(otherMeet: Meet):Boolean =
        ((player1 == otherMeet.player2) && (player2 == otherMeet.player1)) || ((player1 == otherMeet.player1) && (player2 == otherMeet.player2))
}
data class Team(var teamName: String, var teamCity : String) {
    private var teamPlayers = mutableListOf<Player>()
    //var teamCaptain: Player
    open fun addPlayer(player: Player)
    {
        teamPlayers.add(player)
    }
    open fun removePlayer(player: Player): Boolean {
        return teamPlayers.remove(player)
    }
}
data class Player(val playerName: String, val playerFaction:String, val playerID: Int, var playerELO: Int = 1500){
    val playerCoefficient = 2.0
    fun resfreshRating(opponent: Player, result:Int)
    {
        playerELO += (playerCoefficient * (result - (20 / (1 + Math.pow(10.0, ((opponent.playerELO - playerELO).toDouble() / 400)))))).toInt()
    }
    //var playerTeam
}