package io.crucibael.core

import java.lang.Exception
import java.util.Date
import kotlin.math.roundToInt

//tournament -> rounds -> meets
data class Tournament (val tournamentName: String, val numberOfRounds: Int, val location: String, val eventDay: Date,
                       val teamTournament:Boolean = true)
{
    private var tournamentParticipants = mutableListOf<Player>() //Список участников турнира
    private var tournamentRounds = arrayListOf<Round>()
    private var currentRound = 0
    fun start():Boolean {
        //1. Создать экземпляр первого раунда
        val firstRound = Round(1)
        tournamentRounds.add(firstRound)
        var averageElo = 0
        var averageEloSum:Double = 0.0
        for(participant in tournamentParticipants)
            averageEloSum += (participant.playerELO/tournamentParticipants.count()).toDouble()
        averageElo = averageEloSum.roundToInt()
        //2. Разбить игроков из списка tournamentParticipants на пары по рейтингу
        if(tournamentParticipants.count()%2 != 0)
            tournamentParticipants.add(Player("ProxyBot","Unaligned",0,averageElo))
        val lowElo = mutableListOf<Player>()
        val highElo = mutableListOf<Player>()
        tournamentParticipants.sortBy {it.playerELO}
        for(participant in tournamentParticipants)
            if(tournamentParticipants.indexOf(participant) <= tournamentParticipants.count()/2)
                lowElo.add(participant)
            else
                highElo.add(participant)
        //3. Добавить получившиеся пары в список pairs первого раунда
        for(participant in highElo)
            firstRound.pairs.add(Meet(participant, lowElo[highElo.indexOf(participant)],0,0))
        return true
    }

    fun nextRound():Boolean
    {
        currentRound++
        if(currentRound >= numberOfRounds)
            return false
        //1. Создать экземпляр очередного раунда
        var nextRound = Round(currentRound)
        //2. Обновить результаты игроков в соответствии с полученными данными
        for(participant in tournamentParticipants) {
            var previousRoundMeet = tournamentRounds[currentRound - 1].pairs.find {
                it.player1.playerName == participant.playerName ||
                        it.player2.playerName == participant.playerName
            }
            if (previousRoundMeet != null) {
                participant.updatePlayerResult(previousRoundMeet)
            }
            else
                throw Exception()
        }

        //2. Разбить игроков из списка tournamentParticipants на пары по результатам предыдущего раунда
        tournamentParticipants.sortWith(compareBy<Player> {it.playerResult}.thenBy { it.playerPath })

        return TODO("Provide the return value")
    }
}

data class Round (val roundNumber:Int)
{
    var pairs = mutableListOf<Meet>()
}
data class Meet (val player1: Player, val player2: Player, var result1:Int = 0, var result2:Int = 0)
{
    fun isEqual(otherMeet: Meet):Boolean =
        ((player1 == otherMeet.player2) && (player2 == otherMeet.player1)) ||
                ((player1 == otherMeet.player1) && (player2 == otherMeet.player2))
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
    private val playerCoefficient = 2.0
    var playerResult = 0
    var playerPath = 0
    fun resfreshRating(opponent: Player, result:Int)
    {
        playerELO += (playerCoefficient * (result - (20 / (1 + Math.pow(10.0, ((opponent.playerELO - playerELO).toDouble() / 400)))))).toInt()
    }
    fun updatePlayerResult(lastRoundMeet:Meet)
    {
        val myResult:Int = if(lastRoundMeet.player1.playerName == playerName)
            lastRoundMeet.result1
        else
            lastRoundMeet.result2
        playerResult += myResult
        if(myResult > 10)
            playerPath++
        else
            playerPath = 0
    }
    //var playerTeam
}