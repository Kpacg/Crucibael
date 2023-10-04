package io.crucibael.core

import java.time.LocalTime

//tourney keeper <-> tournament <-> players/teams
class TourneyKeeper (val tournament: Tournament)
{
    private var currentTour:Tour = Tour(1)
    private var isGoing = false

    private fun currentTourNumber():Int
    {
        return currentTour.tourNumber
    }
}

private data class Tour (val tourNumber:Int, val tourTime : LocalTime = LocalTime.of(3,0,0))
{

}


/*data class Tournament (val tournamentName: String, val numberOfRounds: Int, val location: String,
                       val eventDay: LocalDate, val teamTournament:Boolean = true)
{
    private var tournamentParticipants = mutableListOf<Player>() //Список участников турнира
    private var tournamentRounds = arrayListOf<Round>() //Список раундов турнира
    private var currentRoundNumber = 0 //Номер текущего раунда
    private var averageElo = 0 //Средний рейтинг игроков на турнире
    private var currentRound: Round = Round(1)
    fun addPlayer(candidate:Player){
        if(currentRoundNumber > 0 || LocalDate.now() > eventDay)
            throw Exception("Турнир $tournamentName уже начался!")
        if(!tournamentParticipants.contains(candidate))
            tournamentParticipants.add(candidate)
        else
            throw Exception("Игрок ${candidate.playerName} уже участвует в турнире!")
    }

    fun addPlayer(candidateID:Int)
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
    fun start():Boolean {
        //1. Создать экземпляр первого раунда
        tournamentRounds.add(currentRound)
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
            if(tournamentParticipants.indexOf(participant) + 1 <= tournamentParticipants.count()/2)
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
        currentRoundNumber++
        if(currentRoundNumber >= numberOfRounds)
            return false
        //1. Создать экземпляр очередного раунда
        currentRound = Round(currentRoundNumber)
        //2. Обновить результаты игроков в соответствии с полученными данными
        for(participant in tournamentParticipants) {
            var previousRoundMeet = tournamentRounds[currentRoundNumber - 1].pairs.find {
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

        var tournamentParticipantsClone: MutableList<Player> = mutableListOf()
        tournamentParticipantsClone.addAll(tournamentParticipants)

        var index = 1
        while(tournamentParticipantsClone.isNotEmpty())
        {
            if(index - 1 > tournamentParticipantsClone.count())
                throw Exception("Incorrect pairs in round $currentRoundNumber!")

            val currentMeet = Meet(tournamentParticipantsClone[0], tournamentParticipantsClone[index])
            var isOk = true
            for(round in tournamentRounds)
            {
                if(round.pairs.find { it.isEqual(currentMeet) } != null)
                {
                    isOk = false
                    index++
                    break
                }
            }
            if(isOk)
            {
                currentRound.pairs.add(currentMeet)
                tournamentParticipantsClone.removeAt(0)
                tournamentParticipantsClone.removeAt(index)
                index = 1;
            }
        }
        return true
    }
}*/



/*data class Team(var teamName: String, var teamCity : String) {
    private var teamPlayers = mutableListOf<Player>()
    //var teamCaptain: Player
    open fun addPlayer(player: Player)
    {
        teamPlayers.add(player)
    }
    open fun removePlayer(player: Player): Boolean {
        return teamPlayers.remove(player)
    }
}*/

/*data class Player(val playerName: String, val playerFaction:String, val playerID: Int, var playerELO: Int = 1500){
    private val playerCoefficient = 2.0
    var playerResult = 0
    var playerPath = 0
    fun refreshRating(opponent: Player, result:Int)
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
} */