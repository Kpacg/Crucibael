package io.crucibael.core

import java.time.LocalDateTime
import kotlin.math.roundToInt

data class Tournament(
    val tournamentName: String,
    val numberOfRounds: Int,
    val location: String,
    val eventDay: LocalDateTime,
    val teamTournament: Boolean = true
)
{
    private var tournamentParticipants = mutableListOf<Player>() //Список участников турнира
    private var tournamentTeamParticipants = mutableListOf<Team>() //Список команд-участниц турнира
    private var averageELO = 0 //Средний рейтинг игроков на турнире

    fun addPlayer(player:Player){
        //if(currentRoundNumber > 0 || LocalDate.now() > eventDay)
            //throw Exception("Турнир $tournamentName уже начался!")
        if(!tournamentParticipants.contains(player))
            tournamentParticipants.add(player)
        else
            throw Exception("Игрок ${player.playerName} уже участвует в турнире!")
    }
    fun addPlayer(playerID:Int)
    {
        // TODO:
    }

    fun addTeam(team: Team)
    {
        // TODO:
    }
    fun addTeam(teamID: Int)
    {
        // TODO:
    }

    fun removeTeam(team: Team)
    {
        // TODO:
    }

    fun removeTeam(teamID:Int)
    {
        // TODO:
    }
    fun removePlayer(candidate: Player)
    {
        if( !tournamentParticipants.remove(candidate))
            throw Exception("In $tournamentName there is no player ${candidate.playerName}!")
    }
    fun removePlayer(candidateID : Int)
    {
        val playerToRemove = tournamentParticipants.find { it.playerID  == candidateID}
        if( playerToRemove == null)
            throw Exception("In $tournamentName there is no player with $candidateID!")
        else
            tournamentParticipants.remove(playerToRemove)
    }
    fun updateAverageELO()
    {
        var eloSum = 0.0
        for(player in tournamentParticipants)
        {
            eloSum += player.playerELO
        }
        averageELO = (eloSum/tournamentParticipants.count()).roundToInt()
    }
}
